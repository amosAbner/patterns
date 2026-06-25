# Padrão State - Comportamental

## 🎯 Intenção
O **State** é um padrão de projeto comportamental que permite que um objeto altere seu comportamento quando seu estado interno muda. O objeto parecerá ter mudado de classe.

---

## 📋 Problema
Imagine que você tem um Reprodutor de Música (`ReprodutorMusica`). Ele possui comportamentos principais como `tocar()` e `parar()`. 
O comportamento desses métodos muda drasticamente baseado no estado atual da música:
- Se a música estiver **Parada**, `tocar()` inicia a reprodução do início. `parar()` não faz nada.
- Se a música estiver **Reproduzindo**, `tocar()` pausa a reprodução. `parar()` para a reprodução e zera o tempo.
- Se a música estiver **Pausada**, `tocar()` retoma a reprodução do ponto onde parou. `parar()` para a música e reseta para o início.

Se você implementar toda essa lógica diretamente dentro do `ReprodutorMusica` usando variáveis de estado comuns (Strings, Enums ou Booleanos), o seu código se transformará rapidamente em um emaranhado de condicionais (`if-else` ou `switch` aninhados):
```java
public void tocar() {
    if (estado == PLAYING) {
        // pausa
    } else if (estado == PAUSED) {
        // retoma
    } else if (estado == STOPPED) {
        // inicia
    }
}
```
Isso gera problemas como:
- **Alta Complexidade e Rígidez**: Mudar a lógica de um estado exige mexer em condicionais espalhadas por todos os métodos de ação.
- **Dificuldade de Extensão**: Adicionar um novo estado (ex: "Acelerado") exige alterar todas as estruturas condicionais de todos os métodos.
- **Violação do SRP e OCP**: O reprodutor é responsável por gerenciar a lógica de cada estado diferente em um único arquivo de código.

---

## ✅ Solução
O padrão State sugere que você crie novas classes para cada estado possível da aplicação (ex: `EstadoParado`, `EstadoReproduzindo`, `EstadoPausado`) e extraia todos os comportamentos específicos desses estados para dentro dessas classes.

O objeto original (o **Contexto**, ex: `ReprodutorMusica`) mantém uma referência para um objeto de estado atual (`estado`) que implementa uma interface comum (`State`).

Ao invés de processar o comportamento internamente, o Contexto delega o trabalho para o estado atual:
1. Quando `tocar()` é chamado no reprodutor, ele executa `estado.tocar(this)`.
2. A classe de estado ativa toma a decisão, executa a ação e, se necessário, transiciona o Contexto para um novo estado (por exemplo, `EstadoReproduzindo` muda o estado do player para `EstadoPausado`).
3. O contexto apenas gerencia a transição de um estado para o outro, mantendo o código limpo e extensível.

---

## 🏗️ Estrutura

### Componentes:
- **Context (Contexto)**: O objeto que armazena a referência para o estado atual e expõe a interface pública para o cliente. Ele delega as chamadas de método ao estado ativo.
- **State (Interface Estado)**: Declara a interface padrão com métodos correspondentes a cada ação que varia de comportamento (ex: `tocar()`, `parar()`).
- **Concrete States (Estados Concretos)**: Classes que implementam comportamentos específicos de cada estado e gerenciam as transições para os próximos estados do Contexto.

### No nosso exemplo:
- **ReprodutorMusica**: A classe que armazena o estado ativo e expõe ações (**Context**)
- **State**: A interface comum de controle de estados (**State**)
- **EstadoParado** / **EstadoReproduzindo** / **EstadoPausado**: As lógicas de cada estado (**Concrete States**)
- **StateService**: O cliente que faz a simulação das mudanças de estado (**Client**)

---

## 💡 Exemplo Prático - Reprodutor de Música Digital

### Cenário
Simular um tocador de áudio simplificado. O cliente executa chamadas sucessivas de `tocar()` e `parar()` e o player se comporta e altera de estado dinamicamente (de Parado para Reproduzindo, de Reproduzindo para Pausado, etc.).

### Implementação

#### 1. Interface de Estado (State)
[State.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/state/state/State.java)
```java
public interface State {
    void tocar(ReprodutorMusica reprodutor);
    void parar(ReprodutorMusica reprodutor);
}
```

#### 2. Estado Concreto de Exemplo (EstadoReproduzindo)
[EstadoReproduzindo.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/state/state/EstadoReproduzindo.java)
```java
public class EstadoReproduzindo implements State {
    @Override
    public void tocar(ReprodutorMusica reprodutor) {
        System.out.println("[Reprodutor] Pausando a reprodução da música.");
        reprodutor.setEstado(new EstadoPausado());
    }

    @Override
    public void parar(ReprodutorMusica reprodutor) {
        System.out.println("[Reprodutor] Parando a reprodução e voltando ao início.");
        reprodutor.setEstado(new EstadoParado());
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Máquinas de Estado (FSM) em Sistemas de E-commerce**
- O processamento de um pedido passa por múltiplos estados: `PedidoCriado` -> `AguardandoPagamento` -> `Pago` -> `Enviado` -> `Entregue` -> `Cancelado`. A lógica de ações como `cancelarPedido()` ou `atualizarEndereco()` depende inteiramente do estado atual.

### 2. **Personagens e IA em Jogos (Games)**
- Um inimigo em um jogo pode ter estados: `Vigiando` (anda aleatoriamente), `Perseguindo` (corre em direção ao jogador) e `Atacando` (dispara golpes). O comportamento da física e IA do jogo muda totalmente a cada frame dependendo do estado ativo.

### 3. **Conexões de Rede (Sockets)**
- O comportamento de envio e recebimento de dados depende do estado da conexão (`Closed`, `Listen`, `SynSent`, `Established`).

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Princípio da Responsabilidade Única (SRP)**: Organiza o código relacionado a estados particulares em classes separadas.
- **Princípio Aberto/Fechado (OCP)**: Permite introduzir novos estados e novas regras de transição sem alterar o Contexto ou as classes de estados existentes.
- **Eliminação de Condicionais**: Remove loops e verificações condicionais caóticas do Contexto, melhorando a leitura do código.
- **Estados Explícitos**: Garante que o objeto não entre em estados inválidos e torna as transições explícitas.

### ❌ Desvantagens
- **Aumento no Número de Classes**: Se o sistema possuir poucos estados que raramente mudam de comportamento, aplicar o padrão adiciona classes e interfaces desnecessárias.

---

## 📚 Relação com Outros Padrões

- **Strategy**: Ambos possuem estruturas idênticas (baseadas em composição e delegação). No entanto, no Strategy os algoritmos são geralmente configurados de forma fixa e não conhecem uns ao outros. No State, as classes de estados conhecem os demais estados e ativamente modificam o estado do Contexto.
- **Flyweight**: Estados Concretos que não possuem estado interno dinâmico (imutáveis) podem ser compartilhados como Flyweights/Singletons para poupar memória e evitar instanciações redundantes.

---

## 🚀 Como Usar

1. **Identifique** a classe Contexto que possui comportamentos variantes orientados ao estado.
2. **Defina** a interface `State` contendo os métodos de ações variantes.
3. **Crie** classes concretas para cada estado possível da aplicação, implementando as reações de cada método e a lógica de transição para outros estados.
4. **Adicione** um campo do tipo `State` na classe Contexto e implemente um método `setEstado(State)` para transições dinâmicas.
5. **Delegue** as chamadas de métodos de ação da classe Contexto para a instância de estado ativo (`estado.acao(this)`).
