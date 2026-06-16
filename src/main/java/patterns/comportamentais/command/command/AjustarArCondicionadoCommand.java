package patterns.comportamentais.command.command;

import patterns.comportamentais.command.receiver.ArCondicionado;

/**
 * Comando concreto para ajustar a temperatura do Ar Condicionado.
 */
public class AjustarArCondicionadoCommand implements Command {
    private final ArCondicionado ar;
    private final int novaTemperatura;
    private int temperaturaAnterior;
    private boolean estadoAnterior;

    public AjustarArCondicionadoCommand(ArCondicionado ar, int novaTemperatura) {
        this.ar = ar;
        this.novaTemperatura = novaTemperatura;
    }

    @Override
    public void execute() {
        this.estadoAnterior = ar.isLigado();
        this.temperaturaAnterior = ar.getTemperatura();
        
        if (!ar.isLigado()) {
            ar.ligar();
        }
        ar.setTemperatura(novaTemperatura);
    }

    @Override
    public void undo() {
        ar.setTemperatura(temperaturaAnterior);
        if (!estadoAnterior) {
            ar.desligar();
        }
    }
}
