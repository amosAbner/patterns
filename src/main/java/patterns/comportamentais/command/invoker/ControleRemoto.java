package patterns.comportamentais.command.invoker;

import patterns.comportamentais.command.command.Command;
import java.util.Stack;

/**
 * Classe Invoker. Guarda referências para os comandos e os executa.
 * Mantém um histórico para a funcionalidade de desfazer (Undo).
 */
public class ControleRemoto {
    private Command botaoSlot;
    private final Stack<Command> historicoComandos = new Stack<>();

    public void setCommand(Command command) {
        this.botaoSlot = command;
    }

    public void pressionarBotao() {
        if (botaoSlot != null) {
            botaoSlot.execute();
            historicoComandos.push(botaoSlot);
        } else {
            System.out.println("[Controle Remoto] Nenhum comando associado a este slot.");
        }
    }

    public void pressionarDesfazer() {
        if (!historicoComandos.isEmpty()) {
            Command ultimoComando = historicoComandos.pop();
            System.out.print("[Controle Remoto - UNDO] Desfazendo ação anterior: ");
            ultimoComando.undo();
        } else {
            System.out.println("[Controle Remoto] Sem histórico de comandos para desfazer.");
        }
    }
}
