package patterns.builder.builder;

import patterns.builder.model.Lanche;

/**
 * Builder específico para criar um X-Burger clássico.
 */
public class XBurguerBuilder implements LancheBuilder {

    private Lanche lanche;

    @Override
    public void prepararPao() {
        // Cria o lanche com pão e proteína básica
        lanche = new Lanche.Builder("Pão de hambúrguer", "Hambúrguer bovino").montar();
    }

    @Override
    public void adicionarProteina() {
        // A proteína já foi definida no prepararPao
    }

    @Override
    public void adicionarAcompanhamentos() {
        // Adiciona acompanhamentos clássicos
        lanche = new Lanche.Builder(lanche.getPao(), lanche.getProteina())
                .comQueijo("Cheddar")
                .comAlface("Alface americana")
                .comTomate("Tomate")
                .comCebola("Cebola roxa")
                .montar();
    }

    @Override
    public void adicionarMolhos() {
        // Adiciona molho especial
        lanche = new Lanche.Builder(lanche.getPao(), lanche.getProteina())
                .comQueijo(lanche.getQueijo())
                .comAlface(lanche.getAlface())
                .comTomate(lanche.getTomate())
                .comCebola(lanche.getCebola())
                .comMolho("Molho especial da casa")
                .montar();
    }

    @Override
    public Lanche getLanche() {
        return lanche;
    }
}
