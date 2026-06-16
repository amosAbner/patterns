# Padrão Command - Comportamental

## 🎯 Intenção
O **Command** é um padrão de projeto comportamental que transforma uma solicitação em um objeto independente que contém toda a informação sobre a solicitação. Essa transformação permite parametrizar clientes com diferentes solicitações, enfileirar ou registrar solicitações no histórico e suportar operações que podem ser desfeitas (undo).

---

## 📋 Problema
Imagine que você está construindo um aplicativo de automação residencial (Smart Home). Você deseja projetar um controle remoto com botões programáveis. Cada botão pode ser associado a diferentes aparelhos: ligar a luz da sala, ligar o ar condicionado do quarto, ou abrir a porta da garagem.

Se você associar a lógica dos aparelhos diretamente dentro dos botões do controle remoto:
- O controle remoto ficaria **acoplado** a cada tipo de dispositivo físico.
- Fica difícil alterar dinamicamente o que cada botão faz em tempo de execução.
- Adicionar novos aparelhos exigiria modificar e testar a classe do controle remoto repetidamente.
- Seria extremamente complexo implementar um botão global de "desfazer a última ação" (Undo).

---

## ✅ Solução
O padrão Command sugere que a classe disparadora (o **Invoker**, como o controle remoto) não envie a solicitação diretamente para o objeto de negócio final (o **Receiver**, como a luz ou ar condicionado).

Em vez disso:
1. Extraímos os detalhes da solicitação em uma classe separada chamada **Command** que implementa uma interface padrão (geralmente com o método `execute()` e `undo()`).
2. O controle remoto apenas armazena referências para a interface `Command`.
3. Quando um botão é pressionado, o controle remoto chama `execute()` no comando associado, sem precisar saber qual dispositivo real receberá a ordem e o que ele fará.

---

## 🏗️ Estrutura

### Componentes:
- **Command (Interface)**: Declara a interface padrão para execução de operações (normalmente `execute()` e `undo()`).
- **Concrete Commands (Comandos Concretos)**: Implementam a interface Command e vinculam uma ação específica a um objeto destinatário (Receiver).
- **Receiver (Destinatário)**: A classe que contém a lógica de negócio real para executar o trabalho (ex: Luz, ArCondicionado).
- **Invoker (Disparador)**: O objeto que inicia o comando (ex: ControleRemoto). Ele guarda referências aos comandos e os executa.
- **Client (Cliente)**: Instancia os Receivers, cria os Commands necessários associando-os aos Receivers e configura o Invoker.

### No nosso exemplo:
- **Command**: A interface base com os métodos `execute` e `undo` (**Command**)
- **LigarLuzCommand** / **DesligarLuzCommand** / **AjustarArCondicionadoCommand**: Classes de comandos concretos (**Concrete Commands**)
- **Luz** / **ArCondicionado**: Os dispositivos físicos (**Receiver**)
- **ControleRemoto**: O controle programável (**Invoker**)
- **CommandService**: O código de demonstração (**Client**)

---

## 💡 Exemplo Prático - Controle Remoto Inteligente

### Cenário
Programar um controle remoto residencial para ligar e desligar luzes de cômodos e ajustar a temperatura de aparelhos de ar condicionado, com capacidade de reverter as ações executadas através do histórico de chamadas.

### Implementação

#### 1. Interface Comum (Command)
[Command.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/command/command/Command.java)
```java
public interface Command {
    void execute();
    void undo();
}
```

#### 2. Dispositivo Real (Receiver)
[Luz.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/command/receiver/Luz.java)
```java
public class Luz {
    private final String comodo;
    private boolean ligada = false;

    public Luz(String comodo) { this.comodo = comodo; }
    public void ligar() {
        this.ligada = true;
        System.out.println("[Luz] A luz do(a) " + comodo + " foi LIGADA.");
    }
    public void desligar() {
        this.ligada = false;
        System.out.println("[Luz] A luz do(a) " + comodo + " foi DESLIGADA.");
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Botões de UI e Menu Items**
- Interfaces gráficas onde um clique de botão (ex: Salvar, Copiar) dispara um comando. O botão não precisa saber a lógica interna de salvamento de arquivos, ele apenas chama `command.execute()`.

### 2. **Histórico de Comandos e Undo/Redo Completo**
- Sistemas que guardam pilhas de comandos executados para desfazer e refazer edições sucessivas, como editores vetoriais ou planilhas.

### 3. **Filas de Tarefas (Job Queueing) e Agendamentos**
- Enfileiramento de comandos para execução em background. Como comandos são objetos completos, eles podem ser serializados, guardados no banco de dados e processados posteriormente por threads trabalhadoras.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Desacoplamento Completo**: Separa a classe que invoca a operação da classe que sabe como realizá-la.
- **Princípio Aberto/Fechado (OCP)**: Permite adicionar novos comandos à aplicação sem alterar as classes existentes.
- **Composição de Comandos (Macro Commands)**: É muito simples juntar múltiplos comandos em um só comando composto (ex: comando "Sair de Casa" desliga todas as luzes e o ar condicionado de uma só vez).

### ❌ Desvantagens
- **Proliferação de Classes**: Pode criar muitas pequenas classes de comando individuais para cada ação específica do sistema, aumentando a complexidade estrutural.

---

## 📚 Relação com Outros Padrões

- **Chain of Responsibility**: Pode ser combinado com o Command para passar o objeto Command por uma cadeia de processadores até encontrar o handler correto.
- **Memento**: Pode ser usado em conjunto com o Command para salvar snapshots do estado anterior do Receiver antes do comando executar, permitindo implementar rollback complexo no método `undo()`.
- **Prototype**: Pode ser útil quando for necessário clonar um Command existente antes de colocá-lo na fila de histórico.

---

## 🚀 Como Usar

1. **Declare** a interface Command com o método `execute()` e o método opcional `undo()`.
2. **Crie** as classes de comandos concretos que recebem a instância do Receiver no construtor.
3. **Implemente** o método `execute()` delegando a chamada para as funções correspondentes no Receiver.
4. **Configure** a classe Invoker para receber referências do Command e acionar sua execução sob demanda.
5. **Instancie** e conecte todos os componentes no código cliente.
