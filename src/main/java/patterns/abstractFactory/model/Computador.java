package patterns.abstractFactory.model;

import lombok.Getter;

/**
 * Classe abstrata que representa um Computador.
 * Define os atributos comuns para Desktop e Notebook.
 */
@Getter
public abstract class Computador {

    // Getters
    private String id;
    private String tipo;
    private String processador;
    private String memoria;
    private String armazenamento;

    public Computador(String id, String tipo, String processador, String memoria, String armazenamento) {
        this.id = id;
        this.tipo = tipo;
        this.processador = processador;
        this.memoria = memoria;
        this.armazenamento = armazenamento;
    }

    /**
     * Retorna as informacoes do computador em formato string.
     */
    public String obterInformacoes() {
        return String.format("ID: %s | Tipo: %s | CPU: %s | RAM: %s | Storage: %s",
                id, tipo, processador, memoria, armazenamento);
    }

    /**
     * Metodo abstrato para exibir detalhes especificos.
     */
    public abstract void exibirDetalhes();
}
