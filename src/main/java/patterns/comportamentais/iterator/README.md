# Padrão Iterator - Comportamental

## 🎯 Intenção
O **Iterator** é um padrão de projeto comportamental que permite percorrer elementos de uma coleção sem expor sua representação subjacente (seja ela uma lista, pilha, árvore, tabela hash, etc.).

---

## 📋 Problema
Imagine que você tem uma biblioteca de músicas e deseja criar uma Playlist. Uma playlist armazena um conjunto de músicas. 
Conforme sua aplicação evolui, você pode decidir armazenar essas músicas de diferentes formas:
- Em um `ArrayList` simples.
- Em um `HashSet` para evitar repetições.
- Em uma árvore binária para manter as músicas ordenadas por título.

O problema é que se o seu código cliente precisar tocar as músicas, ele precisará conhecer os detalhes da estrutura de dados interna (ex: loops com índices, manipulação de nós ou ponteiros). Se mudarmos a estrutura do repositório de músicas, o cliente quebrará. 

Além disso, e se quisermos diferentes formas de percorrer as músicas? Por exemplo:
1. Tocar em ordem sequencial.
2. Tocar apenas músicas de um gênero específico.
3. Tocar em ordem aleatória (Shuffle).

Poluir a classe da coleção com todos esses algoritmos de travessia diferentes torna a coleção gigante e difícil de manter.

---

## ✅ Solução
O padrão Iterator propõe que você extraia o comportamento de travessia de uma coleção para um objeto independente chamado **Iterator**.

O objeto Iterator encapsula todos os detalhes da travessia, tais como a posição atual e quantos elementos restam na sequência. Com isso:
1. Múltiplos iteradores podem percorrer a mesma coleção de forma totalmente independente ao mesmo tempo.
2. A coleção fica limpa, sendo responsável apenas por armazenar os dados e instanciar os iteradores sob demanda.
3. O cliente interage com os elementos por meio de uma interface simples (`hasNext()` e `next()`), ficando totalmente isolado da estrutura de dados real (seja vetor, árvore ou lista).

---

## 🏗️ Estrutura

### Componentes:
- **Iterator (Interface)**: Declara as operações necessárias para percorrer uma coleção (geralmente `hasNext()` e `next()`).
- **Concrete Iterators (Iteradores Concretos)**: Implementam algoritmos específicos para percorrer a coleção. Eles devem manter o estado da travessia (ex: índice atual).
- **Iterable Collection (Interface de Coleção)**: Declara um ou mais métodos para obter iteradores compatíveis com a coleção.
- **Concrete Collection (Coleção Concreta)**: Implementa os métodos de criação de iteradores e retorna instâncias dos iteradores concretos correspondentes, passando a si mesma (ou seus dados) no construtor.

### No nosso exemplo:
- **Iterator**: Interface de navegação genérica (**Iterator**)
- **SequentialIterator** / **GeneroIterator**: Implementações concretas de iteração (**Concrete Iterators**)
- **IterableCollection**: Interface que expõe as fábricas de criação de iteradores (**Iterable Collection**)
- **Playlist**: A classe que armazena a lista física de músicas (**Concrete Collection**)
- **Musica**: O modelo de dados armazenado.
- **IteratorService**: O cliente que faz uso dos iteradores para tocar a playlist (**Client**)

---

## 💡 Exemplo Prático - Playlist de Músicas com Diferentes Travessias

### Cenário
Criar uma playlist de músicas e disponibilizar dois tipos de travessias: uma que percorre todas as músicas de forma sequencial padrão, e outra que filtra e percorre apenas as músicas pertencentes a um gênero específico (ex: "Rock" ou "Jazz").

### Implementação

#### 1. Interface Comum do Iterador (Iterator)
[Iterator.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/iterator/iterator/Iterator.java)
```java
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

#### 2. Coleção Concreta (Playlist)
[Playlist.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/iterator/collection/Playlist.java)
```java
public class Playlist implements IterableCollection<Musica> {
    private final List<Musica> musicas = new ArrayList<>();

    public void adicionarMusica(Musica musica) { musicas.add(musica); }
    public List<Musica> getMusicas() { return musicas; }

    @Override
    public Iterator<Musica> criarIteratorSequencial() {
        return new SequentialIterator(this);
    }

    @Override
    public Iterator<Musica> criarIteratorPorGenero(String genero) {
        return new GeneroIterator(this, genero);
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Estrutura Interna das Coleções de Linguagens de Programação**
- O Java Collection Framework (`List`, `Set`, `Map`) fornece métodos para obter iteradores (`list.iterator()`), o que possibilita o funcionamento da sintaxe simplificada do `for-each` (`for (Type item : list)`).

### 2. **Navegação em Estruturas de Árvores / Grafos**
- Em compiladores ou gerenciadores de dados geográficos, navegar por árvores complexas (ex: largura, profundidade, em-ordem, pré-ordem) é simplificado ao criar iteradores especializados para cada algoritmo de busca.

### 3. **Paginação de Resultados de Bancos de Dados**
- Carregar milhões de registros de uma query de uma só vez estouraria a memória. Um iterador de banco de dados (ex: `ResultSet` ou paginação do Spring Data) busca blocos (cursor/chunks) dinamicamente sob demanda.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Princípio da Responsabilidade Única (SRP)**: Limpa as classes de coleção movendo os algoritmos de travessia para classes separadas.
- **Princípio Aberto/Fechado (OCP)**: Permite implementar novos tipos de coleções ou novos tipos de iteradores sem quebrar o código cliente existente.
- **Iterações Paralelas e Independentes**: Dois iteradores podem ler a mesma lista em velocidades e posições diferentes sem interferência mútua.
- **Acesso Uniforme**: O cliente pode iterar sobre qualquer coleção complexa usando exatamente a mesma sintaxe básica.

### ❌ Desvantagens
- **Uso Desnecessário para Coleções Simples**: Se a sua aplicação trabalha apenas com listas simples e vetores pequenos que não precisam de travessias complexas, aplicar o padrão adiciona complexidade desnecessária.
- **Performance**: Acessar itens indiretamente através de uma camada extra de objetos de iteradores pode ter um custo ligeiramente maior do que um loop direto com índice em certas coleções de alta performance.

---

## 📚 Relação com Outros Padrões

- **Composite**: Iterators são comumente utilizados para navegar de forma recursiva através de nós e galhos de estruturas Composite complexas.
- **Factory Method**: Coleções concretas utilizam métodos de fabricação (Factory Method) para instanciar e retornar os iteradores corretos.
- **Memento**: Pode ser usado junto com o Iterator para capturar o estado atual do cursor de navegação, permitindo restaurar a posição de travessia mais tarde.

---

## 🚀 Como Usar

1. **Defina** a interface genérica `Iterator<T>` com `hasNext()` e `next()`.
2. **Declare** a interface `IterableCollection` para as coleções que disponibilizam iteração.
3. **Crie** iteradores concretos implementando os algoritmos de busca (sequencial, filtrado, invertido, etc.).
4. **Implemente** as coleções concretas retornando instâncias corretas dos iteradores desejados.
5. **No cliente**, consuma a coleção por meio do iterador gerado, protegendo o código contra alterações na estrutura interna da coleção.
