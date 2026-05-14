# Padrão Builder - Construção de Lanches

## 🎯 Sobre o Padrão

O **Builder** é um padrão de criação que permite construir objetos complexos passo a passo. Ele separa a construção de um objeto complexo da sua representação, permitindo o mesmo processo de construção criar diferentes representações.

### ✨ Benefícios
- ✅ **Separação de responsabilidades** - Construção vs Representação
- ✅ **Flexibilidade** - Objetos complexos construídos passo a passo
- ✅ **Controle fino** - Cada passo pode ser customizado
- ✅ **Reutilização** - Mesmo processo constrói objetos diferentes
- ✅ **Interface fluente** - API mais legível e intuitiva

## 📁 Estrutura do Projeto

```
patterns.criacionais.builder/
├── model/
│   └── Lanche.java                    # Produto complexo + Builder interno
├── builder/
│   ├── LancheBuilder.java             # Interface para Builders
│   ├── XBurguerBuilder.java           # Builder específico
│   ├── ChickenBurguerBuilder.java     # Builder específico
│   ├── VeggieBurguerBuilder.java      # Builder específico
│   └── LancheDiretor.java             # Diretor (opcional)
├── service/
│   └── BuilderService.java            # Exemplos práticos
└── PatternBuilderApplication.java
```

## 🏗️ Implementações Demonstradas

### 1. **Builder Interno (Lanche.Builder)**
```java
Lanche lanche = new Lanche.Builder("Pão", "Proteína")
    .comQueijo("Cheddar")
    .comAlface("Americana")
    .comMolho("Especial")
    .montar();
```

### 2. **Builders Específicos**
```java
LancheBuilder builder = new XBurguerBuilder();
diretor.construirLanche(builder);
```

### 3. **Diretor (Opcional)**
```java
LancheDiretor diretor = new LancheDiretor();
Lanche lanche = diretor.construirLanche(builder);
```

## 🍔 Lanches Disponíveis

| Tipo | Pão | Proteína | Características |
|------|-----|----------|----------------|
| **X-Burguer** | Pão hambúrguer | Hambúrguer bovino | Queijo, alface, tomate, cebola, molho |
| **Chicken** | Pão hambúrguer | Frango grelhado | Queijo prato, alface, tomate, molho iogurte |
| **Veggie** | Pão integral | Grão de bico | Queijo vegano, alface roxa, tomate orgânico, tahine |

## 🚀 Como Executar

```bash
# Compilar o projeto
mvn compile

# Executar os exemplos
java -cp target/classes patterns.builder.PatternBuilderApplication
```

## 💡 Exemplos Demonstrados

### **Exemplo 1: Usando Diretor**
- Construção automatizada através do Diretor
- Processo padronizado para cada tipo de lanche

### **Exemplo 2: Builder Fluente**
- Controle total sobre cada ingrediente
- API fluente e intuitiva
- Construção passo a passo

### **Exemplo 3: Customização Avançada**
- Lanches vegetarianos
- Opções low-carb
- Combinações personalizadas

### **Exemplo 4: Comparação de Abordagens**
- Diretor vs Builder Fluente
- Vantagens e desvantagens de cada abordagem

## 🔄 Processo de Construção

O padrão Builder divide a construção em etapas claras:

1. **Preparar base** - Pão e proteína principal
2. **Adicionar proteína** - Detalhes da proteína
3. **Adicionar acompanhamentos** - Vegetais e complementos
4. **Adicionar molhos** - Finalização com temperos

## 🎮 Quando Usar Builder

- **Objetos complexos** com muitos parâmetros opcionais
- **Construção passo a passo** necessária
- **Várias representações** do mesmo tipo de objeto
- **Objetos imutáveis** após construção
- **APIs fluentes** desejadas

## ✅ Vantagens Demonstradas

- **Imutabilidade** - Objetos finais não podem ser alterados
- **Validação** - Construção pode validar parâmetros
- **Legibilidade** - Código mais fácil de entender
- **Manutenibilidade** - Mudanças isoladas no Builder
- **Testabilidade** - Cada passo pode ser testado separadamente

## 📝 Nota: @Builder do Lombok

Este exemplo implementa o padrão Builder **manualmente** para fins educacionais. Na prática, a anotação **`@Builder` do Lombok** automatiza completamente esse padrão:

```java
@Getter
@Builder
public class Lanche {
    private final String pao;
    private final String proteina;
    // Lombok gera automaticamente toda a classe Builder!
}

// Uso é idêntico:
Lanche lanche = Lanche.builder()
    .pao("Pão australiano")
    .proteina("Hambúrguer duplo")
    .queijo("Gouda")
    .build();
```

**Quando usar cada um:**
- **Manual**: Controle total, validação customizada, fins educacionais
- **Lombok**: Rapidez, menos código, POJOs simples

Ambos implementam o mesmo padrão Builder, a diferença é quem escreve o código!

