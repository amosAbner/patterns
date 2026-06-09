package patterns.estruturais.facade.subsystem;

/**
 * Classe do subsistema: Projetor de vídeo.
 */
public class Projector {

    public void on() {
        System.out.println("Projetor: ligado.");
    }

    public void off() {
        System.out.println("Projetor: desligado.");
    }

    public void wideScreenMode() {
        System.out.println("Projetor: modo de tela widescreen (16:9) configurado.");
    }
}
