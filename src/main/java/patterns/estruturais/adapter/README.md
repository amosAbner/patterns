# Padrão Adapter - Estrutural

## 🎯 Intenção
O padrão **Adapter** permite que interfaces incompatíveis trabalhem juntas. Ele funciona como um adaptador que converte a interface de uma classe para outra interface esperada pelo cliente.

## 📋 Problema
Imagine que você tem um sistema legado que funciona perfeitamente, mas sua interface não é compatível com o código que você está desenvolvendo. Você não pode alterar o código legado porque outras aplicações dependem dele.

## ✅ Solução
O Adapter age como um wrapper entre duas interfaces incompatíveis, convertendo chamadas de método de uma interface para outra.

## 🏗️ Estrutura

### Componentes:
- **Target (Alvo)**: Interface que o cliente usa
- **Adapter**: Classe que implementa a interface Target e adapta o Adaptee
- **Adaptee**: Classe existente com interface incompatível
- **Client**: Código que usa a interface Target

### No nosso exemplo:
- **DatabaseOperations**: Interface Target (alvo)
- **MySQLAdapter/MongoDBAdapter**: Classes Adapter
- **MySQLDatabase/MongoDBDatabase**: Classes Adaptee (adaptadas)
- **AdapterService**: Cliente que usa a interface padronizada

## 💡 Exemplo Prático - Banco de Dados

### Cenário
Uma empresa possui sistemas legados usando MySQL e MongoDB com interfaces completamente diferentes. Queremos criar uma API unificada para acessar qualquer um dos bancos sem alterar o código legado.

### Implementação

#### 1. Interface Padrão (Target)
```java
public interface DatabaseOperations {
    void connect();
    void disconnect();
    Object select(String query);
    void insert(String table, Object data);
    void update(String table, Object data, String condition);
    void delete(String table, String condition);
}
```

#### 2. Sistema Legado MySQL (Adaptee)
```java
public class MySQLDatabase {
    public void openConnection() { /* ... */ }
    public String executeQuery(String sql) { /* ... */ }
    public void executeUpdate(String sql) { /* ... */ }
    // ...
}
```

#### 3. Sistema Legado MongoDB (Adaptee)
```java
public class MongoDBDatabase {
    public void establishConnection() { /* ... */ }
    public Object findDocument(String collection, String filter) { /* ... */ }
    public void saveDocument(String collection, Object document) { /* ... */ }
    // ...
}
```

#### 4. Adapters
```java
public class MySQLAdapter implements DatabaseOperations {
    private final MySQLDatabase mysqlDatabase;

    public MySQLAdapter(MySQLDatabase mysqlDatabase) {
        this.mysqlDatabase = mysqlDatabase;
    }

    @Override
    public void connect() {
        mysqlDatabase.openConnection();
    }

    @Override
    public Object select(String query) {
        return mysqlDatabase.executeQuery("SELECT " + query);
    }
    // ... outros métodos adaptados
}
```

## 🎯 Aplicações Práticas

### 1. **Integração de Sistemas Legados**
- Migração gradual de sistemas antigos
- Manutenção de compatibilidade durante refatoração

### 2. **APIs de Terceiros**
- Adaptação de bibliotecas com interfaces diferentes
- Padronização de diferentes provedores de serviço

### 3. **Bancos de Dados**
- Abstração de diferentes tipos de banco (SQL vs NoSQL)
- Migração transparente entre provedores

### 4. **Frameworks e Bibliotecas**
- Adaptação entre versões incompatíveis
- Integração de frameworks diferentes

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Princípio Aberto/Fechado**: Adapta sem modificar código existente
- **Separação de Responsabilidades**: Cliente independente da implementação
- **Reutilização**: Código legado pode ser reutilizado
- **Manutenibilidade**: Mudanças ficam isoladas no Adapter

### ❌ Desvantagens
- **Complexidade**: Adiciona uma camada extra
- **Performance**: Pode haver overhead nas conversões
- **Limitações**: Nem sempre consegue adaptar tudo

## 🔄 Tipos de Adapter

### 1. **Adapter de Classe** (Herança)
```java
public class ClassAdapter extends Adaptee implements Target {
    // Herda de Adaptee e implementa Target
}
```

### 2. **Adapter de Objeto** (Composição) ⭐
```java
public class ObjectAdapter implements Target {
    private final Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    // Adapta chamadas usando composição
}
```

## 🚀 Como Usar

1. **Identifique** a interface que precisa ser adaptada
2. **Crie** uma interface Target comum
3. **Implemente** o Adapter usando composição
4. **Use** a interface Target no código cliente

## 📚 Relação com Outros Padrões

- **Bridge**: Semelhante, mas Bridge separa abstração de implementação desde o início
- **Decorator**: Adiciona responsabilidades, Adapter converte interfaces
- **Facade**: Simplifica interface, Adapter converte interfaces
- **Proxy**: Controla acesso, Adapter adapta interfaces

## 🎯 Conclusão

O padrão Adapter é essencial quando precisamos integrar sistemas com interfaces incompatíveis. Ele permite evolução gradual do sistema e reutilização de código legado, mantendo a compatibilidade e seguindo princípios SOLID.
