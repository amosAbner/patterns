package patterns.comportamentais.state;

import patterns.comportamentais.state.service.StateService;

/**
 * Classe principal para executar a demonstração do padrão State.
 */
public class PatternStateApplication {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║          EXEMPLO DE USO DO PADRÃO STATE - REPRODUTOR             ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");

        StateService service = new StateService();
        service.executarExemplos();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIM DOS EXEMPLOS                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}
