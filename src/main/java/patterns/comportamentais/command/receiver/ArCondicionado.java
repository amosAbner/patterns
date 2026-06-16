package patterns.comportamentais.command.receiver;

/**
 * Classe Receiver. Contém a lógica de negócio real para controlar o ar condicionado.
 */
public class ArCondicionado {
    private final String comodo;
    private boolean ligado = false;
    private int temperatura = 22;

    public ArCondicionado(String comodo) {
        this.comodo = comodo;
    }

    public String getComodo() {
        return comodo;
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void ligar() {
        this.ligado = true;
        System.out.println("[Ar Condicionado] Ar do(a) " + comodo + " LIGADO em " + temperatura + "°C.");
    }

    public void desligar() {
        this.ligado = false;
        System.out.println("[Ar Condicionado] Ar do(a) " + comodo + " DESLIGADO.");
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
        if (ligado) {
            System.out.println("[Ar Condicionado] Temperatura do ar do(a) " + comodo + " ajustada para " + temperatura + "°C.");
        }
    }
}
