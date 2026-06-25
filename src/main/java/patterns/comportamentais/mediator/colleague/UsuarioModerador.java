package patterns.comportamentais.mediator.colleague;

import patterns.comportamentais.mediator.mediator.Mediator;

/**
 * Participante concreto (Concrete Colleague). Representa um moderador com regras de visualização especiais.
 */
public class UsuarioModerador extends Usuario {

    public UsuarioModerador(Mediator mediator, String nome) {
        super(mediator, nome);
    }

    @Override
    public void enviar(String mensagem) {
        String msgFormatada = "📢 [MODERAÇÃO] " + mensagem;
        System.out.println("[CHAT] " + nome + " envia: \"" + msgFormatada + "\"");
        mediator.enviarMensagem(msgFormatada, this);
    }

    @Override
    public void receber(String mensagem, String de) {
        System.out.println("👁️  [" + nome + " (Monitoramento) de " + de + "]: " + mensagem);
    }
}
