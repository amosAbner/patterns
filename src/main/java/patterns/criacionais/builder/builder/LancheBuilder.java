package patterns.criacionais.builder.builder;

import patterns.criacionais.builder.model.Lanche;

/**
 * Interface para os diferentes tipos de Builder de Lanche.
 * Define o contrato para construção de lanches específicos.
 */
public interface LancheBuilder {

    /**
     * Método para preparar o pão base.
     */
    void prepararPao();

    /**
     * Método para adicionar a proteína principal.
     */
    void adicionarProteina();

    /**
     * Método para adicionar os acompanhamentos.
     */
    void adicionarAcompanhamentos();

    /**
     * Método para adicionar molhos e temperos.
     */
    void adicionarMolhos();

    /**
     * Método para obter o lanche finalizado.
     */
    Lanche getLanche();
}
