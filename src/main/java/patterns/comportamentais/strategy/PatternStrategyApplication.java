package patterns.comportamentais.strategy;

import patterns.comportamentais.strategy.service.StrategyService;

/**
 * Ponto de entrada (Application) para demonstrar o padrão Strategy.
 */
public class PatternStrategyApplication {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║           EXEMPLO DE USO DO PADRÃO STRATEGY - FRETE              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");

        StrategyService service = new StrategyService();
        service.executarExemplos();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIM DOS EXEMPLOS                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}
