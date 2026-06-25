# Padrão Strategy - Comportamental

## 🎯 Intenção
O **Strategy** é um padrão de projeto comportamental que permite definir uma família de algoritmos, encapsular cada um deles e torná-los intercambiáveis. O Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.

---

## 📋 Problema
Imagine que você está desenvolvendo um sistema de e-commerce e precisa calcular o frete de envio das mercadorias. No início, o sistema oferece apenas uma modalidade padrão de envio:
- **Frete Comum**: R$ 5,00 base + R$ 1,50 por kg.

Para implementar isso, você cria um método simples `calcularFrete(double peso, String tipo)`. Contudo, conforme o negócio expande, novas regras de frete aparecem:
- **Frete Expresso**: R$ 15,00 base + R$ 3,00 por kg.
- **Frete Grátis**: Sem custo de envio.

Se implementarmos todas essas lógicas em um único método usando condicionais (`if-else` ou `switch`), nos deparamos com problemas severos:
- **Acúmulo de Código Mutável**: Toda vez que uma regra de cálculo muda ou um novo tipo de frete é introduzido, precisamos alterar e retestar a classe principal de cálculo.
- **Dificuldade de Leitura**: O método cresce, acumulando dezenas de linhas de regras matemáticas diferentes misturadas.
- **Violação do SRP e OCP**: O e-commerce fica acoplado a detalhes internos de fórmulas matemáticas específicas que mudam sob regras de negócio diferentes.

---

## ✅ Solução
O padrão Strategy propõe que você separe os algoritmos de cálculo em classes dedicadas chamadas **Strategies** (Estratégias), que implementam uma interface comum (`FreteStrategy`).

A classe original (chamada de **Contexto**, ex: `CalculadoraFrete`):
1. Mantém uma referência para a interface `FreteStrategy`.
2. Não executa cálculos matemáticos diretamente. Ao invés disso, ela delega a chamada para a estratégia ativa (`strategy.calcular(peso)`).
3. O cliente do e-commerce decide qual estratégia usar em tempo de execução, injetando o objeto correspondente (`new FreteExpresso()`) na calculadora.

---

## 🏗️ Estrutura

### Componentes:
- **Strategy (Interface)**: Declara a assinatura comum para todos os algoritmos suportados.
- **Concrete Strategies (Estratégias Concretas)**: Implementam os algoritmos matemáticos específicos estendendo a interface comum (ex: `FreteComum`, `FreteExpresso`, `FreteGratis`).
- **Context (Contexto)**: Mantém a referência da estratégia selecionada e interage com ela polimorficamente por meio de sua interface genérica.
- **Client (Cliente)**: Instancia a estratégia específica e a injeta no objeto de Contexto.

### No nosso exemplo:
- **FreteStrategy**: A interface que unifica a assinatura dos cálculos de frete (**Strategy**)
- **FreteComum** / **FreteExpresso** / **FreteGratis**: Os cálculos específicos (**Concrete Strategies**)
- **CalculadoraFrete**: A classe que armazena a estratégia ativa e executa a delegação (**Context**)
- **StrategyService**: O cliente que configura e roda as simulações (**Client**)

---

## 💡 Exemplo Prático - Calculadora de Frete Dinâmica

### Cenário
Criar uma calculadora de frete flexível. Dependendo da urgência do pedido ou promoções vigentes, o sistema calcula o frete da encomenda sob tarifas e lógicas totalmente diferentes, sem alterar o núcleo da calculadora.

### Implementação

#### 1. Interface de Estratégia (Strategy)
[FreteStrategy.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/strategy/strategy/FreteStrategy.java)
```java
public interface FreteStrategy {
    double calcular(double peso);
}
```

#### 2. Estratégia Concreta de Exemplo (FreteExpresso)
[FreteExpresso.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/strategy/strategy/FreteExpresso.java)
```java
public class FreteExpresso implements FreteStrategy {
    @Override
    public double calcular(double peso) {
        return 15.00 + (peso * 3.00);
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Diferentes Modos de Rota em Apps de Navegação (GPS)**
- Em aplicativos como Google Maps ou Waze, ao traçar um destino, você pode alternar dinamicamente a estratégia de rota: "Carro", "A pé", "Transporte Público" ou "Bicicleta". O aplicativo calcula distâncias e tempos sob algoritmos e bancos de dados totalmente diferentes para cada opção.

### 2. **Algoritmos de Ordenação de Dados (Sorting)**
- Filtros de ordenação em listagens de produtos que organizam itens sob regras diferentes: "Menor Preço", "Maior Desconto", "Mais Vendidos" ou "Avaliação".

### 3. **Estratégias de Autenticação (OAuth / Multi-provider)**
- Sistemas que aceitam login via múltiplos provedores externos: Google, GitHub, Facebook ou Login por e-mail tradicional. Cada provedor é implementado como uma estratégia diferente.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Princípio Aberto/Fechado (OCP)**: Você pode introduzir novas fórmulas de cálculo ou novas estratégias de frete sem precisar alterar o código do Contexto (`CalculadoraFrete`).
- **Isolamento de Algoritmos**: O código que executa o cálculo fica isolado dos dados de negócio globais.
- **Substituição Dinâmica**: O cliente pode alterar a estratégia ativa em tempo de execução de forma extremamente simples (`setStrategy`).
- **Substituição da Herança**: Evita a criação de subarquivos estáticos herdando de uma classe mãe apenas para alterar um único método interno.

### ❌ Desvantagens
- **Complexidade para Casos Simples**: Se a aplicação possui apenas duas regras de cálculo estáveis que nunca mudam, usar o Strategy adiciona classes e interfaces desnecessárias.
- **O Cliente Deve Conhecer as Opções**: Para configurar o Contexto, o cliente precisa saber quais estratégias existem e suas diferenças conceituais para selecionar a correta.

---

## 📚 Relação com Outros Padrões

- **Decorator**: O Decorator estende o comportamento de forma externa e cumulativa (adiciona camadas). O Strategy altera o algoritmo interno do objeto (muda as entranhas).
- **Template Method**: O Template Method trabalha na classe base por meio de herança (substituindo partes de um algoritmo fixo). O Strategy trabalha por composição e delegação (substituindo o algoritmo inteiro em tempo de execução).
- **State**: Ambos possuem a mesma estrutura de delegação por composição, mas no Strategy as estratégias costumam ser independentes e desconhecem a existência umas das outras, enquanto no State os estados Concretos sabem quais são os próximos estados e realizam ativamente as transições do Contexto.

---

## 🚀 Como Usar

1. **Defina** a interface `Strategy` contendo a assinatura do método do algoritmo variante.
2. **Crie** as classes concretas que implementam essa interface, contendo os detalhes matemáticos e lógicas de busca.
3. **Adicione** a referência da interface e um método setter (`setStrategy`) na classe Contexto.
4. **Delegue** a execução da ação principal do Contexto para a instância da estratégia configurada.
5. **No cliente**, crie a instância da estratégia correta e injete no Contexto antes de solicitar o processamento.
