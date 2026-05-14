package patterns.criacionais.abstractFactory.model;

import lombok.Getter;

/**
 * Implementacao concreta de Desktop.
 * Representa um computador de mesa com alta performance.
 */
@Getter
public class Desktop extends Computador {

    private String potenciaFonte;
    private String tamanhoMonitor;

    public Desktop(String id, String processador, String memoria, String armazenamento,
                   String potenciaFonte, String tamanhoMonitor) {
        super(id, "Desktop", processador, memoria, armazenamento);
        this.potenciaFonte = potenciaFonte;
        this.tamanhoMonitor = tamanhoMonitor;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Desktop - Fonte: " + potenciaFonte + " | Monitor: " + tamanhoMonitor);
    }
}
