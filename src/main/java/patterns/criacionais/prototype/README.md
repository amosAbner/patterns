# Padrão Prototype - Clonagem de Objetos

## 🎯 Sobre o Padrão

O **Prototype** é um padrão de criação que permite criar novos objetos pela clonagem de um protótipo existente, ao invés de criá-los do zero. Reduz a necessidade de subclasses e permite criar objetos complexos de forma eficiente.

### ✨ Benefícios
- ✅ **Performance** - Clonagem mais rápida que construção
- ✅ **Reduz subclasses** - Evita múltiplas subclasses para variações
- ✅ **Protótipos reutilizáveis** - Templates para múltiplas cópias
- ✅ **Registro centralizado** - Prototipos podem ser armazenados
- ✅ **Simplicidade** - Interface simples (clone)

## 📁 Estrutura do Projeto

```
patterns.criacionais.prototype/
├── model/
│   ├── Endereco.java                  # Classe simples com estado mutável
│   ├── Pessoa.java                    # Shallow Copy implementation
│   └── PessoaDeepClone.java           # Deep Copy implementation
├── builder/
│   ├── PessoaBuilder.java             # Builder para Pessoa
│   └── EnderecoBuilder.java           # Builder para Endereco
├── registry/
│   └── PrototipoRegistry.java         # Registro de protótipos
├── service/
│   └── PrototypeService.java          # Exemplos práticos
└── PatternPrototypeApplication.java
```

## 🔄 Tipos de Clonagem

### 1. **Shallow Copy (Cópia Superficial)**
```java
@Override
public Object clone() throws CloneNotSupportedException {
    return super.clone();
}
// Compartilha objetos internos!
```

### 2. **Deep Copy (Cópia Profunda)**
```java
@Override
public Object clone() throws CloneNotSupportedException {
    PessoaDeepClone copia = (PessoaDeepClone) super.clone();
    copia.endereco = new Endereco(this.endereco);
    return copia;
}
// Clona também os objetos internos
```

### 3. **Prototype Registry**
```java
PrototipoRegistry registry = new PrototipoRegistry();
registry.registrar("pessoaPadrao", pessoaPadrao);
PessoaDeepClone copia = (PessoaDeepClone) registry.obter("pessoaPadrao").clone();
```

## 🚀 Como Executar

```bash
# Compilar o projeto
mvn compile

# Executar os exemplos
java -cp target/classes patterns.prototype.PatternPrototypeApplication
```

## 💡 Exemplos Demonstrados

### **Exemplo 1: Shallow Copy**
- Demonstra o problema de compartilhamento
- Modificações afetam original e cópia

### **Exemplo 2: Deep Copy**
- Clonagem completa de objetos internos
- Independência total entre cópias

### **Exemplo 3: Comparação Visual**
- Shallow vs Deep side-by-side
- Visualização clara das diferenças

### **Exemplo 4: Builder com Prototype**
- Combinação de dois padrões
- Templates reutilizáveis

### **Exemplo 5: Registry de Protótipos**
- Armazenamento centralizado
- Padrão completo do Prototype

## 📊 Shallow Copy vs Deep Copy

| Aspecto | Shallow | Deep |
|---------|---------|------|
| **Performance** | Rápida | Mais lenta |
| **Memória** | Menos uso | Mais uso |
| **Independência** | Parcial | Total |
| **Objetos internos** | Compartilhados | Clonados |
| **Quando usar** | Objetos simples | Objetos complexos |

## 🎮 Quando Usar Prototype

- **Objetos complexos** com muitos atributos
- **Performance crítica** na criação
- **Múltiplas variações** do mesmo padrão
- **Evitar construção cara** do zero
- **Registro de templates** necessário

## 👀 Método clone() do Java

```java
// Interface Cloneable marca classe como clonável
public class Pessoa implements Cloneable {
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy padrão
    }
}
```

## ✅ Vantagens Demonstradas

- **Criação eficiente** de objetos
- **Flexibilidade** com shallow e deep copy
- **Reutilização** de templates
- **Armazenamento** de protótipos
- **Combinação** com outros padrões (Builder)

