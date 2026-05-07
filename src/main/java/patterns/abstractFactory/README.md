# Padrão Abstract Factory - Famílias de Computadores

## Sobre o Padrão

O **Abstract Factory** é um padrão de criação que fornece uma interface para criar **famílias de objetos relacionados** sem especificar suas classes concretas.

### Benefícios
- **Encapsulamento**: Lógica de criação centralizada
- **Flexibilidade**: Fácil trocar famílias completas
- **Desacoplamento**: Código cliente não conhece classes concretas
- **Consistência**: Produtos relacionados são criados juntos

## Estrutura Simplificada

```
patterns.abstractFactory/
├── model/
│   ├── Computador.java         # Classe abstrata
│   ├── Desktop.java            # Produto concreto
│   └── Notebook.java           # Produto concreto
├── factory/
│   ├── ComputadorFactory.java           # Interface abstrata
│   ├── AltoDesempenhoFactory.java       # Factory família alto desempenho
│   └── BasicoFactory.java               # Factory família básica
├── service/
│   └── AbstractFactoryService.java      # Exemplos práticos
└── PatternAbstractFactoryApplication.java
```

## Famílias de Produtos

### Família **Alto Desempenho**
| Produto | Especificações |
|---------|----------------|
| **Desktop** | Intel Core i9, 64GB RAM, 4TB NVMe, 1200W |
| **Notebook** | Intel Core i7, 32GB RAM, 2TB SSD, 8h bateria |

### Família **Básica**
| Produto | Especificações |
|---------|----------------|
| **Desktop** | Intel Core i3, 8GB RAM, 256GB SSD, 400W |
| **Notebook** | Intel Core i3, 8GB RAM, 256GB SSD, 4h bateria |

## Como Executar

```bash
# Compilar o projeto
mvn compile

# Executar os exemplos
java -cp target/classes patterns.abstractFactory.PatternAbstractFactoryApplication
```

## Exemplo de Uso

```java
// Trabalhando com família de alto desempenho
ComputadorFactory factory = new AltoDesempenhoFactory();
Desktop desktop = factory.criarDesktop();      // Desktop alto desempenho
Notebook notebook = factory.criarNotebook();   // Notebook alto desempenho

// Trabalhando com família básica
factory = new BasicoFactory();
Desktop desktopBasico = factory.criarDesktop();    // Desktop básico
Notebook notebookBasico = factory.criarNotebook(); // Notebook básico
```

## Conceito Aplicado

O padrão Abstract Factory permite:
- **Criar famílias coesas** de produtos relacionados
- **Trocar famílias completas** mudando apenas a factory
- **Manter consistência** dentro da família
- **Trabalhar polimorficamente** com diferentes famílias
