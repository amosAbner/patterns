package patterns.builder.builder;

import patterns.builder.model.Lanche;

/**
 * Diretor que coordena a construção dos lanches usando os Builders.
 * Define a ordem de execução dos passos de construção.
 */
public class LancheDiretor {

    /**
     * Método que coordena a construção completa de um lanche.
     */
    public Lanche construirLanche(LancheBuilder builder) {
        builder.prepararPao();
        builder.adicionarProteina();
        builder.adicionarAcompanhamentos();
        builder.adicionarMolhos();

        return builder.getLanche();
    }

    /**
     * Método para construir lanche apenas com o básico (pão e proteína).
     */
    public Lanche construirLancheBasico(LancheBuilder builder) {
        builder.prepararPao();
        builder.adicionarProteina();

        return builder.getLanche();
    }
}
