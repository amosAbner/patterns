package patterns.comportamentais.chainOfResponsibility.model;

/**
 * Classe que representa uma requisição/chamado de suporte a ser processado na cadeia.
 */
public class Chamado {
    private final String id;
    private final String descricao;
    private final NivelDificuldade nivel;
    private boolean resolvido = false;
    private String resolvedor;

    public Chamado(String id, String descricao, NivelDificuldade nivel) {
        this.id = id;
        this.descricao = descricao;
        this.nivel = nivel;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public NivelDificuldade getNivel() {
        return nivel;
    }

    public boolean isResolvido() {
        return resolvido;
    }

    public String getResolvedor() {
        return resolvedor;
    }

    public void resolver(String resolvedor) {
        this.resolvido = true;
        this.resolvedor = resolvedor;
    }
}
