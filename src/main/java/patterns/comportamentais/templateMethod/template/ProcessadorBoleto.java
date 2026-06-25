package patterns.comportamentais.templateMethod.template;

/**
 * Subclasse concreta. Define etapas específicas para processamento de boleto bancário.
 */
public class ProcessadorBoleto extends ProcessadorPagamento {
    private final String codigoBarras;

    public ProcessadorBoleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    protected boolean validarDados() {
        System.out.println("[Boleto] Validando código de barras...");
        return codigoBarras != null && codigoBarras.length() == 47;
    }

    @Override
    protected void executarDebito(double valor) {
        System.out.printf("[Boleto] Emitindo boleto de R$ %.2f com código de barras: %s\n", valor, codigoBarras);
    }

    @Override
    protected void finalizarProcesso() {
        System.out.println("[Boleto] PDF do boleto enviado para o e-mail do cliente.");
    }
}
