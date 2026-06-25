package patterns.comportamentais.templateMethod.template;

/**
 * Classe Abstrata base que define o esqueleto do algoritmo (Template Method).
 */
public abstract class ProcessadorPagamento {

    /**
     * O Template Method. É final para evitar que subclasses alterem as etapas do algoritmo.
     */
    public final void processarPagamento(double valor) {
        prepararTransacao();
        if (validarDados()) {
            executarDebito(valor);
            enviarNotificacao();
        } else {
            System.out.println("[Processamento] Erro: Transação cancelada devido a dados inválidos.");
        }
        finalizarProcesso();
        System.out.println();
    }

    // Passo comum
    private void prepararTransacao() {
        System.out.println("[Processamento] Conectando aos sistemas bancários...");
    }

    // Passo abstrato - a ser implementado por cada subclasse
    protected abstract boolean validarDados();

    // Passo abstrato - a ser implementado por cada subclasse
    protected abstract void executarDebito(double valor);

    // Passo comum
    private void enviarNotificacao() {
        System.out.println("[Processamento] Comprovante digital gerado com sucesso.");
    }

    // Gancho (Hook) - implementação padrão vazia, pode ser opcionalmente sobrescrito
    protected void finalizarProcesso() {
        System.out.println("[Processamento] Conexão bancária finalizada.");
    }
}
