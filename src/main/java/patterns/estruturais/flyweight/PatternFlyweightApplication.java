package patterns.estruturais.flyweight;

import patterns.estruturais.flyweight.service.FlyweightService;

/**
 * Classe principal para executar os exemplos do padrão Flyweight.
 */
public class PatternFlyweightApplication {

    public static void main(String[] args) {
        // Executar os exemplos do padrão Flyweight
        FlyweightService service = new FlyweightService();
        service.executarExemplos();
    }
}
