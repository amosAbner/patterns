package patterns.criacionais.prototype.model;

import lombok.Builder;
import lombok.Data;

/**
 * Classe que representa um Endereco.
 * Usada para demonstrar shallow copy vs deep copy.
 */
@Data
@Builder
public class Endereco {

    private String rua;
    private String numero;

    public Endereco(String rua, String numero) {
        this.rua = rua;
        this.numero = numero;
    }

    // Construtor cópia para Deep Clone
    public Endereco(Endereco outro) {
        this.rua = outro.rua;
        this.numero = outro.numero;
    }

    @Override
    public String toString() {
        return rua + ", " + numero;
    }
}

