package patterns.comportamentais.state.state;

import patterns.comportamentais.state.context.ReprodutorMusica;

/**
 * Estado Concreto. Representa o reprodutor de música em estado parado.
 */
public class EstadoParado implements State {

    @Override
    public void tocar(ReprodutorMusica reprodutor) {
        System.out.println("[Reprodutor] Iniciando a reprodução da música.");
        reprodutor.setEstado(new EstadoReproduzindo());
    }

    @Override
    public void parar(ReprodutorMusica reprodutor) {
        System.out.println("[Reprodutor] O reprodutor já está parado.");
    }
}
