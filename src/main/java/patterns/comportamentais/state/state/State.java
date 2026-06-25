package patterns.comportamentais.state.state;

import patterns.comportamentais.state.context.ReprodutorMusica;

/**
 * Interface State (Estado). Define as operações que possuem comportamentos específicos dependendo do estado atual.
 */
public interface State {
    void tocar(ReprodutorMusica reprodutor);
    void parar(ReprodutorMusica reprodutor);
}
