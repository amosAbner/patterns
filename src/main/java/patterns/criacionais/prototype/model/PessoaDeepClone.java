package patterns.criacionais.prototype.model;

import lombok.Builder;
import lombok.Data;

/**
 * Implementacao de Pessoa com Deep Copy (cópia profunda).
 * Clona também o objeto Endereco interno.
 */
@Data
@Builder
public class PessoaDeepClone implements Cloneable {

    private String nome;
    private int idade;
    private Endereco endereco;

    public PessoaDeepClone(String nome) {
        this.nome = nome;
    }
    public PessoaDeepClone(String nome, int idade, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Deep Copy - Clona também o Endereco
    @Override
    public Object clone() throws CloneNotSupportedException {
        PessoaDeepClone copia = (PessoaDeepClone) super.clone();
        copia.endereco = new Endereco(this.endereco);
        return copia;
    }

    @Override
    public String toString() {
        return "PessoaDeepClone{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", endereco=" + endereco +
                '}';
    }
}

