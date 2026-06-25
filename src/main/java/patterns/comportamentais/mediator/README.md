# Padrão Mediator - Comportamental

## 🎯 Intenção
O **Mediator** (Mediador) é um padrão de projeto comportamental que reduz as dependências caóticas entre objetos. O padrão restringe comunicações diretas entre os objetos e os força a colaborar apenas através de um objeto mediador.

---

## 📋 Problema
Imagine um sistema de chat dinâmico onde múltiplos usuários trocam mensagens constantemente. Se os usuários se comunicassem diretamente:
- Cada objeto de usuário precisaria manter uma lista de referências de todos os outros usuários na sala.
- Quando um novo usuário entrasse ou saísse do chat, todas as outras instâncias precisariam ser notificadas e atualizadas.
- O acoplamento seria caótico (uma malha densa de conexões do tipo $N$-para-$N$), tornando quase impossível reaproveitar um usuário em outro contexto de comunicação ou evoluir a lógica do chat sem quebrar o sistema.

---

## ✅ Solução
O padrão Mediator sugere que os objetos participantes (chamados de **Colleagues**) parem de conversar diretamente uns com os outros. 

Em vez disso, toda e qualquer comunicação relevante é direcionada a um objeto centralizador: o **Mediator** (ex: a Sala de Chat).
1. O objeto de usuário apenas envia sua mensagem para o mediador.
2. O mediador encapsula a lógica de roteamento das mensagens. Ele sabe exatamente quem está na sala, quem é moderador, quem está silenciado, etc.
3. O mediador repassa a mensagem aos destinatários adequados.
Como resultado, as conexões densas $N$-para-$N$ são substituídas por um acoplamento estrela do tipo $N$-para-$1$ com o mediador.

---

## 🏗️ Estrutura

### Componentes:
- **Mediator (Interface)**: Declara a interface para comunicações com os colegas, geralmente contendo métodos como `enviarMensagem()` e `registrarUsuario()`.
- **Concrete Mediator (Mediador Concreto)**: Implementa o comportamento de mediação, coordenando as comunicações e mantendo referências das instâncias dos colegas.
- **Colleague (Colega Base)**: Classe ou interface que define o relacionamento com o mediador. Cada colega armazena uma referência para o mediador.
- **Concrete Colleagues (Colegas Concretos)**: Classes que implementam comportamentos e utilizam o mediador para se comunicar indiretamente com outros colegas.

### No nosso exemplo:
- **Mediator**: A interface que define a comunicação do chat (**Mediator**)
- **ChatMediator**: A sala de chat que conecta os participantes (**Concrete Mediator**)
- **Usuario**: A classe base participante (**Colleague**)
- **UsuarioComum** / **UsuarioModerador**: Usuários reais da sala (**Concrete Colleagues**)
- **MediatorService**: Código demonstrativo que monta o chat (**Client**)

---

## 💡 Exemplo Prático - Sala de Chat Comum e Moderada

### Cenário
Implementar uma sala de chat onde usuários comuns enviam mensagens gerais que são propagadas aos demais usuários do grupo. Usuários do tipo Moderador têm formatação especial ao enviar mensagens e podem ter sua lógica de recebimento e moderação diferenciadas, tudo gerenciado por um mediador central.

### Implementação

#### 1. Interface do Mediador (Mediator)
[Mediator.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/mediator/mediator/Mediator.java)
```java
public interface Mediator {
    void enviarMensagem(String mensagem, Usuario remetente);
    void registrarUsuario(Usuario usuario);
}
```

#### 2. Colega Base (Colleague)
[Usuario.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/mediator/colleague/Usuario.java)
```java
public abstract class Usuario {
    protected final Mediator mediator;
    protected final String nome;

    public Usuario(Mediator mediator, String nome) {
        this.mediator = mediator;
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public abstract void enviar(String mensagem);
    public abstract void receber(String mensagem, String de);
}
```

---

## 🎯 Aplicações Práticas

### 1. **Torres de Controle de Tráfego Aéreo**
- O exemplo clássico do mundo real. Os pilotos dos aviões prestes a pousar ou decolar não conversam entre si para decidir quem pousa primeiro. Todos se comunicam exclusivamente com a Torre de Controle (o Mediador), que coordena os pousos e decolagens em segurança.

### 2. **Interfaces de Usuário (GUI) Complexas**
- Formulários de cadastro complexos onde marcar um checkbox (ex: "Trabalho Remoto") afeta a visibilidade de outros inputs, habilita botões de envio ou limpa campos de endereço. Colocar essa lógica nos próprios componentes visuais gera alto acoplamento. Um `CadastroMediator` resolve a comunicação centralizada.

### 3. **Arquitetura de Mensageria (Message Broker)**
- Em sistemas distribuídos, brokers como RabbitMQ, Apache Kafka ou barramentos de eventos atuam como mediadores. Microsserviços postam mensagens no broker e este distribui aos consumidores corretos, sem que os microsserviços conheçam a existência uns dos outros.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Acoplamento Fraco**: Reduz o acoplamento entre os vários colegas, permitindo modificá-los de forma isolada.
- **Princípio da Responsabilidade Única (SRP)**: Centraliza a lógica de interconexão e roteamento de dados complexos em um único objeto.
- **Reusabilidade de Componentes**: Torna os colegas independentes de seus cenários específicos de interação, facilitando sua reutilização em outros pontos do código.

### ❌ Desvantagens
- **Risco de Objeto Deus (God Object)**: O mediador central pode facilmente se tornar excessivamente complexo e acumular responsabilidades em excesso, tornando-se um gargalo de manutenção.

---

## 📚 Relação com Outros Padrões

- **Observer**: O Mediator e o Observer são frequentemente alternados. No Mediator, a comunicação é bidirecional e centralizada. No Observer, a comunicação flui do sujeito observado (Observable) para os ouvintes (Observers) em um fluxo de publicação de eventos unidirecional.
- **Facade**: O Facade simplifica uma interface para um subsistema de objetos unidirecionais. O Mediator centraliza a colaboração ativa entre objetos que interagem mutuamente em ambas as direções.
- **Singleton**: Muitas vezes, instâncias de Mediadores Concretos são implementadas como Singletons, pois uma única torre de controle de fluxo de dados é necessária para gerenciar a sala ou o fluxo de comunicação.

---

## 🚀 Como Usar

1. **Identifique** um conjunto de classes fortemente acopladas que interagem intensamente entre si.
2. **Declare** a interface `Mediator` descrevendo os métodos de comunicação desejados.
3. **Implemente** a classe `ConcreteMediator` mantendo referências e roteando os dados dos participantes.
4. **Altere** os objetos colegas (`Colleagues`) para aceitarem o `Mediator` no construtor e utilizarem-no no lugar de referências diretas de outros colegas.
5. **No cliente**, instancie e conecte os componentes.
