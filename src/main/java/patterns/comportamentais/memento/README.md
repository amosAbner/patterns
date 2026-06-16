# Padrão Memento - Comportamental

## 🎯 Intenção
O **Memento** é um padrão de projeto comportamental que permite capturar e externalizar o estado interno de um objeto sem violar seu encapsulamento, para que o objeto possa ser restaurado para este estado mais tarde.

---

## 📋 Problema
Imagine que você está desenvolvendo um editor de texto ou um editor gráfico. O usuário escreve textos ou arrasta formas, mas eventualmente comete um erro e deseja desfazer a ação anterior (o clássico `Ctrl+Z`).

Para implementar essa funcionalidade de desfazer (Undo), o seu sistema precisa salvar snapshots do estado do documento em momentos específicos. No entanto:
- Se expusermos todos os campos privados do editor (como conteúdo, cor e cursor) para que um serviço externo crie um backup, estaremos violando regras básicas de **encapsulamento** (expondo detalhes internos de implementação).
- Se tentarmos fazer cópias completas do editor, o objeto pode ser pesado demais ou acoplar o histórico a detalhes internos que podem mudar no futuro.

---

## ✅ Solução
O padrão Memento sugere que você delegue a criação do snapshot para o próprio objeto que possui o estado (o **Originator**). Somente o Originator tem permissão para ler seus campos internos e criar um objeto de backup chamado **Memento**.

Os Mementos são mantidos por uma classe gerenciadora de histórico chamada **Caretaker** (Zeladora). A sacada principal é que o Caretaker enxerga o Memento apenas como uma "caixa preta" e não pode ler ou alterar seus dados internos. Ele apenas armazena e repassa os Mementos de volta ao Originator quando o usuário solicita uma restauração (Undo).

---

## 🏗️ Estrutura

### Componentes:
- **Originator (Originador)**: O objeto que possui o estado a ser salvo. Ele cria novos Mementos e restaura seu estado a partir de um Memento fornecido.
- **Memento (Lembrança)**: Objeto imutável que armazena os dados do Originator. Ele possui duas interfaces: uma ampla para o Originator (que lê seus dados) e uma restrita para o Caretaker (que apenas o transporta).
- **Caretaker (Zelador)**: Classe responsável por gerenciar e manter os Mementos em uma pilha ou lista. Ele nunca inspeciona ou modifica o Memento.

### No nosso exemplo:
- **EditorTexto**: O Originador contendo o estado mutável do texto (**Originator**)
- **EditorMemento**: O snapshot que armazena o texto de forma imutável (**Memento**)
- **Historico**: O gerenciador de histórico baseado em uma pilha (**Caretaker**)
- **MementoService**: O cliente que faz edições e simula operações de desfazer (**Client**)

---

## 💡 Exemplo Prático - Desfazer em Editor de Texto

### Cenário
Simular um editor de texto básico onde a cada trecho significativo digitado salvamos um checkpoint. Ao detectar um trecho digitado incorretamente, acionamos a operação de desfazer para retornar ao estado anterior.

### Implementação

#### 1. O Objeto Memento (Imutável)
[EditorMemento.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/memento/memento/EditorMemento.java)
```java
public class EditorMemento {
    private final String texto;

    public EditorMemento(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
```

#### 2. O Originador (Originator)
[EditorTexto.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/memento/originator/EditorTexto.java)
```java
public class EditorTexto {
    private String texto = "";

    public String getTexto() { return texto; }
    public void escrever(String novoTexto) { this.texto += novoTexto; }

    public EditorMemento salvar() {
        return new EditorMemento(texto);
    }

    public void restaurar(EditorMemento memento) {
        if (memento != null) {
            this.texto = memento.getTexto();
        }
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Mecanismos de Desfazer e Refazer (Undo/Redo)**
- Editores de texto (Word, VS Code), softwares de edição de imagem (Photoshop) e ferramentas de diagramação (Draw.io) salvam o estado interno do documento a cada comando para permitir o rollback de ações.

### 2. **Salvar Checkpoints em Jogos**
- Jogos de videogame que possuem recurso de "Quick Save" ou salvamento automático antes de lutas contra chefes. O estado do jogo (vida do herói, monstros vivos, itens coletados) é encapsulado em um Memento e persistido.

### 3. **Transações e Rollbacks em Banco de Dados**
- Transações complexas na memória que, em caso de erro no meio do processo, precisam retornar exatamente ao estado inicial para não corromper os dados em memória.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Preservação de Encapsulamento**: Permite tirar fotos do estado de um objeto sem precisar expor os detalhes de sua estrutura interna para outras classes.
- **Simplificação do Originador**: O Originator não precisa gerenciar o histórico de suas versões anteriores; essa responsabilidade é delegada inteiramente ao Caretaker.
- **Histórico Sequencial Confiável**: Oferece uma forma segura de registrar estados sucessivos que podem ser percorridos de trás para frente.

### ❌ Desvantagens
- **Consumo Elevado de Memória**: Se o estado for muito grande ou se o usuário salvar snapshots com muita frequência, a pilha de Mementos pode consumir muita memória RAM.
- **Ciclo de Vida do Caretaker**: O Caretaker precisa rastrear o ciclo de vida do Originator para remover Mementos obsoletos e evitar vazamento de memória (memory leaks).
- **Custo de Clonagem**: O custo de alocar e inicializar novos mementos repetidamente pode impactar a performance.

---

## 📚 Relação com Outros Padrões

- **Command**: O Command e o Memento podem ser usados juntos. Os comandos executam operações no Originator, e cada comando pode guardar um Memento antes de rodar, facilitando a implementação do método `undo()` do próprio comando.
- **Prototype**: O Memento pode ser visto como um clone do estado interno do objeto. Em alguns casos, pode ser implementado usando o padrão Prototype para clonar subobjetos complexos.
- **State**: O padrão State gerencia comportamentos baseados no estado atual, enquanto o Memento foca em reverter e restaurar o estado a um momento anterior do tempo.

---

## 🚀 Como Usar

1. **Identifique** quais propriedades do Originador precisam ser guardadas para possibilitar a restauração.
2. **Crie** uma classe Memento imutável com esses campos.
3. **Adicione** os métodos `salvar()` (retorna Memento) e `restaurar(Memento)` dentro da classe Originador.
4. **Crie** a classe Caretaker contendo uma estrutura de dados (ex: Pilha) para empilhar e desempilhar os Mementos.
5. **No cliente**, dispare o `salvar()` antes de realizar mudanças destrutivas no Originador e guarde o Memento no Caretaker.
