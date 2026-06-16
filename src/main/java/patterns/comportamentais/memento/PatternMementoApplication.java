package patterns.comportamentais.memento;

import patterns.comportamentais.memento.service.MementoService;

/**
 * Classe principal para executar a demonstração do padrão Memento.
 */
public class PatternMementoApplication {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║         EXEMPLO DE USO DO PADRÃO MEMENTO - EDITOR DE TEXTO       ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");

        MementoService service = new MementoService();
        service.executarExemplos();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIM DOS EXEMPLOS                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}
