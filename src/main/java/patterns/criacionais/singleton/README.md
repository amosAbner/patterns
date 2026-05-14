# Padrões Singleton e Monostate

## 🎯 Sobre os Padrões

### Singleton
O **Singleton** é um padrão de criação que garante que uma classe tenha apenas **uma instância** e fornece um ponto global de acesso a ela.

### Monostate
O **Monostate** é uma variação do conceito de Singleton onde **múltiplas instâncias** podem existir, mas todas **compartilham o mesmo estado**.

## 📁 Estrutura do Projeto

```
patterns.criacionais.singleton/
├── model/
│   └── Logger.java                    # Interface comum
├── implementation/
│   ├── LoggerSingleton.java           # Singleton Eager
│   ├── LoggerSingletonLazy.java       # Singleton Lazy
│   └── LoggerSingletonEnum.java       # Singleton Enum
├── monostate/
│   └── LoggerMonostate.java           # Implementação Monostate
├── service/
│   └── SingletonService.java          # Exemplos práticos
└── PatternSingletonApplication.java
```

## 🔧 Implementações do Singleton

### 1. **Eager Initialization**
```java
public class LoggerSingleton {
    private static final LoggerSingleton instance = new LoggerSingleton();

    private LoggerSingleton() {}

    public static LoggerSingleton getInstance() {
        return instance;
    }
}
```

### 2. **Lazy Initialization** (Thread-Safe)
```java
public class LoggerSingletonLazy {
    private static volatile LoggerSingletonLazy instance;

    private LoggerSingletonLazy() {}

    public static LoggerSingletonLazy getInstance() {
        if (instance == null) {
            synchronized (LoggerSingletonLazy.class) {
                if (instance == null) {
                    instance = new LoggerSingletonLazy();
                }
            }
        }
        return instance;
    }
}
```

### 3. **Enum** (Recomendado)
```java
public enum LoggerSingletonEnum implements Logger {
    INSTANCE;

    // métodos implementados
}
```

## 🔄 Monostate Pattern

```java
public class LoggerMonostate implements Logger {
    // Estado compartilhado (static)
    private static StringBuilder logs = new StringBuilder();

    // Construtor público - permite múltiplas instâncias
    public LoggerMonostate() {
        // Estado é compartilhado via variáveis static
    }
}
```

## 🚀 Como Executar

```bash
# Compilar o projeto
mvn compile

# Executar os exemplos
java -cp target/classes patterns.singleton.PatternSingletonApplication
```

## 📊 Comparação: Singleton vs Monostate

| Aspecto | Singleton | Monostate |
|---------|-----------|-----------|
| **Instâncias** | Apenas 1 | Múltiplas |
| **Construtor** | Privado | Público |
| **Herança** | Difícil | Fácil |
| **Estado** | Instância única | Compartilhado (static) |
| **Polimorfismo** | Limitado | Total |
| **Testabilidade** | Difícil | Fácil |

## 💡 Quando Usar Cada Um

### **Singleton:**
- Gerenciadores de recursos (Logger, Database, Cache)
- Configurações globais
- Pools de conexão
- Quando precisar exatamente uma instância

### **Monostate:**
- Quando precisar herança/polimorfismo
- Para testes mais fáceis
- Quando múltiplas instâncias são aceitáveis
- Alternativa mais flexível ao Singleton

## 🎮 Exemplos Demonstrados

1. **Singleton Eager** - Instância criada no carregamento
2. **Singleton Lazy** - Instância criada sob demanda
3. **Singleton Enum** - Abordagem moderna e segura
4. **Monostate** - Múltiplas instâncias, estado compartilhado
5. **Comparação** - Diferenças práticas entre os padrões

## ✅ Benefícios

- **Controle de recursos** globais
- **Economia de memória** (especialmente Singleton)
- **Acesso global** facilitado
- **Thread safety** (nas implementações corretas)
- **Consistência** de estado
