# Padrão Composite - Estrutural

## 🎯 Intenção
O **Composite** é um padrão de projeto estrutural que permite que você componha objetos em estruturas de árvore e então trabalhe com essas estruturas como se elas fossem objetos individuais.

---

## 📋 Problema
Imagine que você precise desenvolver um sistema de arquivos ou um catálogo de produtos onde existem dois tipos principais de objetos:
1. **Itens Simples**: Como arquivos comuns ou produtos unitários.
2. **Itens Compostos (Containers)**: Como pastas ou caixas de produtos, que podem conter tanto itens simples quanto outros itens compostos.

Se tentarmos tratar estes objetos de forma distinta, o código cliente ficará repleto de checagens de tipo (`if (item instanceof Folder)`), tornando a manutenção complexa, propensa a erros e acoplada a implementações específicas.

---

## ✅ Solução
O padrão Composite sugere que você trabalhe com itens Simples e Compostos por meio de uma **Interface Comum** que declara operações que fazem sentido para ambos.

- Para um item simples (Folha), a operação executa a ação direta.
- Para um item composto (Composite), a operação delega o trabalho para seus elementos filhos, acumula os resultados e retorna o valor final de forma transparente.

---

## 🏗️ Estrutura

### Componentes:
- **Component (Componente)**: Interface ou classe abstrata que declara a interface comum para todos os elementos (folhas e compostos) da árvore.
- **Leaf (Folha)**: Representa os objetos finais da composição (não possuem filhos). Define o comportamento de elementos primitivos.
- **Composite (Composto)**: Representa os objetos que possuem filhos. Implementa métodos para gerenciar filhos (`add`, `remove`) e delega as operações de negócio para os elementos filhos.
- **Client (Cliente)**: Manipula todos os elementos da estrutura através da interface `Component`.

### No nosso exemplo:
- **FileSystemItem**: Interface comum (**Component**)
- **File**: Classe que representa arquivos individuais (**Leaf**)
- **Folder**: Classe que representa pastas/diretórios (**Composite**)
- **CompositeService**: Cliente que consome a estrutura uniformemente

---

## 💡 Exemplo Prático - Sistema de Arquivos

### Cenário
Criar uma árvore de arquivos e diretórios onde possamos navegar na estrutura e obter o tamanho total de qualquer pasta de maneira uniforme, sem nos importarmos se um item é um arquivo único ou uma pasta inteira.

### Implementação

#### 1. Interface Comum (Component)
[FileSystemItem.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/composite/component/FileSystemItem.java)
```java
package patterns.estruturais.composite.component;

public interface FileSystemItem {
    String getName();
    long getSize();
    void print(String indent);
}
```

#### 2. Classe Folha (Leaf)
[File.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/composite/leaf/File.java)
```java
package patterns.estruturais.composite.leaf;

import patterns.estruturais.composite.component.FileSystemItem;

public class File implements FileSystemItem {
    private final String name;
    private final long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() { return name; }

    @Override
    public long getSize() { return size; }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📄 " + name + " (" + formatSize(size) + ")");
    }

    private String formatSize(long sizeInBytes) {
        // Formata bytes para KB/MB de maneira legível...
    }
}
```

#### 3. Classe Composta (Composite)
[Folder.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/composite/composite/Folder.java)
```java
package patterns.estruturais.composite.composite;

import patterns.estruturais.composite.component.FileSystemItem;
import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) { this.name = name; }

    @Override
    public String getName() { return name; }

    public void add(FileSystemItem item) { children.add(item); }
    public void remove(FileSystemItem item) { children.remove(item); }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemItem child : children) {
            totalSize += child.getSize(); // Delegação recursiva
        }
        return totalSize;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📁 " + name + "/ (Tamanho total: " + formatSize(getSize()) + ")");
        for (FileSystemItem child : children) {
            child.print(indent + "  ");
        }
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Árvores de Documento (DOM / XML / JSON)**
- A manipulação de tags HTML ou elementos JSON (onde um nó pode ser um valor textual simples ou um array/objeto contendo outros nós).

### 2. **Componentes visuais de UI**
- Frameworks gráficos (como Swing, JavaFX ou HTML) tratam elementos (botões, inputs) e containers (painéis, divs) com interfaces parecidas, permitindo adicionar componentes dentro de outros componentes.

### 3. **Processamento de Expressões Matemáticas**
- Compiladores que utilizam árvores de sintaxe abstrata (AST) para avaliar expressões, onde operadores (`+`, `*`) são composites e operandos (`1`, `2`) são folhas.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Polimorfismo e Transparência**: O cliente pode tratar estruturas complexas e objetos individuais de forma idêntica.
- **Princípio Aberto/Fechado (OCP)**: Permite introduzir novos tipos de componentes (folhas ou composites) na árvore sem quebrar o código cliente existente.
- **Facilidade de navegação**: Facilita a recursão em estruturas hierárquicas.

### ❌ Desvantagens
- **Dificuldade em restringir tipos**: Pode se tornar muito difícil restringir que tipos de componentes podem ou não ser adicionados a um composite em tempo de compilação.
- **Projeto excessivamente genérico**: A interface comum pode acabar declarando métodos que não fazem sentido para a Leaf (por exemplo, `add` ou `remove` em arquivos), forçando a Leaf a lançar exceções ou ignorar a chamada caso optemos por segurança sobre transparência.

---

## 📚 Relação com Outros Padrões

- **Builder**: Frequentemente usado na criação de árvores Composite complexas.
- **Flyweight**: Permite compartilhar folhas (Leaves) para economizar memória quando a estrutura da árvore é gigantesca.
- **Iterator**: Muito comum para varrer os elementos de um composite.
- **Visitor**: Usado para executar operações sobre toda a árvore composite sem precisar alterar o código das classes Leaf ou Composite.

---

## 🚀 Como Usar

1. **Defina** a interface comum (`FileSystemItem`) que expõe as ações de interesse.
2. **Implemente** a Leaf (`File`) para os componentes que não contêm filhos.
3. **Implemente** o Composite (`Folder`) que mantém uma lista de componentes e propaga as chamadas dos métodos recursivamente.
4. **Use** o polimorfismo no cliente para processar toda a estrutura dinamicamente.
