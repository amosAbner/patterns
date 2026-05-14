package patterns.estruturais.adapter;

import patterns.estruturais.adapter.service.AdapterService;

/**
 * Aplicação principal para demonstrar o padrão Adapter.
 * Executa exemplos práticos de uso do padrão com bancos de dados.
 */
public class PatternAdapterApplication {

    public static void main(String[] args) {
        // Executa os exemplos diretamente
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║         EXEMPLO DE USO DO PADRAO ADAPTER - BANCO DE DADOS        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝\n");

        // Executa os exemplos do padrão Adapter
        AdapterService adapterService = new AdapterService();
        adapterService.executarExemplos();

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FIM DOS EXEMPLOS                          ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}
