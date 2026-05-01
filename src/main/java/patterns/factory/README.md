# Padrão Factory - Estudo com Personagens

## 🎯 Sobre o Padrão Factory

O **Factory Pattern** é um padrão de criação que encapsula a lógica de criação de objetos, permitindo que o código cliente trabalhe com interfaces abstratas sem conhecer as classes concretas.

### Benefícios:
- ✅ **Encapsulamento**: Lógica de criação centralizada
- ✅ **Flexibilidade**: Fácil adicionar novos tipos
- ✅ **Manutenibilidade**: Modificações centralizadas
- ✅ **Polimorfismo**: Trabalha com interfaces abstratas

## 📁 Estrutura do Projeto

```
patterns.factory/
├── factory/
│   └── PersonagemFactory.java    # Factory que cria personagens
├── model/
│   ├── Personagem.java           # Classe abstrata base
│   ├── Heroi.java               # Implementação concreta de herói
│   └── Vilao.java               # Implementação concreta de vilão
├── service/
│   └── FactoryService.java      # Serviço com exemplos de uso
└── PatternFactoryApplication.java # Aplicação principal
```

## 🦸‍♂️ Lógica dos Personagens

### Personagem (Classe Abstrata)
- **Atributos comuns**: nome, habilidade, força, inteligência, tipo
- **Método abstrato**: `executarAcao()` - comportamento específico
- **Método concreto**: `exibirDescricao()` - descrição formatada

### Herói vs Vilão
| Aspecto | Herói | Vilão |
|---------|-------|-------|
| **Objetivo** | Proteger humanidade | Dominar mundo |
| **Ação** | Protege inocentes | Executa planos malignos |
| **Exemplos** | Superman, Batman | Lex Luthor, Coringa |

## 🚀 Como Executar

Execute a aplicação Spring Boot:

```bash
mvn spring-boot:run
```

A aplicação executará automaticamente 4 exemplos demonstrando:
1. **Criação de heróis** usando a Factory
2. **Criação de vilões** usando a Factory
3. **Banco de personagens** (polimorfismo)
4. **Criação com String** (dados externos)

## 💡 Exemplo de Uso

```java
// Criando um herói
Personagem heroi = PersonagemFactory.criarPersonagem(
    TipoPersonagem.HEROI,
    "Superman",
    "Super força e voo",
    10, 8
);

// Usando polimorficamente
heroi.exibirDescricao();
heroi.executarAcao();
```

## 🔧 Extensibilidade

Para adicionar um novo tipo de personagem:
1. Criar nova classe concreta estendendo `Personagem`
2. Implementar `executarAcao()`
3. Adicionar novo valor ao enum `TipoPersonagem`
4. Atualizar o switch na Factory

---

*Este exemplo demonstra como o padrão Factory facilita a criação e manutenção de diferentes tipos de objetos relacionados.*
