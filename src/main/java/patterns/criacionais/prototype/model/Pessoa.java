package patterns.prototype.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Implementacao de Pessoa com Shallow Copy (cópia superficial).
 * Compartilha o objeto Endereco entre cópias.
 */
@Setter
@Getter
public class Pessoa implements Cloneable {

    private String nome;
    private int idade;
    private Endereco endereco;

    public Pessoa(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Shallow Copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", endereco=" + endereco +
                '}';
    }
}

