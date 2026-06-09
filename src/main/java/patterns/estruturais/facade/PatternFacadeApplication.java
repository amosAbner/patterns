package patterns.estruturais.facade;

import patterns.estruturais.facade.service.FacadeService;

/**
 * Classe principal para executar os exemplos do padrão Facade.
 */
public class PatternFacadeApplication {

    public static void main(String[] args) {
        // Executar os exemplos do padrão Facade
        FacadeService service = new FacadeService();
        service.executarExemplos();
    }
}
