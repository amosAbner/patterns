package patterns.singleton;

import patterns.singleton.service.SingletonService;

/**
 * Classe principal para executar os exemplos dos padrões Singleton e Monostate.
 */
public class PatternSingletonApplication {

    public static void main(String[] args) {
        // Executar os exemplos dos padrões Singleton e Monostate
        SingletonService singletonService = new SingletonService();
        singletonService.executarExemplos();
    }
}
