package patterns.singleton.implementation;

import lombok.Getter;
import patterns.singleton.model.Logger;

/**
 * Implementação básica do padrão Singleton usando Eager Initialization.
 * A instância é criada no momento do carregamento da classe.
 */
public class LoggerSingleton implements Logger {

    /**
     * -- GETTER --
     *  Método público para obter a instância única criada no carregamento da classe (Eager)
     */
    @Getter
    private static final LoggerSingleton instance = new LoggerSingleton();

    private StringBuilder logs;

    // Construtor privado para impedir instanciação externa
    private LoggerSingleton() {
        this.logs = new StringBuilder();
        logs.append("Logger inicializado (Singleton Eager)\n");
    }

    @Override
    public void info(String message) {
        logs.append("[INFO] ").append(message).append("\n");
    }

    @Override
    public void error(String message) {
        logs.append("[ERROR] ").append(message).append("\n");
    }

    @Override
    public String getLogs() {
        return logs.toString();
    }
}
