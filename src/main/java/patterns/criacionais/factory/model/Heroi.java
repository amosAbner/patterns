package patterns.criacionais.factory.model;

/**
 * Classe concreta que representa um Herói.
 */
public class Heroi extends Personagem {

    public Heroi(String nome, String habilidade, int forca, int inteligencia) {
        super(nome, habilidade, forca, inteligencia, "HERÓI");
    }

    /**
     * Implementação da ação específica de um herói.
     * Heróis lutam pelo bem e protegem as pessoas.
     */
    @Override
    public void executarAcao() {
        System.out.println("✓ " + this.getNome() + " está protegendo os inocentes com sua habilidade: " + this.getHabilidade());
    }

    /**
     * Método que retorna a descrição específica de um herói.
     */
    @Override
    public void exibirDescricao() {
        System.out.println("\n╔════════════════════════════╗");
        System.out.println("║      HERÓI - DESCRIÇÃO     ║");
        System.out.println("╚════════════════════════════╝");
        super.exibirDescricao();
        System.out.println("Objetivo: Proteger a humanidade!");
    }
}
