package patterns.comportamentais.memento.service;

import patterns.comportamentais.memento.caretaker.Historico;
import patterns.comportamentais.memento.originator.EditorTexto;

/**
 * Serviço que demonstra a simulação de escrita de texto e operações de undo usando Memento.
 */
public class MementoService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÃO MEMENTO - EDITOR DE TEXTO (UNDO)");
        System.out.println("==================================================\n");

        // Inicializa o Originator e o Caretaker
        EditorTexto editor = new EditorTexto();
        Historico historico = new Historico();

        // 1. Escrevendo o texto inicial e salvando estado
        System.out.println("--- Passo 1: Escrevendo texto inicial ---");
        editor.escrever("Design Patterns ");
        System.out.println("Texto atual: \"" + editor.getTexto() + "\"");
        
        // Salvando no histórico
        historico.push(editor.salvar());
        System.out.println("Checkpoint 1 salvo. (Tamanho do Histórico: " + historico.getTamanho() + ")");
        System.out.println();

        // 2. Adicionando mais texto e salvando
        System.out.println("--- Passo 2: Adicionando mais conteúdo ---");
        editor.escrever("em Java ");
        System.out.println("Texto atual: \"" + editor.getTexto() + "\"");
        
        // Salvando no histórico
        historico.push(editor.salvar());
        System.out.println("Checkpoint 2 salvo. (Tamanho do Histórico: " + historico.getTamanho() + ")");
        System.out.println();

        // 3. Adicionando uma frase errada
        System.out.println("--- Passo 3: Cometendo erro de escrita ---");
        editor.escrever("são muuuuuuito chatooooos.");
        System.out.println("Texto atual: \"" + editor.getTexto() + "\"");
        System.out.println();

        // 4. Executando Desfazer (Undo) para voltar ao Checkpoint 2
        System.out.println("--- Passo 4: Executando Desfazer (Undo) para remover erro ---");
        if (historico.getTamanho() > 0) {
            editor.restaurar(historico.pop());
        }
        System.out.println("Texto restaurado: \"" + editor.getTexto() + "\"");
        System.out.println("Tamanho do Histórico: " + historico.getTamanho());
        System.out.println();

        // 5. Executando segundo Desfazer (Undo) para voltar ao Checkpoint 1
        System.out.println("--- Passo 5: Executando Desfazer (Undo) novamente ---");
        if (historico.getTamanho() > 0) {
            editor.restaurar(historico.pop());
        }
        System.out.println("Texto restaurado: \"" + editor.getTexto() + "\"");
        System.out.println("Tamanho do Histórico: " + historico.getTamanho());
        System.out.println();

        // 6. Tentando desfazer com histórico limpo
        System.out.println("--- Passo 6: Tentando Desfazer sem estados salvos ---");
        if (historico.getTamanho() > 0) {
            editor.restaurar(historico.pop());
        } else {
            System.out.println("Desfazer ignorado: Não há checkpoints salvos no histórico.");
        }
        System.out.println("Texto final no editor: \"" + editor.getTexto() + "\"");
    }
}
