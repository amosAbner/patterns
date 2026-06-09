package patterns.estruturais.facade.subsystem;

/**
 * Classe do subsistema: Luzes da sala de cinema.
 */
public class TheaterLights {

    public void on() {
        System.out.println("Luzes: acesas (brilho máximo).");
    }

    public void off() {
        System.out.println("Luzes: apagadas.");
    }

    public void dim(int level) {
        System.out.println("Luzes: dimerizadas para " + level + "%.");
    }
}
