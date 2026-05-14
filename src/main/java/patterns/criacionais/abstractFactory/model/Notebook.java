package patterns.criacionais.abstractFactory.model;

import lombok.Getter;

/**
 * Implementacao concreta de Notebook.
 * Representa um computador portatil otimizado para mobilidade.
 */
@Getter
public class Notebook extends Computador {

    private String bateria;
    private double peso;

    public Notebook(String id, String processador, String memoria, String armazenamento,
                    String bateria, double peso) {
        super(id, "Notebook", processador, memoria, armazenamento);
        this.bateria = bateria;
        this.peso = peso;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Notebook - Bateria: " + bateria + " | Peso: " + peso + "kg");
    }
}
