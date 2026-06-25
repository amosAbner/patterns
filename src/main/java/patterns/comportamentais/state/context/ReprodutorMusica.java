package patterns.comportamentais.state.context;

import patterns.comportamentais.state.state.State;
import patterns.comportamentais.state.state.EstadoParado;

/**
 * Classe Contexto. Armazena o estado atual e delega a execução das ações para a classe de estado correspondente.
 */
public class ReprodutorMusica {
    private State estado;

    public ReprodutorMusica() {
        // Inicializa com o estado parado padrão
        this.estado = new EstadoParado();
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public State getEstado() {
        return estado;
    }

    public void tocar() {
        estado.tocar(this);
    }

    public void parar() {
        estado.parar(this);
    }
}
