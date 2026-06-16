package patterns.comportamentais.command.command;

import patterns.comportamentais.command.receiver.Luz;

/**
 * Comando concreto para Desligar a Luz.
 */
public class DesligarLuzCommand implements Command {
    private final Luz luz;

    public DesligarLuzCommand(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.desligar();
    }

    @Override
    public void undo() {
        luz.ligar();
    }
}
