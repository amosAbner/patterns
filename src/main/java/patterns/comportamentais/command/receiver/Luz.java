package patterns.comportamentais.command.receiver;

/**
 * Classe Receiver. Contém a lógica de negócio real para controlar luzes.
 */
public class Luz {
    private final String comodo;
    private boolean ligada = false;

    public Luz(String comodo) {
        this.comodo = comodo;
    }

    public String getComodo() {
        return comodo;
    }

    public boolean isLigada() {
        return ligada;
    }

    public void ligar() {
        this.ligada = true;
        System.out.println("[Luz] A luz do(a) " + comodo + " foi LIGADA.");
    }

    public void desligar() {
        this.ligada = false;
        System.out.println("[Luz] A luz do(a) " + comodo + " foi DESLIGADA.");
    }
}
