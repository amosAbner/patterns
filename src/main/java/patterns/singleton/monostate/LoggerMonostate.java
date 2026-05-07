package patterns.singleton.monostate;

import patterns.singleton.model.Logger;

/**
 * Implementação do padrão Monostate.
 * Diferente do Singleton, permite múltiplas instâncias,
 * mas todas compartilham o mesmo estado (static).
 */
public class LoggerMonostate implements Logger {

    // Estado compartilhado por todas as instâncias (static)
    private static StringBuilder logs = new StringBuilder();

    // Inicialização do estado compartilhado
    static {
        logs.append("Logger inicializado (Monostate)\n");
    }

    // Construtor público - permite múltiplas instâncias
    public LoggerMonostate() {
        // Não faz nada especial - o estado é compartilhado
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

    /**
     * Método para demonstrar que são instâncias diferentes,
     * mas com estado compartilhado.
     */
    public String getInstanceInfo() {
        return "Instância: " + this.hashCode() + " | Estado compartilhado";
    }
}
