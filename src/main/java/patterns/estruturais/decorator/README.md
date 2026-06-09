# Padrão Decorator - Estrutural

## 🎯 Intenção
O **Decorator** é um padrão de projeto estrutural que permite adicionar novas responsabilidades a um objeto de forma dinâmica, envolvendo-o ( wrapping ) em objetos decoradores. Ele fornece uma alternativa flexível ao uso de herança para estender funcionalidades.

---

## 📋 Problema
Imagine que você está desenvolvendo um sistema para uma cafeteria. Inicialmente, você tem classes para diferentes tipos de café (ex: `SimpleCoffee`, `Espresso`).
Quando os clientes começam a pedir adicionais como Leite, Açúcar, Chantilly ou Canela, você se depara com um dilema:
- Se usar herança, precisará criar classes para cada combinação possível: `CoffeeWithMilk`, `CoffeeWithSugar`, `CoffeeWithMilkAndSugar`, `EspressoWithMilkAndChantilly`, etc.
- Isso causa uma **explosão de classes**, gerando uma árvore de herança gigantesca e engessada que dificulta a manutenção e evolução do sistema.

---

## ✅ Solução
O padrão Decorator sugere o uso de **Composição e Delegação** ao invés de herança.
Você cria uma classe abstrata decoradora base (`BeverageDecorator`) que implementa a mesma interface que a bebida base (`Beverage`) e armazena uma referência a ela.

Dessa forma, os decoradores concretos (como `MilkDecorator` ou `SugarDecorator`):
- Envolvem o objeto de bebida base.
- Executam seu próprio comportamento (ex: adicionar custo e descrição adicionais).
- Delegam a chamada de método para o objeto envolvido para obter o restante das informações.

Como o decorador também é um tipo de `Beverage`, você pode empilhar múltiplos decoradores (ex: envolver um café com Leite, e depois com Açúcar, e depois com Chantilly).

---

## 🏗️ Estrutura

### Componentes:
- **Component (Componente)**: Interface ou classe abstrata que define as operações comuns que podem ser alteradas dinamicamente.
- **Concrete Component (Componente Concreto)**: O objeto básico que terá novos comportamentos adicionados a ele.
- **Decorator (Decorador Base)**: Classe abstrata que implementa a interface Component e mantém uma referência para um objeto Component.
- **Concrete Decorators (Decoradores Concretos)**: Estendem a classe Decorator adicionando estado e/ou comportamento específico de forma dinâmica.

### No nosso exemplo:
- **Beverage**: Interface do produto (**Component**)
- **SimpleCoffee** / **Espresso**: Bebidas base (**Concrete Component**)
- **BeverageDecorator**: Classe abstrata decoradora (**Decorator**)
- **MilkDecorator** / **SugarDecorator** / **WhippedCreamDecorator**: Ingredientes adicionais (**Concrete Decorators**)

---

## 💡 Exemplo Prático - Cafeteria Dinâmica

### Cenário
Montar pedidos personalizados de café adicionando acompanhamentos de forma dinâmica e obtendo o valor e a descrição combinados de forma transparente.

### Implementação

#### 1. Interface Comum (Component)
[Beverage.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/decorator/component/Beverage.java)
```java
package patterns.estruturais.decorator.component;

public interface Beverage {
    String getDescription();
    double getCost();
}
```

#### 2. Componentes Concretos (Concrete Component)
[SimpleCoffee.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/decorator/concretecomponent/SimpleCoffee.java)
```java
package patterns.estruturais.decorator.concretecomponent;

import patterns.estruturais.decorator.component.Beverage;

public class SimpleCoffee implements Beverage {
    @Override
    public String getDescription() { return "Café Simples"; }

    @Override
    public double getCost() { return 2.50; }
}
```

#### 3. Decorador Base (Decorator)
[BeverageDecorator.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/decorator/decorator/BeverageDecorator.java)
```java
package patterns.estruturais.decorator.decorator;

import patterns.estruturais.decorator.component.Beverage;

public abstract class BeverageDecorator implements Beverage {
    protected final Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() { return beverage.getDescription(); }

    @Override
    public double getCost() { return beverage.getCost(); }
}
```

#### 4. Decorador Concreto Exemplo (Concrete Decorator)
[MilkDecorator.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/decorator/decorator/MilkDecorator.java)
```java
package patterns.estruturais.decorator.decorator;

import patterns.estruturais.decorator.component.Beverage;

public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Leite";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.20;
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Streams de Entrada/Saída no Java (I/O)**
- O clássico exemplo do Java Standard Library:
  ```java
  InputStream in = new BufferedInputStream(new FileInputStream("arquivo.txt"));
  ```
  Onde `FileInputStream` é o componente de leitura física e `BufferedInputStream` é um decorador que adiciona buffering na leitura.

### 2. **Autenticação e Autorização em Requisições Web**
- Adição dinâmica de filtros em requisições (Middleware/Filters), como checagem de Token JWT, encriptação de payloads ou logging de acessos.

### 3. **Interface Gráfica e Estilização**
- Em desenvolvimento de interfaces (HTML/CSS, Swing, WPF), envolver um componente de visualização de dados (ex: `Table`) em um container de barra de rolagem (ex: `ScrollDecorator`) ou de bordas coloridas.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Flexibilidade superior à herança**: Permite anexar e desanexar comportamentos em tempo de execução.
- **Composições múltiplas**: É possível empilhar vários decoradores em um único objeto de forma cumulativa.
- **Princípio da Responsabilidade Única (SRP)**: Divide uma classe gigante em várias classes focadas em apenas uma responsabilidade (ex: uma classe cuida apenas do Leite, outra do Chantilly).
- **Sem poluição de código**: O cliente interage com a bebida final exatamente do mesmo modo que interage com uma bebida sem adicionais.

### ❌ Desvantagens
- **Muitos objetos pequenos**: Pode resultar em uma arquitetura com muitas pequenas classes decoradoras muito parecidas, o que pode ser confuso para quem lê o código pela primeira vez.
- **Dificuldade na inicialização**: Montar objetos complexos envolve escrever múltiplos wrappers (`new MilkDecorator(new SugarDecorator(new Coffee()))`).
- **Ordem de Dependência**: Se a ordem em que os decoradores são aplicados influenciar no resultado final (ex: aplicar imposto antes ou depois do desconto), o controle da pilha de chamadas se torna crítico e complexo.

---

## 📚 Relação com Outros Padrões

- **Adapter**: O Adapter altera a interface para torná-la compatível. O Decorator mantém a mesma interface e adiciona responsabilidade.
- **Composite**: O Decorator pode ser visto como um Composite com apenas um filho. No entanto, o Decorator adiciona responsabilidade, enquanto o Composite apenas agrega elementos.
- **Strategy**: O Strategy altera as entranhas do objeto (o algoritmo interno). O Decorator altera a casca do objeto (a camada externa), estendendo seu comportamento.

---

## 🚀 Como Usar

1. **Garanta** que o componente base possua uma interface (`Beverage`) comum para todas as variantes.
2. **Crie** uma classe decoradora abstrata contendo um campo do tipo da interface.
3. **Delegue** todas as chamadas padrão da interface para o objeto envolvido.
4. **Implemente** os decoradores concretos estendendo o decorador base e adicionando as melhorias necessárias.
