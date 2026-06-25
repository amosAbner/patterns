package patterns.comportamentais.mediator;

import patterns.comportamentais.mediator.service.MediatorService;

/**
 * Ponto de entrada (Application) para demonstrar o padrão Mediator.
 */
public class PatternMediatorApplication {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║         EXEMPLO DE USO DO PADRÃO MEDIATOR - SALA DE CHAT         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");

        MediatorService service = new MediatorService();
        service.executarExemplos();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIM DOS EXEMPLOS                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}
