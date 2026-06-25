package patterns.comportamentais.state.state;

import patterns.comportamentais.state.context.ReprodutorMusica;

/**
 * Estado Concreto. Representa o reprodutor de música em estado tocando.
 */
public class EstadoReproduzindo implements State {

    @Override
    public void tocar(ReprodutorMusica reprodutor) {
        System.out.println("[Reprodutor] Pausando a reprodução da música.");
        reprodutor.setEstado(new EstadoPausado());
    }

    @Override
    public void parar(ReprodutorMusica reprodutor) {
        System.out.println("[Reprodutor] Parando a reprodução e voltando ao início.");
        reprodutor.setEstado(new EstadoParado());
    }
}
