# Padrão Chain of Responsibility - Comportamental

## 🎯 Intenção
O **Chain of Responsibility** (Cadeia de Responsabilidade) é um padrão de projeto comportamental que permite passar solicitações ao longo de uma cadeia de handlers (tratadores). Ao receber uma solicitação, cada handler decide se processa a solicitação ou se a passa para o próximo handler na cadeia.

---

## 📋 Problema
Imagine que você está desenvolvendo um sistema de helpdesk/suporte técnico para uma empresa. Quando um cliente abre um ticket, o sistema precisa processar essa solicitação. Dependendo do problema (ex: redefinir senha simples ou servidor de banco de dados fora do ar), diferentes níveis de suporte técnico com permissões e conhecimentos distintos devem cuidar do chamado.

Se você colocar toda a lógica de tratamento em uma única classe gigantesca com condicionais complexas (`if-else`), o código se tornará:
- **Difícil de estender**: Adicionar um novo nível de suporte exigiria alterar a classe inteira.
- **Rígido e acoplado**: O cliente do suporte saberia exatamente qual atendente resolve qual problema.
- **Dificuldade na manutenção**: A classe acumula múltiplas responsabilidades que mudam por razões diferentes.

---

## ✅ Solução
O padrão Chain of Responsibility sugere que você transforme os tratadores individuais em objetos autônomos chamados *handlers*. Cada elo da cadeia contém uma referência para o próximo elo.

Quando o cliente envia uma requisição, ela entra no primeiro handler da cadeia. 
1. O handler avalia se é capaz de tratar o pedido.
2. Se puder resolver, ele processa e encerra a cadeia.
3. Se não puder resolver, ele delega a responsabilidade para o próximo handler da fila.
4. Se a requisição percorrer toda a cadeia e nenhum handler a resolver, ela atinge o fim da linha (onde um comportamento de erro ou pendência é acionado).

---

## 🏗️ Estrutura

### Componentes:
- **Handler (Tratador Base)**: Classe abstrata ou interface que define a interface para tratar as requisições e a forma de configurar o próximo tratador (`proximoHandler`).
- **Concrete Handlers (Tratadores Concretos)**: Classes concretas que estendem o tratador base e implementam o tratamento real. Se não puderem tratar, delegam para o próximo handler.
- **Client (Cliente)**: Monta a cadeia (geralmente uma única vez ou dinamicamente) e envia as solicitações para o primeiro elo da cadeia.

### No nosso exemplo:
- **SuporteHandler**: Classe base abstrata (**Handler**)
- **SuporteNivel1** / **SuporteNivel2** / **SuporteNivel3**: Classes de suporte técnico (**Concrete Handlers**)
- **Chamado**: Classe que encapsula a solicitação de suporte contendo sua criticidade/dificuldade.
- **ChainOfResponsibilityService**: Simula o envio de chamados para a cadeia (**Client**)

---

## 💡 Exemplo Prático - Suporte Técnico em Níveis

### Cenário
Encaminhar chamados de suporte técnico de acordo com sua dificuldade (`BAIXO`, `MEDIO`, `ALTO`, `CRITICO`). O primeiro elo tenta resolver; se não conseguir, delega para o próximo nível. Se for `CRITICO`, ultrapassa as capacidades do Nível 3 e fica pendente.

### Implementação

#### 1. Interface Comum (Handler)
[SuporteHandler.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/chainOfResponsibility/handler/SuporteHandler.java)
```java
public abstract class SuporteHandler {
    protected SuporteHandler proximoHandler;

    public SuporteHandler setNext(SuporteHandler proximoHandler) {
        this.proximoHandler = proximoHandler;
        return proximoHandler;
    }

    public abstract void processar(Chamado chamado);
}
```

#### 2. Tratadores Concretos (Concrete Handlers)
[SuporteNivel1.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/chainOfResponsibility/handler/SuporteNivel1.java)
```java
public class SuporteNivel1 extends SuporteHandler {
    @Override
    public void processar(Chamado chamado) {
        if (chamado.getNivel() == NivelDificuldade.BAIXO) {
            System.out.println("[Suporte Nível 1] Resolvendo chamado #" + chamado.getId());
            chamado.resolver("Suporte Técnico Nível 1 - Atendente de Triagem");
        } else if (proximoHandler != null) {
            proximoHandler.processar(chamado);
        }
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Pipelines de Filtros e Middlewares Web**
- Em servidores web (como Spring Security, Node.js Express ou ASP.NET Core), requisições HTTP passam por uma cadeia de middlewares (Autenticação -> Autorização -> CORS -> Logging -> Controller).

### 2. **Validação de Formulários / Processamento de Pedidos**
- Um pipeline de validação onde cada etapa valida regras de negócio distintas (Campos Obrigatórios -> Formato de E-mail -> Duplicidade no DB -> Limites de Crédito).

### 3. **Processamento de Eventos de Interface Gráfica (UI)**
- Em sistemas como JavaFX, Swing ou no próprio DOM do HTML/CSS, eventos (clique, teclado) sobem/descem pela hierarquia de componentes visuais (Bubbling/Capturing) até que um elemento o processe.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Princípio de Responsabilidade Única (SRP)**: Você pode desacoplar classes que enviam solicitações daquelas que as processam.
- **Princípio Aberto/Fechado (OCP)**: Permite introduzir novos tratadores na cadeia sem quebrar o código do cliente.
- **Flexibilidade**: Permite alterar dinamicamente a ordem dos tratadores em tempo de execução ou adicionar/remover elos.

### ❌ Desvantagens
- **Nenhuma Garantia de Tratamento**: Uma requisição pode chegar ao fim da cadeia sem ser processada por ninguém se não houver um handler padrão (fallback).
- **Dificuldade na Depuração**: O fluxo de execução indireto pode tornar o rastreamento (debug) de bugs complexo.
- **Overhead e Loops**: Se a cadeia contiver referências circulares acidentais, a execução pode entrar em loop infinito.

---

## 📚 Relação com Outros Padrões

- **Composite**: O Chain of Responsibility é frequentemente usado em conjunto com o Composite. Nesse caso, a requisição de um componente folha é repassada para o componente pai até o topo da árvore.
- **Command**: O Chain of Responsibility pode transportar objetos do tipo Command ao longo de sua cadeia, onde diferentes tratadores podem decidir executar ou refinar comandos específicos.
- **Decorator**: Ambos possuem estruturas recursivas semelhantes (envolvem delegação), mas o Decorator estende dinamicamente o comportamento sem quebrar a interface, enquanto o Chain of Responsibility processa logicamente a requisição e pode parar a execução.

---

## 🚀 Como Usar

1. **Defina** uma interface comum ou classe abstrata contendo o método de tratamento e a referência ao próximo elemento.
2. **Crie** classes de tratamento concretas implementando a lógica correspondente e delegando caso a condição de tratamento não seja satisfeita.
3. **Instancie** os elos da cadeia no código cliente e ligue-os usando o método de encadeamento.
4. **Envie** as requisições sempre ao primeiro elo da cadeia.
