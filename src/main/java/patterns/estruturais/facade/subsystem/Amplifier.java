package patterns.estruturais.facade.subsystem;

/**
 * Classe do subsistema: Amplificador de áudio.
 */
public class Amplifier {
    
    private int volume;
    private StreamingPlayer player;

    public void on() {
        System.out.println("Amplificador: ligado.");
    }

    public void off() {
        System.out.println("Amplificador: desligado.");
    }

    public void setSurroundSound() {
        System.out.println("Amplificador: som surround 5.1 configurado.");
    }

    public void setVolume(int level) {
        this.volume = level;
        System.out.println("Amplificador: volume ajustado para " + volume + ".");
    }

    public void setStreamingPlayer(StreamingPlayer player) {
        this.player = player;
        System.out.println("Amplificador: reprodutor de streaming conectado.");
    }
}
