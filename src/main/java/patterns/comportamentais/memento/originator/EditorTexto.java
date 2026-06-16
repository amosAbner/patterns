package patterns.comportamentais.memento.originator;

import patterns.comportamentais.memento.memento.EditorMemento;

/**
 * Classe Originator. Mantém o estado interno do editor e é capaz de criar e restaurar Mementos.
 */
public class EditorTexto {
    private String texto = "";

    public String getTexto() {
        return texto;
    }

    public void escrever(String novoTexto) {
        this.texto += novoTexto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Cria um checkpoint contendo o estado atual do texto.
     */
    public EditorMemento salvar() {
        return new EditorMemento(texto);
    }

    /**
     * Restaura o texto a partir de um checkpoint salvo.
     */
    public void restaurar(EditorMemento memento) {
        if (memento != null) {
            this.texto = memento.getTexto();
        }
    }
}
