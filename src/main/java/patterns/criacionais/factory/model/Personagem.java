package patterns.criacionais.factory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Classe abstrata que representa um Personagem genérico.
 * Define os atributos comuns entre heróis e vilões.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class Personagem {

    // Atributos comuns a todos os personagens
    private String nome;
    private String habilidade;
    private int forca;
    private int inteligencia;
    private String tipo;

    /**
     * Método abstrato que define o comportamento específico de cada personagem.
     */
    public abstract void executarAcao();

    /**
     * Método que retorna a descrição do personagem.
     */
    public void exibirDescricao() {
        System.out.println("=== Personagem ===");
        System.out.println("Nome: " + this.nome);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Habilidade: " + this.habilidade);
        System.out.println("Força: " + this.forca);
        System.out.println("Inteligência: " + this.inteligencia);
    }
}
