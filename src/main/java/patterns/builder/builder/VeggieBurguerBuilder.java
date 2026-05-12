package patterns.builder.builder;

import patterns.builder.model.Lanche;

/**
 * Builder específico para criar um Veggie Burguer.
 */
public class VeggieBurguerBuilder implements LancheBuilder {

    private Lanche lanche;

    @Override
    public void prepararPao() {
        // Cria o lanche com pão e proteína vegetariana
        lanche = new Lanche.Builder("Pão integral", "Hambúrguer de grão de bico").montar();
    }

    @Override
    public void adicionarProteina() {
        // A proteína já foi definida no prepararPao
    }

    @Override
    public void adicionarAcompanhamentos() {
        // Adiciona acompanhamentos frescos e saudáveis
        lanche = new Lanche.Builder(lanche.getPao(), lanche.getProteina())
                .comQueijo("Queijo vegano")
                .comAlface("Alface roxa")
                .comTomate("Tomate orgânico")
                .comCebola("Cebola caramelizada")
                .montar();
    }

    @Override
    public void adicionarMolhos() {
        // Adiciona molho especial vegetariano
        lanche = new Lanche.Builder(lanche.getPao(), lanche.getProteina())
                .comQueijo(lanche.getQueijo())
                .comAlface(lanche.getAlface())
                .comTomate(lanche.getTomate())
                .comCebola(lanche.getCebola())
                .comMolho("Molho de tahine")
                .montar();
    }

    @Override
    public Lanche getLanche() {
        return lanche;
    }
}
