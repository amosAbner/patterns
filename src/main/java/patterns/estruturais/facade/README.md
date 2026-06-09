# Padrão Facade - Estrutural

## 🎯 Intenção
O **Facade** (Fachada) é um padrão de projeto estrutural que fornece uma interface simplificada para uma biblioteca, um framework, ou qualquer outro conjunto complexo de classes (um subsistema).

---

## 📋 Problema
À medida que um sistema cresce, ele naturalmente se divide em muitos pequenos subsistemas complexos para garantir modularidade e reusabilidade. No entanto, para que o cliente use esses recursos, ele precisa instanciar, configurar e coordenar vários objetos na ordem exata.

Por exemplo, para assistir a um filme em um Home Theater residencial avançado, você precisa:
1. Ligar as luzes da sala e dimerizá-las.
2. Descer a tela de projeção automática.
3. Ligar o projetor de vídeo e configurá-lo para modo widescreen.
4. Ligar o amplificador de som, conectar o player de mídia e ligar o modo surround.
5. Ligar o player de streaming e iniciar a reprodução.

Fazer tudo isso manualmente toda vez cria um forte acoplamento do código cliente com os detalhes internos de vários aparelhos. Se algum aparelho mudar a API ou for substituído, todo o código do cliente precisará ser reescrito.

---

## ✅ Solução
O padrão Facade sugere que você crie uma **Fachada** — uma única classe que fornece uma interface direta e simplificada de alto nível para os clientes. 

A Fachada (`HomeTheaterFacade`) conhece quais classes do subsistema são responsáveis por qual requisição e orquestra a chamada de todos os aparelhos nos bastidores. O cliente só precisa chamar um método como `watchMovie("Interestelar")` e a Fachada cuidará de toda a complexidade de ligar e configurar cada aparelho.

---

## 🏗️ Estrutura

### Componentes:
- **Facade (Fachada)**: Fornece acesso conveniente a uma parte específica da funcionalidade do subsistema. Ela sabe para onde direcionar a requisição do cliente e como operar todas as partes móveis.
- **Additional Facade (Fachada Adicional)**: Pode ser criada para evitar poluir uma única fachada com funcionalidades não relacionadas.
- **Complex Subsystem (Classes do Subsistema)**: Dezenas de classes diversas que não conhecem a existência da Fachada. Elas trabalham diretamente no domínio de suas responsabilidades individuais.
- **Client (Cliente)**: Usa a Fachada em vez de chamar os objetos do subsistema diretamente.

### No nosso exemplo:
- **HomeTheaterFacade**: A Fachada unificada (**Facade**)
- **Amplifier** / **Projector** / **Screen** / **StreamingPlayer** / **TheaterLights**: Os diversos componentes do cinema (**Complex Subsystem**)
- **FacadeService**: O código de demonstração (**Client**)

---

## 💡 Exemplo Prático - Controle de Home Theater

### Cenário
Orquestrar múltiplos aparelhos de áudio, vídeo e iluminação em comandos coordenados simples para "Assistir Filme" e "Desligar Cinema".

### Implementação

#### 1. Exemplo de Componente do Subsistema
[Amplifier.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/facade/subsystem/Amplifier.java)
```java
package patterns.estruturais.facade.subsystem;

public class Amplifier {
    public void on() { System.out.println("Amplificador: ligado."); }
    public void off() { System.out.println("Amplificador: desligado."); }
    public void setSurroundSound() { System.out.println("Amplificador: som surround 5.1 configurado."); }
    public void setVolume(int level) { System.out.println("Amplificador: volume ajustado para " + level + "."); }
    public void setStreamingPlayer(StreamingPlayer player) { /* ... */ }
}
```

#### 2. A Classe Fachada (Facade)
[HomeTheaterFacade.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/facade/facade/HomeTheaterFacade.java)
```java
package patterns.estruturais.facade.facade;

import patterns.estruturais.facade.subsystem.*;

public class HomeTheaterFacade {
    private final Amplifier amp;
    private final Projector projector;
    private final Screen screen;
    private final StreamingPlayer player;
    private final TheaterLights lights;

    public HomeTheaterFacade(Amplifier amp, Projector projector, Screen screen, StreamingPlayer player, TheaterLights lights) {
        this.amp = amp;
        this.projector = projector;
        this.screen = screen;
        this.player = player;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("\n--- [FACADE] Iniciando sessao de cinema: \"" + movie + "\" ---");
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setStreamingPlayer(player);
        amp.setSurroundSound();
        amp.setVolume(15);
        player.on();
        player.play(movie);
        System.out.println("--- [FACADE] Sessao iniciada. Divirta-se! ---\n");
    }

    public void endMovie() {
        System.out.println("\n--- [FACADE] Encerrando sessao de cinema ---");
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        player.stop();
        player.off();
        System.out.println("--- [FACADE] Cinema desligado. ---\n");
    }
}
```

---

## 🎯 Aplicações Práticas

### 1. **Conexões com APIs de Terceiros complexas**
- Bibliotecas de manipulação de imagens (onde converter, redimensionar e salvar exige inicializar múltiplos decodificadores e canais) são envolvidas por uma classe utilitária simples (`ImageHelper.saveThumbnail()`).

### 2. **Sistemas de Integração Financeira**
- Efetuar uma compra envolve: checar estoque, validar cartão de crédito com gateway, calcular frete com correios, emitir nota fiscal e enviar e-mail de confirmação. Uma classe `CheckoutFacade` simplifica tudo isso em um método `processOrder()`.

### 3. **Arquitetura de Microsserviços**
- Um gateway de API (API Gateway) atua como uma fachada, recebendo uma única requisição HTTP do app cliente e disparando sub-requisições internas para diversos microsserviços em background para consolidar os dados.

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Isolamento de complexidade**: Protege o cliente de lidar diretamente com a fragilidade de configurar manualmente múltiplos objetos.
- **Acoplamento Fraco**: Promove o desacoplamento entre o subsistema e seus clientes.
- **Facilidade de Uso**: Torna bibliotecas complexas muito mais fáceis de aprender e usar.
- **Portabilidade de subsistema**: Se o subsistema precisar ser trocado (ex: trocar a API de e-mail SendGrid por Mailgun), a mudança ocorre apenas dentro da Fachada, sem impactar nenhum cliente do sistema.

### ❌ Desvantagens
- **Risco de virar um "Objeto Deus"**: Uma fachada mal projetada pode acumular excesso de responsabilidade e acoplar-se a absolutamente todas as classes do sistema, tornando-se difícil de manter.
- **Bloqueio de recursos avançados**: A fachada simplifica o uso, mas pode acabar escondendo configurações customizadas que usuários avançados do subsistema gostariam de ajustar.

---

## 📚 Relação com Outros Padrões

- **Abstract Factory**: Pode ser usado junto com o Facade para criar os objetos do subsistema complexo de forma transparente.
- **Adapter**: O Adapter tenta converter uma interface existente incompatível para outra interface. O Facade define uma interface completamente nova e simplificada para um subsistema inteiro.
- **Mediator**: Semelhante porque ambos organizam a colaboração entre muitas classes. O Mediator centraliza a comunicação de classes que se conhecem, enquanto o Facade apenas fornece uma interface simples para um subsistema de classes unidirecionais que não conhecem a Fachada.
- **Singleton**: Muitas vezes, a classe Facade é implementada como um Singleton, já que apenas uma instância de controle é necessária.

---

## 🚀 Como Usar

1. **Verifique** se há uma interface simplificada que resolveria a maioria das necessidades dos clientes em relação a um subsistema.
2. **Crie** uma classe Facade que possua referências aos objetos do subsistema.
3. **Implemente** métodos que agrupem as chamadas coordenadas na ordem recomendada de inicialização/execução.
4. **Altere** o código do cliente para que ele dependa apenas da Fachada, delegando todo o trabalho pesado.
