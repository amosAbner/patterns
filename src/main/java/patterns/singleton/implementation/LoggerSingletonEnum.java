package patterns.singleton.implementation;

import patterns.singleton.model.Logger;

/**
 * Implementação do padrão Singleton usando Enum.
 * Esta é a abordagem mais moderna e thread-safe recomendada.
 */
public enum LoggerSingletonEnum implements Logger {

    INSTANCE; // Instância única

    private StringBuilder logs;

    // Construtor do enum (chamado automaticamente)
    LoggerSingletonEnum() {
        this.logs = new StringBuilder();
        logs.append("Logger inicializado (Singleton Enum)\n");
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
