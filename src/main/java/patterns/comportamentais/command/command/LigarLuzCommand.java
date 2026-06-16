package patterns.comportamentais.command.command;

import patterns.comportamentais.command.receiver.Luz;

/**
 * Comando concreto para Ligar a Luz.
 */
public class LigarLuzCommand implements Command {
    private final Luz luz;

    public LigarLuzCommand(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.ligar();
    }

    @Override
    public void undo() {
        luz.desligar();
    }
}
