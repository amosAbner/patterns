# Padrão Flyweight - Estrutural

## 🎯 Intenção
O **Flyweight** (Peso-Mosca) é um padrão de projeto estrutural que permite a você carregar mais objetos na quantidade de memória RAM disponível compartilhando estados comuns entre múltiplos objetos, ao invés de manter todos os dados em cada objeto individualmente.

---

## 📋 Problema
Imagine que você queira criar um simulador florestal ou um jogo de estratégia em tempo real onde existem milhões de árvores ou soldados renderizados simultaneamente na tela.
Cada árvore ou soldado possui dados como:
- Coordenadas 3D de localização (X, Y, Z).
- Angulação e escala.
- Modelo 3D, texturas de alta resolução, cor da folhagem/fardamento.

Se você instanciar milhões desses objetos individualmente, a memória RAM do computador do usuário irá esgotar em segundos devido à duplicação desnecessária de grandes texturas e modelos idênticos.

---

## ✅ Solução
O padrão Flyweight sugere que você pare de armazenar dados redundantes dentro dos objetos. Em vez disso, você deve dividir o estado do objeto em duas categorias:

1. **Estado Intrínseco (Shared State)**: Dados constantes que contêm informações de peso (texturas pesadas, sprites, cores) e que são idênticos em muitos objetos. Ele deve ser imutável e armazenado em um objeto Flyweight separado (`TreeType`).
2. **Estado Extrínseco (Context State)**: Dados variantes que são únicos para cada instância do objeto (como as coordenadas X e Y onde o objeto deve ser desenhado). Ele é passado de fora para os métodos do Flyweight quando executados.

Para gerenciar o reaproveitamento desses objetos compartilhados, introduz-se uma Fábrica (`TreeFactory`), que gerencia o cache dos tipos criados.

---

## 🏗️ Estrutura

### Componentes:
- **Flyweight**: Classe que armazena a parte do estado original que pode ser compartilhada entre múltiplos objetos (estado intrínseco).
- **Flyweight Factory (Fábrica)**: Gerencia o ciclo de vida dos objetos flyweight. Retorna instâncias existentes ou cria novas se não encontrar no cache.
- **Context (Contexto)**: Contém o estado extrínseco, único entre todos os objetos originais, e a referência para o objeto Flyweight compartilhado correspondente.
- **Client (Cliente)**: Calcula ou armazena o estado extrínseco dos flyweights e os planta/gerencia.

### No nosso exemplo:
- **TreeType**: A classe compartilhada contendo nome da espécie, cor e textura (**Flyweight**)
- **TreeFactory**: A fábrica gerenciadora de cache (**Flyweight Factory**)
- **Tree**: A classe leve que contém coordenadas x e y específicas (**Context**)
- **Forest**: A floresta contendo a lista de árvores (**Client**)

---

## 💡 Exemplo Prático - Floresta Digital

### Cenário
Plantar milhões de árvores mantendo em memória apenas as poucas espécies de árvore existentes (Carvalho, Pinheiro, etc.) e mapeando individualmente apenas as suas coordenadas X e Y.

### Implementação

#### 1. O Objeto Flyweight (Estado Intrínseco)
[TreeType.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/flyweight/flyweight/TreeType.java)
```java
package patterns.estruturais.flyweight.flyweight;

public class TreeType {
    private final String name;
    private final String color;
    private final String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Desenhando arvore '" + name + "' [Cor: " + color + "] na posicao (" + x + ", " + y + ")");
    }
}
```

#### 2. Fábrica de Flyweights (Cache)
[TreeFactory.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/flyweight/factory/TreeFactory.java)
```java
package patterns.estruturais.flyweight.factory;

import patterns.estruturais.flyweight.flyweight.TreeType;
import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "_" + color + "_" + texture;
        TreeType result = treeTypes.get(key);
        if (result == null) {
            result = new TreeType(name, color, texture);
            treeTypes.put(key, result);
        }
        return result;
    }
}
```

#### 3. O Contexto Leve (Estado Extrínseco)
[Tree.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/flyweight/context/Tree.java)
```java
package patterns.estruturais.flyweight.context;

import patterns.estruturais.flyweight.flyweight.TreeType;

public class Tree {
    private final int x;
    private final int y;
    private final TreeType type; // Referência compartilhada

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y); // Repassa o estado extrínseco por parâmetro
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Mecanismos de Jogos Eletrônicos (Game Engines)**
- Renderização de grama, florestas, partículas de fumaça, balas disparadas na tela ou hordas de inimigos repetitivos em jogos como RTS ou RPG.

### 2. **Processadores de Texto (Text Editors)**
- Em um editor como o Microsoft Word, cada caractere digitado é um objeto. Armazenar a fonte, o tamanho e o estilo de cada um individualmente consumiria gigabytes de memória. Em vez disso, o caractere físico é o Flyweight e sua posição na linha é o estado extrínseco.

### 3. **Pools de Conexões ou String Pools**
- O String Pool da JVM do Java aproveita o padrão Flyweight: strings literais idênticas apontam para a mesma referência na tabela de constantes internas da JVM.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Economia Drástica de Memória**: Permite instanciar milhões de elementos sem estourar o limite de memória.
- **Eficiência de Cache**: Diminui a fragmentação de memória e melhora o uso do cache da CPU por utilizar menos referências duplicadas.

### ❌ Desvantagens
- **Complexidade de Código**: O código torna-se mais complexo ao separar as propriedades de uma classe em intrínseco e extrínseco.
- **Overhead de CPU**: A recuperação do Flyweight no hashmap da Fábrica e a computação em tempo de execução dos estados extrínsecos podem consumir ciclos adicionais de CPU.

---

## 📚 Relação com Outros Padrões

- **Composite**: Os componentes folha do Composite podem ser implementados como Flyweights para economizar memória em estruturas de árvores muito grandes.
- **Facade**: O Flyweight se assemelha ao Facade no sentido de centralizar acessos, mas o Flyweight foca em reduzir o tamanho dos objetos, enquanto o Facade foca em simplificar a interface do sistema.
- **Singleton**: O objeto do tipo Flyweight compartilhado pode se comportar como um Singleton se todas as propriedades forem globais, mas ao contrário do Singleton, podemos ter múltiplas instâncias diferentes de Flyweights (ex: Carvalho e Pinheiro).

---

## 🚀 Como Usar

1. **Separe** o estado da classe pesada original em **intrínseco** (imutável e repetitivo) e **extrínseco** (mutável e posicional).
2. **Mantenha** o estado intrínseco na classe Flyweight (`TreeType`).
3. **Crie** a fábrica de Flyweights com um mapa/cache estático para reutilizar os objetos criados.
4. **Crie** a classe de contexto leve (`Tree`) que mantém o estado extrínseco e aponta para a instância compartilhada.
