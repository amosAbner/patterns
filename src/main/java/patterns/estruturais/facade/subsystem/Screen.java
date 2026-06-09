package patterns.estruturais.facade.subsystem;

/**
 * Classe do subsistema: Tela de Projeção retrátil.
 */
public class Screen {

    public void down() {
        System.out.println("Tela: descendo a tela de projeção.");
    }

    public void up() {
        System.out.println("Tela: recolhendo a tela de projeção.");
    }
}
