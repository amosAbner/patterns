# patterns
Estudo sobre padrões de projeto

## 📚 Pacotes Disponíveis

### 🏗️ Padrões Criacionais

Neste pacote estão as implementações de padrões focados na criação de objetos, abstraindo a lógica de instanciação.

#### 🎯 **[factory](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/criacionais/factory)** (Factory Method)
Implementação completa do padrão **Factory Method** com tema de personagens (Heróis e Vilões).
- Personagens com atributos comuns (Nome, Habilidade, Força, Inteligência)
- Factory para criação de diferentes tipos de personagens
- Exemplos práticos de uso

#### 🔧 **[abstractFactory](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/criacionais/abstractFactory)**
Implementação do padrão **Abstract Factory** com famílias de computadores.
- Famílias: Alto Desempenho e Básica
- Produtos: Desktop e Notebook
- Factories para criação de famílias completas

#### 🔸 **[singleton](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/criacionais/singleton)** (e Monostate)
Implementações dos padrões **Singleton** e **Monostate** com tema de Logger.
- 3 implementações diferentes do Singleton (Eager, Lazy, Enum)
- Implementação do Monostate como alternativa
- Comparação prática entre os padrões

#### 🏗️ **[builder](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/criacionais/builder)**
Implementação do padrão **Builder** com construção de lanches.
- Builder fluente para lanches personalizados
- Builders específicos para tipos de hambúrguer
- Diretor opcional para construção automatizada
- Exemplos de customização avançada

#### 🧬 **[prototype](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/criacionais/prototype)**
Implementação do padrão **Prototype** com clonagem de objetos.
- Shallow Copy (cópia superficial) vs Deep Copy (cópia profunda)
- Clonagem de objetos complexos (Pessoa e Endereco)
- Combinação com padrão Builder
- Registro centralizado de protótipos

---

### 🧩 Padrões Estruturais

Neste pacote estão as implementações de padrões focados na composição de classes e objetos para formar estruturas maiores e flexíveis.

#### 🔌 **[adapter](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/adapter)**
Implementação do padrão **Adapter** utilizando integração de bancos de dados.
- Interface padronizada para operações de banco de dados
- Adaptadores para MySQL e MongoDB legados
- Integração transparente de sistemas incompatíveis

#### 🌉 **[bridge](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/bridge)**
Implementação do padrão **Bridge** com controles remotos e aparelhos.
- Divisão clara entre Abstração (Controle) e Implementação (Aparelho)
- Controles básicos e avançados gerenciando TV e Rádio
- Evolução independente das duas hierarquias

#### 🌿 **[composite](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/composite)**
Implementação do padrão **Composite** com sistema de arquivos.
- Estrutura em árvore representando Arquivos (folha) e Pastas (composto)
- Tratamento uniforme para cálculo de tamanhos de forma recursiva
- Polimorfismo e transparência para o cliente

#### 🎀 **[decorator](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/decorator)**
Implementação do padrão **Decorator** com montagem de cafés em cafeteria.
- Bebidas base (Café Simples, Espresso) decoradas dinamicamente
- Adição flexível de acompanhamentos (Leite, Açúcar, Chantilly)
- Composição acumulativa de custos e descrições sem herança múltipla

#### 🏛️ **[facade](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/facade)**
Implementação do padrão **Facade** com controle de Home Theater.
- Interface simplificada de alto nível para interagir com subsistema complexo
- Coordenação de luzes, tela, projetor, amplificador e player
- Métodos práticos para iniciar e encerrar sessões de cinema

#### 🪶 **[flyweight](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/flyweight)**
Implementação do padrão **Flyweight** com floresta digital.
- Compartilhamento de dados pesados e imutáveis (cor, textura) em cache
- Estado intrínseco (espécie) separado do estado extrínseco (coordenadas x, y)
- Renderização altamente otimizada em memória para milhares de árvores

#### 🛡️ **[proxy](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/estruturais/proxy)**
Implementação do padrão **Proxy** com cache de vídeos do YouTube.
- Controle de acesso, auditoria e interceptação de chamadas
- Cache inteligente local para evitar requisições de rede lentas
- Inicialização preguiçosa (lazy load) do serviço real sob demanda

---

### 🚦 Padrões Comportamentais

Neste pacote estão as implementações de padrões focados nos algoritmos e na atribuição de responsabilidades entre os objetos.

#### ⛓️ **[chainOfResponsibility](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/chainOfResponsibility)**
Implementação do padrão **Chain of Responsibility** com fluxo de atendimento do suporte técnico.
- Encadeamento dinâmico de níveis de suporte técnico (Nível 1, Nível 2 e Nível 3)
- Processamento condicional e delegação automática para o próximo nível
- Tratamento uniforme e tratamento de falhas ao fim da cadeia de atendimento

#### 💾 **[memento](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/memento)**
Implementação do padrão **Memento** com mecanismo de desfazer (Undo) em editor de texto.
- Salvamento de snapshots do estado interno (texto) de forma encapsulada e imutável
- Histórico sequencial controlado por pilha (Caretaker)
- Restauração de estados anteriores sem violação de encapsulamento

#### 🕹️ **[command](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/command)**
Implementação do padrão **Command** com sistema de automação residencial (Smart Home).
- Encapsulamento de requisições de controle (Luz, Ar Condicionado) em objetos Command
- Desacoplamento entre os botões disparadores (Invoker) e os aparelhos finais (Receiver)
- Suporte a múltiplos comandos sequenciais e funcionalidade de desfazer (Undo)

#### 🔄 **[iterator](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/iterator)**
Implementação do padrão **Iterator** com sistema de playlist de músicas.
- Abstração da estrutura de dados da coleção de músicas da playlist
- Iteradores especializados para navegação sequencial ou filtrada por gênero musical
- Acesso uniforme aos dados sem expor detalhes internos da coleção

#### 💬 **[mediator](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/mediator)**
Implementação do padrão **Mediator** com sala de chat e moderador.
- Centralização da comunicação de usuários através do objeto mediador
- Desacoplamento da comunicação direta do tipo N-para-N entre participantes
- Encapsulamento de regras de negócio de mensagens em um único nó centralizador

#### 🔔 **[observer](file:///c:/Users/absouza/Documents/workspace/patterns/src/main/java/patterns/comportamentais/observer)**
Implementação do padrão **Observer** com sistema de canal de notícias (Newsletter).
- Mecanismo de assinatura dinâmica para interessados (Observers) em eventos do publicador (Subject)
- Notificação push automática para múltiplos canais (E-mail e SMS)
- Desacoplamento e fluxo unidirecional de dados reativos


## 📖 Sobre o Projeto

Este projeto contém implementações didáticas e práticas de diferentes padrões de projeto em Java, com foco em:
- Exemplos simples e compreensíveis
- Código bem documentado
- Estrutura organizada
- Comparações entre padrões similares
