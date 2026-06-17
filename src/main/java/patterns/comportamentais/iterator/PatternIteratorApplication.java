package patterns.comportamentais.iterator;

import patterns.comportamentais.iterator.service.IteratorService;

/**
 * Classe principal para executar a demonstração do padrão Iterator.
 */
public class PatternIteratorApplication {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║         EXEMPLO DE USO DO PADRÃO ITERATOR - PLAYLIST DE MUSICA   ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");

        IteratorService service = new IteratorService();
        service.executarExemplos();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIM DOS EXEMPLOS                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}
