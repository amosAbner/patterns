package patterns.estruturais.facade.subsystem;

/**
 * Classe do subsistema: Reprodutor de mídia por streaming.
 */
public class StreamingPlayer {

    private String currentMovie;

    public void on() {
        System.out.println("Streaming Player: ligado.");
    }

    public void off() {
        System.out.println("Streaming Player: desligado.");
    }

    public void play(String movie) {
        this.currentMovie = movie;
        System.out.println("Streaming Player: reproduzindo \"" + currentMovie + "\".");
    }

    public void stop() {
        System.out.println("Streaming Player: parada a reprodução de \"" + currentMovie + "\".");
    }
}
