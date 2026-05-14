package patterns.criacionais.singleton.model;

/**
 * Interface que define as operações básicas de um Logger.
 * Será implementada tanto pelo Singleton quanto pelo Monostate.
 */
public interface Logger {

    /**
     * Registra uma mensagem de informação.
     */
    void info(String message);

    /**
     * Registra uma mensagem de erro.
     */
    void error(String message);

    /**
     * Retorna todas as mensagens registradas.
     */
    String getLogs();
}
