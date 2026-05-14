package patterns.criacionais.singleton.implementation;

import patterns.criacionais.singleton.model.Logger;

/**
 * Implementação do padrão Singleton usando Lazy Initialization.
 * A instância é criada apenas quando necessária (thread-safe).
 */
public class LoggerSingletonLazy implements Logger {

    // Instância única - volatile para thread safety
    private static volatile LoggerSingletonLazy instance;

    private final StringBuilder logs;

    // Construtor privado
    private LoggerSingletonLazy() {
        this.logs = new StringBuilder();
        logs.append("Logger inicializado (Singleton Lazy)\n");
    }

    /**
     * Método público para obter a instância única.
     * Usa double-checked locking para thread safety.
     */
    public static LoggerSingletonLazy getInstance() {
        if (instance == null) {
            synchronized (LoggerSingletonLazy.class) {
                if (instance == null) {
                    instance = new LoggerSingletonLazy();
                }
            }
        }
        return instance;
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
