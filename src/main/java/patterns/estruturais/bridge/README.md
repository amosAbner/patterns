# Padrão Bridge - Estrutural

## 🎯 Intenção
O **Bridge** é um padrão de projeto estrutural que permite dividir uma classe grande ou um conjunto de classes intimamente ligadas em duas hierarquias separadas — **Abstração** e **Implementação** — que podem ser desenvolvidas independentemente uma da outra.

---

## 📋 Problema
Imagine que você tem uma classe para controles remotos (`RemoteControl`) e quer adaptá-la para funcionar com diversos dispositivos (`TV`, `Radio`, etc.). Se usarmos herança convencional, a quantidade de classes crescerá exponencialmente (ex: `TVBasicRemote`, `TVAdvancedRemote`, `RadioBasicRemote`, `RadioAdvancedRemote`). 

Qualquer alteração em um dispositivo exigirá mexer nos controles remotos específicos, criando um forte acoplamento e um código difícil de estender.

---

## ✅ Solução
O padrão Bridge resolve isso substituindo a herança clássica por **composição**. A classe de abstração (`RemoteControl`) mantém uma referência para um objeto da interface de implementação (`Device`). 

Ao invés de realizar o trabalho diretamente, os controles remotos delegam as chamadas de método para o dispositivo associado. Com isso:
- Os controles remotos (Abstração) definem a interface de alto nível do usuário.
- Os dispositivos (Implementação) fornecem as operações básicas de baixo nível.
- Podemos criar novos controles e novos dispositivos de forma independente.

---

## 🏗️ Estrutura

### Componentes:
- **Abstraction (Abstração)**: Define a interface de controle (alto nível) e mantém uma referência para o Implementador.
- **Refined Abstraction (Abstração Refinada)**: Estende a interface definida pela Abstração, adicionando novas funcionalidades específicas do controle.
- **Implementor (Implementador)**: Define a interface para as classes de implementação (baixo nível). Não precisa corresponder diretamente à interface da Abstração.
- **Concrete Implementors (Implementadores Concretos)**: Contêm a lógica específica de baixo nível para cada plataforma/dispositivo.

### No nosso exemplo:
- **RemoteControl**: Classe abstrata pai (**Abstraction**)
- **BasicRemote** / **AdvancedRemote**: Controles específicos (**Refined Abstraction**)
- **Device**: Interface de controle do aparelho (**Implementor**)
- **TVDevice** / **RadioDevice**: Aparelhos reais (**Concrete Implementors**)

---

## 💡 Exemplo Prático - Controle Remoto e Dispositivos

### Cenário
Diferentes controles remotos controlando aparelhos de TV ou Rádio usando uma interface de comunicação unificada.

### Implementação

#### 1. Interface de Implementação (Implementor)
[Device.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/bridge/implementation/Device.java)
```java
package patterns.estruturais.bridge.implementation;

public interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
}
```

#### 2. Classe de Abstração Base (Abstraction)
[RemoteControl.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/bridge/abstraction/RemoteControl.java)
```java
package patterns.estruturais.bridge.abstraction;

import patterns.estruturais.bridge.implementation.Device;

public abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }

    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }

    public void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }

    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }
}
```

#### 3. Abstração Refinada com Nova Função (Refined Abstraction)
[AdvancedRemote.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/bridge/abstraction/AdvancedRemote.java)
```java
package patterns.estruturais.bridge.abstraction;

import patterns.estruturais.bridge.implementation.Device;

public class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0); // Função avançada exclusiva deste controle
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Desenvolvimento Multiplataforma**
- Interfaces gráficas (GUI) que precisam rodar no Windows, macOS e Linux. A Abstração gerencia o layout abstrato e a Implementação lida com o desenho das janelas de cada OS específico.

### 2. **Drivers de Conexão a Banco de Dados**
- O driver define a API que a aplicação consome (Abstração) e cada fornecedor (MySQL, Postgres, Oracle) fornece a implementação concreta das queries em baixo nível.

### 3. **Processamento de Imagens e Renderizadores**
- Uma hierarquia de formas geométricas (Círculo, Retângulo) desenhada por diferentes APIs de renderização (OpenGL, DirectX, Metal).

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Independência de Evolução**: Abstração e Implementação podem evoluir e serem estendidas sem interferência mútua.
- **Ocultação de Detalhes**: O cliente não fica exposto a detalhes de implementação de baixo nível da plataforma.
- **Princípio da Responsabilidade Única (SRP)**: Foca na lógica de alto nível na Abstração e detalhes do dispositivo na Implementação.
- **Princípio Aberto/Fechado (OCP)**: Novos dispositivos ou novos tipos de controle remoto podem ser criados sem quebrar o código existente.

### ❌ Desvantagens
- **Complexidade do Design**: O padrão pode tornar o código mais complexo ao introduzir mais interfaces e relacionamentos de composição por delegação.

---

## 📚 Relação com Outros Padrões

- **Abstract Factory**: Pode ser utilizado em conjunto com o Bridge para configurar e criar conexões específicas entre Abstrações e Implementações.
- **Adapter**: Enquanto o Adapter resolve incompatibilidades em sistemas existentes, o Bridge é projetado de forma antecipada para manter abstrações e implementações separadas.
- **State**: Ajuda a abstração a alterar dinamicamente o comportamento de sua implementação em tempo de execução.

---

## 🚀 Como Usar

1. **Identifique** as dimensões independentes da sua aplicação (ex: interface do usuário vs. plataforma).
2. **Declare** as operações que a Abstração precisa na interface de Implementação.
3. **Crie** as implementações concretas para cada plataforma.
4. **Instancie** a Abstração passando o objeto de Implementação concreto desejado via construtor.
