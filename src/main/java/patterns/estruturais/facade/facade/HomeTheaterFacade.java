package patterns.estruturais.facade.facade;

import patterns.estruturais.facade.subsystem.Amplifier;
import patterns.estruturais.facade.subsystem.Projector;
import patterns.estruturais.facade.subsystem.Screen;
import patterns.estruturais.facade.subsystem.StreamingPlayer;
import patterns.estruturais.facade.subsystem.TheaterLights;

/**
 * Classe que atua como a Fachada (Facade) no padrão.
 * Encapsula o subsistema complexo do home theater e fornece
 * uma interface simplificada para o cliente interagir com os aparelhos.
 */
public class HomeTheaterFacade {
    
    private final Amplifier amp;
    private final Projector projector;
    private final Screen screen;
    private final StreamingPlayer player;
    private final TheaterLights lights;

    public HomeTheaterFacade(Amplifier amp, 
                              Projector projector, 
                              Screen screen, 
                              StreamingPlayer player, 
                              TheaterLights lights) {
        this.amp = amp;
        this.projector = projector;
        this.screen = screen;
        this.player = player;
        this.lights = lights;
    }

    /**
     * Liga todos os aparelhos na ordem correta para assistir a um filme.
     * @param movie nome do filme
     */
    public void watchMovie(String movie) {
        System.out.println("\n--- [FACADE] Iniciando sessao de cinema: \"" + movie + "\" ---");
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setStreamingPlayer(player);
        amp.setSurroundSound();
        amp.setVolume(15);
        player.on();
        player.play(movie);
        System.out.println("--- [FACADE] Sessao iniciada. Divirta-se! ---\n");
    }

    /**
     * Desliga todos os aparelhos na ordem correta ao encerrar o filme.
     */
    public void endMovie() {
        System.out.println("\n--- [FACADE] Encerrando sessao de cinema ---");
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        player.stop();
        player.off();
        System.out.println("--- [FACADE] Cinema desligado. ---\n");
    }
}
