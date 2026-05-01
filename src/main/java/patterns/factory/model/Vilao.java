package patterns.factory.model;

/**
 * Classe concreta que representa um Vilão.
 */
public class Vilao extends Personagem {

    public Vilao(String nome, String habilidade, int forca, int inteligencia) {
        super(nome, habilidade, forca, inteligencia, "VILÃO");
    }

    /**
     * Implementação da ação específica de um vilão.
     * Vilões buscam seus objetivos malignos e perseguem heróis.
     */
    @Override
    public void executarAcao() {
        System.out.println("✗ " + this.getNome() + " está executando seu plano maligno com a habilidade: " + this.getHabilidade());
    }

    /**
     * Método que retorna a descrição específica de um vilão.
     */
    @Override
    public void exibirDescricao() {
        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║      VILÃO - DESCRIÇÃO     ║");
        System.out.println("╚════════════════════════════╝");
        super.exibirDescricao();
        System.out.println("Objetivo: Dominar o mundo!");
    }
}

