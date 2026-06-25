package patterns.comportamentais.observer;

import patterns.comportamentais.observer.service.ObserverService;

/**
 * Classe principal para executar a demonstração do padrão Observer.
 */
public class PatternObserverApplication {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║         EXEMPLO DE USO DO PADRÃO OBSERVER - NEWSLETTER           ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");

        ObserverService service = new ObserverService();
        service.executarExemplos();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIM DOS EXEMPLOS                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}
