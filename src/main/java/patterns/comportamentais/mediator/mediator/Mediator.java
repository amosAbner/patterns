package patterns.comportamentais.mediator.mediator;

import patterns.comportamentais.mediator.colleague.Usuario;

/**
 * Interface Mediator. Define o contrato para comunicação entre os objetos participantes.
 */
public interface Mediator {
    void enviarMensagem(String mensagem, Usuario remetente);
    void registrarUsuario(Usuario usuario);
}
