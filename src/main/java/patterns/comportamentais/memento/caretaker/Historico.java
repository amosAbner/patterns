package patterns.comportamentais.memento.caretaker;

import patterns.comportamentais.memento.memento.EditorMemento;
import java.util.Stack;

/**
 * Classe Caretaker. Responsável por guardar os Mementos de forma sequencial, sem inspecionar ou alterar seus estados internos.
 */
public class Historico {
    private final Stack<EditorMemento> historico = new Stack<>();

    /**
     * Adiciona um estado (Memento) na pilha do histórico.
     */
    public void push(EditorMemento memento) {
        historico.push(memento);
    }

    /**
     * Remove e retorna o último estado salvo (Memento) para realizar a operação de desfazer.
     */
    public EditorMemento pop() {
        if (!historico.isEmpty()) {
            return historico.pop();
        }
        return null;
    }

    /**
     * Retorna o total de checkpoints guardados.
     */
    public int getTamanho() {
        return historico.size();
    }
}
