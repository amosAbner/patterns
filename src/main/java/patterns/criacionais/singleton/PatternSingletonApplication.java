package patterns.criacionais.singleton;

import patterns.criacionais.singleton.service.SingletonService;

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
