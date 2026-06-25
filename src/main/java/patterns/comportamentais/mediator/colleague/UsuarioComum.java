package patterns.comportamentais.mediator.colleague;

import patterns.comportamentais.mediator.mediator.Mediator;

/**
 * Participante concreto (Concrete Colleague). Representa um usuário comum do chat.
 */
public class UsuarioComum extends Usuario {

    public UsuarioComum(Mediator mediator, String nome) {
        super(mediator, nome);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("[CHAT] " + nome + " envia: \"" + mensagem + "\"");
        mediator.enviarMensagem(mensagem, this);
    }

    @Override
    public void receber(String mensagem, String de) {
        System.out.println("--> [" + nome + " recebeu de " + de + "]: " + mensagem);
    }
}
