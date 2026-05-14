package patterns.criacionais.singleton.service;

import patterns.criacionais.singleton.implementation.LoggerSingleton;
import patterns.criacionais.singleton.implementation.LoggerSingletonEnum;
import patterns.criacionais.singleton.implementation.LoggerSingletonLazy;
import patterns.criacionais.singleton.model.Logger;
import patterns.criacionais.singleton.monostate.LoggerMonostate;

/**
 * Serviço que demonstra os padrões Singleton e Monostate.
 * Mostra as diferenças e aplicações práticas de cada padrão.
 */
public class SingletonService {

    /**
     * Executa todos os exemplos dos padrões Singleton e Monostate.
     */
    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÕES SINGLETON E MONOSTATE");
        System.out.println("==================================================\n");

        // Exemplo 1: Singleton com Eager Initialization
        exemplo1_SingletonEager();

        // Exemplo 2: Singleton com Lazy Initialization
        exemplo2_SingletonLazy();

        // Exemplo 3: Singleton com Enum
        exemplo3_SingletonEnum();

        // Exemplo 4: Monostate Pattern
        exemplo4_Monostate();

        // Exemplo 5: Comparação entre Singleton e Monostate
        exemplo5_Comparacao();
    }

    /**
     * Exemplo 1: Singleton com Eager Initialization.
     * A instância é criada no carregamento da classe.
     */
    private void exemplo1_SingletonEager() {
        System.out.println("\n--- Exemplo 1: Singleton Eager ---\n");

        // Obtendo instâncias - sempre a mesma
        Logger logger1 = LoggerSingleton.getInstance();
        Logger logger2 = LoggerSingleton.getInstance();

        System.out.println("Mesma instância? " + (logger1 == logger2));

        // Usando o logger
        logger1.info("Aplicação iniciada");
        logger2.error("Erro de conexão");

        System.out.println("Logs registrados:");
        System.out.println(logger1.getLogs());
    }

    /**
     * Exemplo 2: Singleton com Lazy Initialization.
     * A instância é criada apenas quando necessária.
     */
    private void exemplo2_SingletonLazy() {
        System.out.println("\n--- Exemplo 2: Singleton Lazy ---\n");

        // Obtendo instâncias - sempre a mesma
        Logger logger1 = LoggerSingletonLazy.getInstance();
        Logger logger2 = LoggerSingletonLazy.getInstance();

        System.out.println("Mesma instância? " + (logger1 == logger2));

        // Usando o logger
        logger1.info("Processo iniciado");
        logger2.error("Falha no processamento");

        System.out.println("Logs registrados:");
        System.out.println(logger1.getLogs());
    }

    /**
     * Exemplo 3: Singleton com Enum.
     * Abordagem moderna e thread-safe.
     */
    private void exemplo3_SingletonEnum() {
        System.out.println("\n--- Exemplo 3: Singleton Enum ---\n");

        // Usando a instância única do enum
        Logger logger = LoggerSingletonEnum.INSTANCE;

        // Registrando logs
        logger.info("Sistema operacional");
        logger.error("Erro de validação");

        System.out.println("Logs registrados:");
        System.out.println(logger.getLogs());
    }

    /**
     * Exemplo 4: Monostate Pattern.
     * Múltiplas instâncias, mas estado compartilhado.
     */
    private void exemplo4_Monostate() {
        System.out.println("\n--- Exemplo 4: Monostate Pattern ---\n");

        // Criando múltiplas instâncias
        LoggerMonostate logger1 = new LoggerMonostate();
        LoggerMonostate logger2 = new LoggerMonostate();
        LoggerMonostate logger3 = new LoggerMonostate();

        // Verificando que são instâncias diferentes
        System.out.println("Instâncias diferentes:");
        System.out.println("Logger1: " + logger1.getInstanceInfo());
        System.out.println("Logger2: " + logger2.getInstanceInfo());
        System.out.println("Logger3: " + logger3.getInstanceInfo());

        // Mas estado compartilhado
        logger1.info("Primeira mensagem");
        logger2.error("Erro crítico");
        logger3.info("Sistema finalizado");

        System.out.println("\nEstado compartilhado (mesmo conteúdo):");
        System.out.println(logger1.getLogs());
    }

    /**
     * Exemplo 5: Comparação entre Singleton e Monostate.
     */
    private void exemplo5_Comparacao() {
        System.out.println("\n--- Exemplo 5: Comparação Singleton vs Monostate ---\n");

        // Singleton - Uma instância
        Logger singleton = LoggerSingleton.getInstance();
        singleton.info("Log do Singleton");

        // Monostate - Múltiplas instâncias, estado compartilhado
        LoggerMonostate mono1 = new LoggerMonostate();
        LoggerMonostate mono2 = new LoggerMonostate();
        mono1.info("Log do Monostate 1");
        mono2.error("Log do Monostate 2");

        System.out.println("=== SINGLETON ===");
        System.out.println("Instância única: " + singleton.getClass().getSimpleName());
        System.out.println(singleton.getLogs());

        System.out.println("=== MONOSTATE ===");
        System.out.println("Instâncias: " + mono1.getClass().getSimpleName() + " (múltiplas)");
        System.out.println("Estado compartilhado:");
        System.out.println(mono1.getLogs());

        System.out.println("\n=== DIFERENÇAS ===");
        System.out.println("Singleton: 1 instância, construtor privado");
        System.out.println("Monostate: Múltiplas instâncias, estado compartilhado");
        System.out.println("Ambos garantem comportamento único/global");
    }
}
