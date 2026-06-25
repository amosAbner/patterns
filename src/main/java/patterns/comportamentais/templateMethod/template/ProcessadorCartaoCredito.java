package patterns.comportamentais.templateMethod.template;

/**
 * Subclasse concreta. Define etapas específicas para processamento de cartão de crédito.
 */
public class ProcessadorCartaoCredito extends ProcessadorPagamento {
    private final String numeroCartao;
    private final String cvv;

    public ProcessadorCartaoCredito(String numeroCartao, String cvv) {
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
    }

    @Override
    protected boolean validarDados() {
        System.out.println("[Cartão Crédito] Validando dados do cartão de crédito...");
        return numeroCartao != null && numeroCartao.length() == 16 && cvv != null && cvv.length() == 3;
    }

    @Override
    protected void executarDebito(double valor) {
        System.out.printf("[Cartão Crédito] Realizando cobrança de R$ %.2f no cartão final %s...\n", valor, numeroCartao.substring(12));
    }
}
