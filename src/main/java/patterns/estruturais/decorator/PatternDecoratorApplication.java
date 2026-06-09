package patterns.estruturais.decorator;

import patterns.estruturais.decorator.service.DecoratorService;

/**
 * Classe principal para executar os exemplos do padrão Decorator.
 */
public class PatternDecoratorApplication {

    public static void main(String[] args) {
        // Executar os exemplos do padrão Decorator
        DecoratorService service = new DecoratorService();
        service.executarExemplos();
    }
}
