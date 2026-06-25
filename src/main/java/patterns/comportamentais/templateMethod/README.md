# Padrão Template Method - Comportamental

## 🎯 Intenção
O **Template Method** (Método Modelo) é um padrão de projeto comportamental que define o esqueleto de um algoritmo na superclasse, mas deixa as subclasses sobrescreverem etapas específicas desse algoritmo sem modificar sua estrutura global.

---

## 📋 Problema
Imagine que você está desenvolvendo um sistema corporativo de faturamento e processamento de pagamentos. Você precisa suportar diferentes métodos de pagamento, como **Boleto Bancário** e **Cartão de Crédito**.

Ao codificar o fluxo de pagamento para ambos os métodos, você percebe que a sequência lógica é idêntica:
1. Conectar aos sistemas bancários/preparar transação.
2. Validar as credenciais ou dados fornecidos (código de barras, número do cartão, CVV).
3. Executar o débito do valor.
4. Gerar e enviar um comprovante digital para o cliente.
5. Fechar conexões seguras.

Se você codificar essa sequência de etapas de forma totalmente independente em cada classe de processador de pagamento:
- Haverá **duplicação massiva de código** (ex: o fluxo de preparação, envio de e-mails/comprovantes e fechamento de conexões é exatamente o mesmo).
- Se a sequência geral mudar (ex: um novo passo de "auditoria interna antes de debitar" for introduzido), você precisará abrir todas as classes e alterar os fluxos individualmente, correndo o risco de esquecer de atualizar algum deles.

---

## ✅ Solução
O padrão Template Method sugere que você quebre o algoritmo em uma série de etapas menores, transforme essas etapas em métodos na superclasse (`ProcessadorPagamento`) e crie um método principal de controle chamado **Template Method** (`processarPagamento`).

O Template Method define a ordem exata de execução das etapas.
As etapas podem ser:
- **Etapas Abstratas**: Métodos que cada subclasse *deve* implementar (ex: `validarDados`, `executarDebito`).
- **Etapas Comuns**: Métodos implementados diretamente na superclasse e compartilhados por todos (ex: `prepararTransacao`, `enviarNotificacao`).
- **Ganchos (Hooks)**: Métodos que possuem um comportamento padrão básico ou vazio na superclasse, mas que as subclasses podem sobrescrever opcionalmente se precisarem de lógica adicional em pontos estratégicos do algoritmo (ex: `finalizarProcesso`).

---

## 🏗️ Estrutura

### Componentes:
- **Abstract Class (Classe Abstrata)**: Define o método modelo (Template Method) que dita a sequência do algoritmo, além de conter os métodos comuns e as assinaturas dos passos abstratos e ganchos.
- **Concrete Classes (Classes Concretas)**: Implementam os métodos abstratos e sobrescrevem ganchos opcionais para particularizar o comportamento de etapas específicas do algoritmo, sem alterar a ordem de execução do fluxo principal.

### No nosso exemplo:
- **ProcessadorPagamento**: A classe esqueleto que dita a ordem de processamento do pagamento (**Abstract Class**)
- **ProcessadorBoleto** / **ProcessadorCartaoCredito**: Processadores específicos (**Concrete Classes**)
- **TemplateMethodService**: O código cliente que dispara os pagamentos de simulação (**Client**)

---

## 💡 Exemplo Prático - Processamento de Pagamento Corporativo

### Cenário
Criar um pipeline seguro de processamento de pagamentos. Embora a sequência geral de etapas do pagamento seja sempre a mesma, validar os dados e efetuar o débito variam completamente se o pagamento é feito por boleto ou por cartão.

### Implementação

#### 1. Classe Base Modelo (Abstract Class)
[ProcessadorPagamento.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/templateMethod/template/ProcessadorPagamento.java)
```java
public abstract class ProcessadorPagamento {
    // Template Method final - define a estrutura fixa do algoritmo
    public final void processarPagamento(double valor) {
        prepararTransacao();
        if (validarDados()) {
            executarDebito(valor);
            enviarNotificacao();
        } else {
            System.out.println("[Processamento] Erro: Transação cancelada.");
        }
        finalizarProcesso();
    }

    private void prepararTransacao() { /* ... comum ... */ }
    private void enviarNotificacao() { /* ... comum ... */ }

    protected abstract boolean validarDados(); // Abstrato
    protected abstract void executarDebito(double valor); // Abstrato

    protected void finalizarProcesso() { // Hook/Gancho opcional
        System.out.println("[Processamento] Conexão bancária finalizada.");
    }
}
```

#### 2. Implementação Concreta de Exemplo (ProcessadorBoleto)
[ProcessadorBoleto.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/templateMethod/template/ProcessadorBoleto.java)
```java
public class ProcessadorBoleto extends ProcessadorPagamento {
    private final String codigoBarras;
    public ProcessadorBoleto(String codigoBarras) { this.codigoBarras = codigoBarras; }

    @Override
    protected boolean validarDados() {
        System.out.println("[Boleto] Validando código de barras...");
        return codigoBarras != null && codigoBarras.length() == 47;
    }

    @Override
    protected void executarDebito(double valor) {
        System.out.printf("[Boleto] Emitindo boleto de R$ %.2f...\n", valor);
    }

    @Override
    protected void finalizarProcesso() { // Sobrescrita de Hook
        System.out.println("[Boleto] PDF do boleto enviado para o e-mail do cliente.");
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Frameworks de Testes Automatizados**
- Frameworks como JUnit usam o Template Method para executar ciclos de testes: `setUp()` (Common/Hook) -> `runTest()` (Abstract) -> `tearDown()` (Common/Hook).

### 2. **Processamento de Arquivos/Formatos Diferentes**
- Um leitor de dados que realiza a mesma sequência (Abrir Arquivo -> Ler Linhas -> Validar Layout -> Inserir no DB -> Fechar Arquivo) independentemente se o arquivo é CSV, XML ou JSON. Apenas as etapas de parsing (`Ler Linhas` e `Validar Layout`) são implementadas por subclasses específicas.

### 3. **Filtros e Renderização em Frameworks Web**
- Ciclos de vida de frameworks front-end (como React, Angular ou JSF) acionam métodos específicos em ordem cronológica (ex: `ngOnInit`, `componentDidMount`, `componentWillUnmount`), permitindo que desenvolvedores injetem código personalizado nessas fases.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Reutilização de Código**: Evita código duplicado puxando lógica comum e esqueleto de algoritmo para a superclasse.
- **Controle Centralizado**: Mudanças na sequência geral do algoritmo ocorrem em um único ponto (na superclasse), afetando automaticamente todas as subclasses.
- **Extensibilidade Controlada**: Subclasses podem redefinir apenas partes específicas do algoritmo, reduzindo o risco de alterar comportamentos essenciais do fluxo.

### ❌ Desvantagens
- **Rígidez Algorítmica**: Subclasses ficam presas ao esqueleto definido pelo Template Method; se um método de pagamento não puder seguir exatamente aquela sequência de etapas, o padrão não funcionará.
- **Violação do LSP (Liskov Substitution Principle)**: Sobrescrever métodos na subclasse sem cuidado pode quebrar asserções de pré/pós-condições assumidas pelo Template Method principal.
- **Manutenibilidade complexa**: Conforme a quantidade de passos e hooks cresce, ler e entender o fluxo completo pulando entre superclasse e subclasse pode ser difícil.

---

## 📚 Relação com Outros Padrões

- **Strategy**: O Strategy trabalha na classe base usando composição e delegação (substitui o comportamento de forma completa e dinâmica em tempo de execução). O Template Method trabalha na classe base por herança (substitui etapas de um algoritmo estaticamente em tempo de compilação).
- **Factory Method**: O Factory Method é frequentemente utilizado como um passo interno de criação (um método abstrato de fabricação de objetos) dentro de um Template Method maior.

---

## 🚀 Como Usar

1. **Analise** o algoritmo e determine quais etapas são comuns e quais mudam de comportamento por subclasse.
2. **Crie** uma superclasse abstrata contendo o método modelo marcado como `final` (para evitar que seja sobrescrito).
3. **Declare** métodos abstratos para as etapas específicas que devem ser obrigatoriamente implementadas pelas subclasses.
4. **Implemente** métodos privados ou finais na superclasse para as etapas que são comuns.
5. **Defina** métodos ganchos (hooks) contendo lógica vazia ou padrão em etapas onde as subclasses podem ou não querer intervir.
6. **Implemente** as subclasses concretas estendendo a classe abstrata e preenchendo as etapas abstratas.
