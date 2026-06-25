# Padrão Observer - Comportamental

## 🎯 Intenção
O **Observer** (Observador) é um padrão de projeto comportamental que permite definir um mecanismo de assinatura para notificar múltiplos objetos sobre quaisquer eventos que aconteçam com o objeto que eles estão observando.

---

## 📋 Problema
Imagine que você tem dois tipos de objetos: um `Cliente` e uma `Loja`. O cliente está muito interessado em um modelo específico de celular (ex: "iPhone 16") que está atualmente esgotado.

- Se o cliente for até a loja todos os dias para checar a disponibilidade do produto, ele gastará tempo e recursos desnecessários (processamento inútil / polling).
- Se a loja enviar e-mails de notificação de estoque todos os dias para todos os clientes cadastrados, ela incomodará muitos clientes que não estão interessados naquele produto (spam / tráfego desnecessário).

O problema é: como um objeto (o cliente) pode ser notificado sobre mudanças de estado de outro objeto (o estoque da loja) de forma eficiente, sem gerar acoplamento rígido ou desperdício de processamento?

---

## ✅ Solução
O padrão Observer propõe que o objeto que possui o estado interessante (chamado de **Subject** ou **Publicador**) mantenha uma lista de referências de objetos interessados em seus eventos (chamados de **Observers** ou **Assinantes**).

O Subject expõe métodos públicos para que novos assinantes entrem na lista (`inscrever`) ou saiam dela (`desinscrever`).

Quando um evento de interesse acontece (ex: o produto chega ao estoque):
1. O Subject varre sua lista de inscritos.
2. Ele chama um método de notificação padrão (ex: `atualizar()`) declarado na interface comum dos Observers.
3. Cada assinante processa a atualização de acordo com sua necessidade (ex: um envia e-mail, outro envia SMS, outro escreve no log).

---

## 🏗️ Estrutura

### Componentes:
- **Subject (Sujeito / Publicador)**: Mantém a lista de observadores interessados e expõe métodos para gerenciar assinaturas. Dispara a notificação para todos os inscritos quando ocorrem alterações de estado.
- **Observer (Interface Observador)**: Define o método comum de atualização (`atualizar()`) que o publicador utilizará para notificar alterações.
- **Concrete Observers (Observadores Concretos)**: Classes que realizam ações específicas em resposta às notificações enviadas pelo publicador (ex: enviar E-mail, SMS, gerar log).
- **Client (Cliente)**: Cria os objetos publicador e observadores e registra os observadores no publicador.

### No nosso exemplo:
- **CanalNoticias**: A classe publicadora (**Subject**)
- **Observer**: A interface comum de notificação (**Observer**)
- **EmailSubscriber** / **SmsSubscriber**: As formas de notificação concretas (**Concrete Observers**)
- **ObserverService**: O código que simula as inscrições e publicações de notícias (**Client**)

---

## 💡 Exemplo Prático - Canal de Notícias (Newsletter)

### Cenário
Criar um canal de notícias sobre tecnologia onde leitores podem se inscrever para receber boletins informativos. Os leitores escolhem se preferem receber via e-mail ou SMS. A qualquer momento, um leitor pode cancelar sua assinatura para parar de receber os envios.

### Implementação

#### 1. Interface do Observador (Observer)
[Observer.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/observer/observer/Observer.java)
```java
public interface Observer {
    void atualizar(String noticia);
    String getNome();
}
```

#### 2. Publicador Central (Subject)
[CanalNoticias.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/observer/subject/CanalNoticias.java)
```java
public class CanalNoticias {
    private final String nomeCanal;
    private final List<Observer> inscritos = new ArrayList<>();
    private String ultimaNoticia;

    public CanalNoticias(String nomeCanal) { this.nomeCanal = nomeCanal; }

    public void inscrever(Observer observer) {
        inscritos.add(observer);
        System.out.println("[Canal " + nomeCanal + "] Novo inscrito: " + observer.getNome());
    }

    public void desinscrever(Observer observer) {
        inscritos.remove(observer);
        System.out.println("[Canal " + nomeCanal + "] Removido: " + observer.getNome());
    }

    public void publicarNoticia(String noticia) {
        this.ultimaNoticia = noticia;
        System.out.println("\n--- [" + nomeCanal.toUpperCase() + "]: \"" + noticia + "\" ---");
        notificarInscritos();
    }

    private void notificarInscritos() {
        for (Observer inscrito : inscritos) {
            inscrito.atualizar(ultimaNoticia);
        }
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Mecanismos de Eventos em Interfaces Gráficas (UI)**
- Em sistemas como JavaFX, Swing, JavaScript ou Android, adicionar ouvintes de clique (`button.addActionListener()`, `addEventListener('click')`) é a implementação direta do padrão Observer. A UI (Subject) notifica o Listener (Observer) quando um clique acontece.

### 2. **Sistemas de Monitoramento e Logs**
- Aplicações que monitoram telemetria (temperatura de hardware, consumo de CPU, erros HTTP) e disparam alertas para Slack, E-mail ou serviços de pager quando determinados limites são ultrapassados.

### 3. **Programação Reativa e Streams de Dados**
- Bibliotecas reativas (RxJava, Project Reactor, RxJS) estendem o conceito do Observer para tratar fluxos contínuos de dados (Streams) de maneira assíncrona.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Acoplamento Fraco**: O Subject não precisa conhecer detalhes internos dos Observers; ele apenas sabe que eles implementam a interface comum.
- **Princípio Aberto/Fechado (OCP)**: Você pode introduzir novos tipos de observadores (ex: notificação via Push no celular) sem modificar o código do publicador.
- **Relações Dinâmicas**: Inscrições podem ser adicionadas, removidas ou trocadas livremente em tempo de execução.

### ❌ Desvantagens
- **Ordem de Notificação Aleatória**: Os observadores são notificados em uma ordem indefinida (geralmente a ordem em que foram cadastrados), e não deve haver dependência de execução entre eles.
- **Vazamento de Memória (Memory Leaks)**: Se os observadores não forem desinscritos quando não forem mais necessários, o publicador manterá referências a eles na memória, impedindo que o Garbage Collector os libere (conhecido como *Lapsed Listener Problem*).

---

## 📚 Relação com Outros Padrões

- **Mediator**: O Mediator centraliza a comunicação de forma bidirecional de múltiplos objetos. O Observer cria conexões dinâmicas de notificação de um remetente para muitos ouvintes (fluxo unidirecional).
- **State**: O State altera comportamentos baseados no estado atual interno. O Observer reage externamente a mudanças de estado de outros objetos.
- **Chain of Responsibility**: A notificação no Observer é disparada simultaneamente para todos os observadores inscritos. No Chain of Responsibility, a requisição trafega elo por elo sequencialmente até que apenas um deles decida resolvê-la.

---

## 🚀 Como Usar

1. **Defina** a interface `Observer` com o método de recepção de eventos (`atualizar`).
2. **Crie** a classe `Subject` que gerencia a lista de observadores (com métodos `inscrever` e `desinscrever`).
3. **Crie** observadores concretos que assinam a interface `Observer` para processar os dados recebidos.
4. **Implemente** la lógica de notificação interna do `Subject`, varrendo e disparando o método `atualizar` de todos os inscritos.
5. **No cliente**, crie as instâncias e realize o processo de assinatura dinâmica.
