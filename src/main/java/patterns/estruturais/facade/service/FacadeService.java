package patterns.estruturais.facade.service;

import patterns.estruturais.facade.facade.HomeTheaterFacade;
import patterns.estruturais.facade.subsystem.Amplifier;
import patterns.estruturais.facade.subsystem.Projector;
import patterns.estruturais.facade.subsystem.Screen;
import patterns.estruturais.facade.subsystem.StreamingPlayer;
import patterns.estruturais.facade.subsystem.TheaterLights;

/**
 * Serviço que demonstra a utilização do padrão Facade.
 * O código cliente interage exclusivamente com a Fachada,
 * sem precisar conhecer os detalhes de orquestração de cada aparelho.
 */
public class FacadeService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRAO FACADE - HOME THEATER");
        System.out.println("==================================================\n");

        // 1. Instanciando os componentes do subsistema (detalhes complexos)
        Amplifier amp = new Amplifier();
        Projector projector = new Projector();
        Screen screen = new Screen();
        StreamingPlayer player = new StreamingPlayer();
        TheaterLights lights = new TheaterLights();

        // 2. Criando a Fachada passando todas as dependências
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, projector, screen, player, lights);

        // 3. Cliente aciona operações complexas de forma simplificada
        homeTheater.watchMovie("Interestelar (2014)");

        // 4. Cliente desliga o sistema de forma igualmente simplificada
        homeTheater.endMovie();
    }
}
