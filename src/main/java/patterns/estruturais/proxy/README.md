# Padrão Proxy - Estrutural

## 🎯 Intenção
O **Proxy** é um padrão de projeto estrutural que permite que você forneça um substituto ou um intermediário para outro objeto. Um proxy controla o acesso ao objeto original, permitindo que você execute alguma lógica antes ou depois que a requisição chegue ao objeto original.

---

## 📋 Problema
Imagine que você precisa integrar um serviço que realiza requisições lentas à rede ou consome muitos recursos do sistema (como baixar grandes arquivos de vídeo de uma API ou fazer queries complexas em um banco de dados). 

Se você instanciar essa classe diretamente e executar suas operações sempre que o cliente solicitar:
- O sistema ficará extremamente lento devido a requisições redundantes de dados idênticos.
- O cliente precisará inicializar a classe pesada mesmo em fluxos onde os dados daquela classe não sejam de fato necessários (gerando desperdício de memória).
- Ficará difícil injetar comportamentos transversais (como controle de acesso, auditoria e contagem de tempo de resposta) sem poluir a classe de lógica de negócio real.

---

## ✅ Solução
O padrão Proxy propõe a criação de uma nova classe **Proxy** que possui a mesma interface que a classe de serviço real (`YouTubeLib`).

O cliente interage com a classe Proxy de forma transparente. Ao receber as solicitações:
1. O Proxy intercepta a chamada.
2. Ele verifica se o recurso já está disponível localmente em memória (caching).
3. Se não estiver, ele inicializa preguiçosamente (lazy load) a classe de serviço real e faz o carregamento pela primeira vez.
4. Ele guarda o resultado em seu cache e retorna para o cliente.
5. Nas chamadas subsequentes, o Proxy resolve a requisição instantaneamente retornando o valor salvo do cache, poupando CPU, rede e banda.

---

## 🏗️ Estrutura

### Componentes:
- **Subject (Sujeito)**: Interface que define as operações comuns para o Serviço Real e para o Proxy. Permite que o cliente use o Proxy em qualquer lugar que espere o Serviço Real.
- **Real Subject (Sujeito Real)**: A classe de serviço real que executa a lógica de negócio pesada ou custosa.
- **Proxy**: Mantém uma referência ao Sujeito Real e controla seu ciclo de vida. Gerencia autorizações, cache, lazy loading ou log de dados.
- **Client (Cliente)**: Trabalha com ambos através da interface do Sujeito.

### No nosso exemplo:
- **YouTubeLib**: A interface comum (**Subject**)
- **RealYouTubeService**: O serviço de download lento original (**Real Subject**)
- **YouTubeCacheProxy**: A classe que armazena informações e arquivos em cache (**Proxy**)
- **ProxyService**: Classe cliente demonstrativa (**Client**)

---

## 💡 Exemplo Prático - Cache de Vídeos

### Cenário
Implementar um sistema de cache inteligente para downloads e metadados de vídeo. A primeira requisição deve buscar na API original (lenta), enquanto chamadas subsequentes ao mesmo vídeo devem responder instantaneamente.

### Implementação

#### 1. Interface Comum (Subject)
[YouTubeLib.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/proxy/subject/YouTubeLib.java)
```java
package patterns.estruturais.proxy.subject;

public interface YouTubeLib {
    String getVideoInfo(String videoId);
    byte[] downloadVideo(String videoId);
}
```

#### 2. Serviço Real Lento (Real Subject)
[RealYouTubeService.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/proxy/realsubject/RealYouTubeService.java)
```java
package patterns.estruturais.proxy.realsubject;

import patterns.estruturais.proxy.subject.YouTubeLib;

public class RealYouTubeService implements YouTubeLib {
    @Override
    public String getVideoInfo(String videoId) {
        simularRede(1500); // 1.5s delay
        return "Video-Info [ID: " + videoId + ", Titulo: 'Design Patterns em Java']";
    }

    @Override
    public byte[] downloadVideo(String videoId) {
        simularRede(2000); // 2s delay
        return new byte[]{12, 43, 67, 12, 98};
    }

    private void simularRede(int millis) {
        System.out.println("-> [REDE] Conectando aos servidores do YouTube...");
        try { Thread.sleep(millis); } catch (InterruptedException e) {}
    }
}
```

#### 3. Intermediário de Cache (Proxy)
[YouTubeCacheProxy.java](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/proxy/proxy/YouTubeCacheProxy.java)
```java
package patterns.estruturais.proxy.proxy;

import patterns.estruturais.proxy.realsubject.RealYouTubeService;
import patterns.estruturais.proxy.subject.YouTubeLib;
import java.util.HashMap;
import java.util.Map;

public class YouTubeCacheProxy implements YouTubeLib {
    private YouTubeLib realService;
    private final Map<String, String> cacheInfo = new HashMap<>();
    private final Map<String, byte[]> cacheVideos = new HashMap<>();

    private YouTubeLib getRealService() {
        if (realService == null) {
            realService = new RealYouTubeService(); // Lazy Loading
        }
        return realService;
    }

    @Override
    public String getVideoInfo(String videoId) {
        if (!cacheInfo.containsKey(videoId)) {
            String info = getRealService().getVideoInfo(videoId);
            cacheInfo.put(videoId, info);
            return info;
        }
        System.out.println("-> [PROXY] Retornando do cache.");
        return cacheInfo.get(videoId);
    }
    // ... downloadVideo() implementado de forma similar
}
```

---

## 🎯 Tipos Comuns de Proxy

### 1. **Virtual Proxy (Proxy Virtual)**
- Adia a inicialização de um objeto pesado (lazy load) até que ele seja de fato requisitado pelo cliente.

### 2. **Protection Proxy (Proxy de Proteção)**
- Controla os direitos de acesso de diferentes usuários a um objeto sensível (ex: checar privilégios de Administrador antes de permitir que uma query delete dados do banco).

### 3. **Remote Proxy (Proxy Remoto)**
- Representa um objeto localizado em outro espaço de endereçamento (outra máquina na rede, chamada de API remota ou microsserviço), cuidando de toda a complexidade de rede e serialização (ex: RPC, RMI).

### 4. **Smart Reference (Referência Inteligente / Caching Proxy)**
- Executa ações adicionais ao acessar um objeto (ex: guardar consultas em cache, auditar chamadas de logs, monitorar se há referências ativas para liberar recursos da memória).

---

## ⚖️ Vantagens e Desvantagens

### ✅ Vantagens
- **Inicialização Preguiçosa (Lazy Initialization)**: Você pode gerenciar o ciclo de vida do objeto pesado sem que o cliente precise saber.
- **Segurança e Isolamento**: Funciona mesmo se o serviço real não estiver ativo no momento da criação do proxy.
- **Princípio Aberto/Fechado (OCP)**: Introduz novos proxies sem precisar alterar o código do serviço real ou dos clientes.
- **Otimização de Performance**: Poupa custos de processamento através do cache interno.

### ❌ Desvantagens
- **Tempo de resposta ligeiramente maior**: Caso o proxy precise delegar para o serviço real, haverá uma camada extra de execução a ser percorrida.
- **Complexidade**: Aumenta o número de classes no projeto.

---

## 📚 Relação com Outros Padrões

- **Adapter**: O Adapter fornece uma interface diferente para o objeto adaptado. O Proxy fornece exatamente a mesma interface.
- **Decorator**: O Decorator adiciona uma ou mais responsabilidades extras ao objeto de forma acumulativa e transparente. O Proxy gerencia e controla o acesso ao objeto real.
- **Facade**: O Facade simplifica uma interface para um subsistema inteiro de classes. O Proxy gerencia e simplifica o acesso a um único objeto de serviço pesado.

---

## 🚀 Como Usar

1. **Crie** uma interface comum com os métodos de negócio fundamentais do serviço.
2. **Implemente** a classe de serviço pesada original (`RealYouTubeService`).
3. **Crie** a classe Proxy que implementa a mesma interface, armazena a referência para o serviço e intercepta as chamadas para injetar segurança, logs ou cache.
4. **Substitua** as instâncias diretas do serviço real pelo Proxy no código do cliente.
