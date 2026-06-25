package patterns.comportamentais.state.state;

import patterns.comportamentais.state.context.ReprodutorMusica;

/**
 * Estado Concreto. Representa o reprodutor de música em estado pausado.
 */
public class EstadoPausado implements State {

    @Override
    public void tocar(ReprodutorMusica reprodutor) {
        System.out.println("[Reprodutor] Retomando a reprodução da música.");
        reprodutor.setEstado(new EstadoReproduzindo());
    }

    @Override
    public void parar(ReprodutorMusica reprodutor) {
        System.out.println("[Reprodutor] Parando a música (estava pausada) e resetando.");
        reprodutor.setEstado(new EstadoParado());
    }
}
