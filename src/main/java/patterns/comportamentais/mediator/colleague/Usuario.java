package patterns.comportamentais.mediator.colleague;

import patterns.comportamentais.mediator.mediator.Mediator;

/**
 * Classe base para os objetos participantes (Colleagues). 
 * Cada participante conhece apenas o mediador, nunca os outros participantes diretamente.
 */
public abstract class Usuario {
    protected final Mediator mediator;
    protected final String nome;

    public Usuario(Mediator mediator, String nome) {
        this.mediator = mediator;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void enviar(String mensagem);
    public abstract void receber(String mensagem, String de);
}
