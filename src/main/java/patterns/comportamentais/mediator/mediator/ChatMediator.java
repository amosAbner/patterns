package patterns.comportamentais.mediator.mediator;

import patterns.comportamentais.mediator.colleague.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Mediador Concreto (Concrete Mediator). Gerencia a comunicação entre todos os usuários do chat.
 */
public class ChatMediator implements Mediator {
    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void enviarMensagem(String mensagem, Usuario remetente) {
        // Redireciona a mensagem a todos, exceto ao próprio remetente
        for (Usuario usuario : usuarios) {
            if (usuario != remetente) {
                usuario.receber(mensagem, remetente.getNome());
            }
        }
    }
}
