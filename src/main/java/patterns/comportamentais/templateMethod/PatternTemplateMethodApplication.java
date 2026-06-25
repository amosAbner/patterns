package patterns.comportamentais.templateMethod;

import patterns.comportamentais.templateMethod.service.TemplateMethodService;

/**
 * Classe principal para executar a demonstração do padrão Template Method.
 */
public class PatternTemplateMethodApplication {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║        EXEMPLO DO PADRÃO TEMPLATE METHOD - PAGAMENTOS            ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");

        TemplateMethodService service = new TemplateMethodService();
        service.executarExemplos();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIM DOS EXEMPLOS                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}
