package patterns.comportamentais.command;

import patterns.comportamentais.command.service.CommandService;

/**
 * Classe principal para executar a demonstração do padrão Command.
 */
public class PatternCommandApplication {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║         EXEMPLO DE USO DO PADRÃO COMMAND - AUTOMAÇÃO             ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");

        CommandService service = new CommandService();
        service.executarExemplos();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIM DOS EXEMPLOS                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}
