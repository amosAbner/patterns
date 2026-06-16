package patterns.comportamentais.chainOfResponsibility;

import patterns.comportamentais.chainOfResponsibility.service.ChainOfResponsibilityService;

/**
 * Classe de ponto de entrada (Application) para demonstrar o padrão Chain of Responsibility.
 */
public class PatternChainOfResponsibilityApplication {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║    EXEMPLO DE USO DO PADRÃO CHAIN OF RESPONSIBILITY - SUPORTE    ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");

        // Executar os exemplos do padrão Chain of Responsibility
        ChainOfResponsibilityService service = new ChainOfResponsibilityService();
        service.executarExemplos();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIM DOS EXEMPLOS                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}
