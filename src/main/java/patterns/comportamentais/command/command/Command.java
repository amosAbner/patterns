package patterns.comportamentais.command.command;

/**
 * Interface Command. Declara o método para executar operações e desfazer.
 */
public interface Command {
    void execute();
    void undo();
}
