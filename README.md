# patterns
Estudo sobre padrões de projeto

## 📚 Pacotes Disponíveis

### 🎯 **factory**
Implementação completa do padrão **Factory Method** com tema de personagens (Heróis e Vilões).
- Personagens com atributos comuns (Nome, Habilidade, Força, Inteligência)
- Factory para criação de diferentes tipos de personagens
- Exemplos práticos de uso

### 🔧 **abstractFactory**
Implementação do padrão **Abstract Factory** com famílias de computadores.
- Famílias: Alto Desempenho e Básica
- Produtos: Desktop e Notebook
- Factories para criação de famílias completas

### 🔸 **singleton**
Implementações dos padrões **Singleton** e **Monostate** com tema de Logger.
- 3 implementações diferentes do Singleton (Eager, Lazy, Enum)
- Implementação do Monostate como alternativa
- Comparação prática entre os padrões

### 🏗️ **builder**
Implementação do padrão **Builder** com construção de lanches.
- Builder fluente para lanches personalizados
- Builders específicos para tipos de hambúrguer
- Diretor opcional para construção automatizada
- Exemplos de customização avançada

### 🧬 **prototype**
Implementação do padrão **Prototype** com clonagem de objetos.
- Shallow Copy (cópia superficial) vs Deep Copy (cópia profunda)
- Clonagem de objetos complexos (Pessoa e Endereco)
- Combinação com padrão Builder
- Registro centralizado de protótipos

## 🚀 Como Executar

```bash
# Factory Pattern
java -cp target/classes patterns.factory.PatternFactoryApplication

# Abstract Factory Pattern
java -cp target/classes patterns.abstractFactory.PatternAbstractFactoryApplication

# Singleton & Monostate Patterns
java -cp target/classes patterns.singleton.PatternSingletonApplication

# Builder Pattern
java -cp target/classes patterns.builder.PatternBuilderApplication

# Prototype Pattern
java -cp target/classes patterns.prototype.PatternPrototypeApplication
```

## 📖 Sobre o Projeto

Este projeto contém implementações didáticas e práticas de diferentes padrões de projeto em Java, com foco em:
- Exemplos simples e compreensíveis
- Código bem documentado
- Estrutura organizada
- Comparações entre padrões similares
