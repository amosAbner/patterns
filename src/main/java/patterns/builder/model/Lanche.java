package patterns.builder.model;

import lombok.Getter;

/**
 * Classe que representa um Lanche.
 * Produto complexo que será construído pelo Builder.
 */
@Getter
public class Lanche {

    // Getters
    // Ingredientes obrigatórios
    private final String pao;
    private final String proteina;

    // Ingredientes opcionais
    private final String queijo;
    private final String alface;
    private final String tomate;
    private final String cebola;
    private final String molho;
    private final String bacon;
    private final String ovo;

    // Construtor privado - só pode ser criado pelo Builder
    private Lanche(Builder builder) {
        this.pao = builder.pao;
        this.proteina = builder.proteina;
        this.queijo = builder.queijo;
        this.alface = builder.alface;
        this.tomate = builder.tomate;
        this.cebola = builder.cebola;
        this.molho = builder.molho;
        this.bacon = builder.bacon;
        this.ovo = builder.ovo;
    }

    /**
     * Método para exibir a composição completa do lanche.
     */
    public void mostrarComposicao() {
        StringBuilder composicao = new StringBuilder();
        composicao.append("LANCHE MONTADO:\n");
        composicao.append("   Pao: ").append(pao).append("\n");
        composicao.append("   Proteina: ").append(proteina).append("\n");

        if (queijo != null) composicao.append("   Queijo: ").append(queijo).append("\n");
        if (alface != null) composicao.append("   Alface: ").append(alface).append("\n");
        if (tomate != null) composicao.append("   Tomate: ").append(tomate).append("\n");
        if (cebola != null) composicao.append("   Cebola: ").append(cebola).append("\n");
        if (molho != null) composicao.append("   Molho: ").append(molho).append("\n");
        if (bacon != null) composicao.append("   Bacon: ").append(bacon).append("\n");
        if (ovo != null) composicao.append("   Ovo: ").append(ovo).append("\n");

        System.out.println(composicao);
    }

    /**
     * Classe Builder interna para construção fluente do Lanche.
     */
    public static class Builder {

        // Ingredientes obrigatórios
        private final String pao;
        private final String proteina;

        // Ingredientes opcionais
        private String queijo;
        private String alface;
        private String tomate;
        private String cebola;
        private String molho;
        private String bacon;
        private String ovo;

        /**
         * Construtor do Builder com ingredientes obrigatórios.
         */
        public Builder(String pao, String proteina) {
            this.pao = pao;
            this.proteina = proteina;
        }

        // Métodos fluentes para ingredientes opcionais
        public Builder comQueijo(String queijo) {
            this.queijo = queijo;
            return this;
        }

        public Builder comAlface(String alface) {
            this.alface = alface;
            return this;
        }

        public Builder comTomate(String tomate) {
            this.tomate = tomate;
            return this;
        }

        public Builder comCebola(String cebola) {
            this.cebola = cebola;
            return this;
        }

        public Builder comMolho(String molho) {
            this.molho = molho;
            return this;
        }

        public Builder comBacon(String bacon) {
            this.bacon = bacon;
            return this;
        }

        public Builder comOvo(String ovo) {
            this.ovo = ovo;
            return this;
        }

        /**
         * Método final que constrói o Lanche.
         */
        public Lanche montar() {
            return new Lanche(this);
        }
    }
}
