package patterns.comportamentais.memento.memento;

/**
 * Classe que representa o Memento. Armazena o estado do EditorTexto de forma imutável.
 */
public class EditorMemento {
    private final String texto;

    public EditorMemento(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
