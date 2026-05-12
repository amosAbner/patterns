package patterns.builder.builder;

import patterns.builder.model.Lanche;

/**
 * Builder específico para criar um Chicken Burguer.
 */
public class ChickenBurguerBuilder implements LancheBuilder {

    private Lanche lanche;

    @Override
    public void prepararPao() {
        // Cria o lanche com pão e proteína de frango
        lanche = new Lanche.Builder("Pão de hambúrguer", "Frango grelhado").montar();
    }

    @Override
    public void adicionarProteina() {
        // A proteína já foi definida no prepararPao
    }

    @Override
    public void adicionarAcompanhamentos() {
        // Adiciona acompanhamentos leves
        lanche = new Lanche.Builder(lanche.getPao(), lanche.getProteina())
                .comQueijo("Prato")
                .comAlface("Alface americana")
                .comTomate("Tomate")
                .montar();
    }

    @Override
    public void adicionarMolhos() {
        // Adiciona molho de iogurte
        lanche = new Lanche.Builder(lanche.getPao(), lanche.getProteina())
                .comQueijo(lanche.getQueijo())
                .comAlface(lanche.getAlface())
                .comTomate(lanche.getTomate())
                .comMolho("Molho de iogurte")
                .montar();
    }

    @Override
    public Lanche getLanche() {
        return lanche;
    }
}
