package patterns.comportamentais.mediator.service;

import patterns.comportamentais.mediator.mediator.ChatMediator;
import patterns.comportamentais.mediator.mediator.Mediator;
import patterns.comportamentais.mediator.colleague.Usuario;
import patterns.comportamentais.mediator.colleague.UsuarioComum;
import patterns.comportamentais.mediator.colleague.UsuarioModerador;

/**
 * Serviço que demonstra o funcionamento e a simulação prática do padrão Mediator.
 */
public class MediatorService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÃO MEDIATOR - SALA DE CHAT");
        System.out.println("==================================================\n");

        // 1. Instanciando o Mediador Central (Sala de Chat)
        Mediator salaDeChat = new ChatMediator();

        // 2. Instanciando os Colleagues (Participantes) e associando-os ao mediador
        Usuario joao = new UsuarioComum(salaDeChat, "João");
        Usuario maria = new UsuarioComum(salaDeChat, "Maria");
        Usuario carlos = new UsuarioComum(salaDeChat, "Carlos");
        Usuario admin = new UsuarioModerador(salaDeChat, "Admin_Ana");

        // 3. Registrando os participantes no mediador central
        salaDeChat.registrarUsuario(joao);
        salaDeChat.registrarUsuario(maria);
        salaDeChat.registrarUsuario(carlos);
        salaDeChat.registrarUsuario(admin);

        // 4. Demonstrando a comunicação desacoplada
        System.out.println("--- 1. João envia uma mensagem ---");
        joao.enviar("Olá, pessoal! Tudo bem?");
        System.out.println();

        System.out.println("--- 2. Maria responde ao grupo ---");
        maria.enviar("Oi, João! Tudo ótimo por aqui.");
        System.out.println();

        System.out.println("--- 3. Moderadora envia mensagem oficial ---");
        admin.enviar("Lembrem-se das regras de boa convivência no chat.");
        System.out.println();

        System.out.println("--- 4. Carlos entra e envia uma mensagem ---");
        carlos.enviar("Oi pessoal, acabei de chegar!");
    }
}
