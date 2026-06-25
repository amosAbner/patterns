package patterns.comportamentais.templateMethod.service;

import patterns.comportamentais.templateMethod.template.ProcessadorPagamento;
import patterns.comportamentais.templateMethod.template.ProcessadorBoleto;
import patterns.comportamentais.templateMethod.template.ProcessadorCartaoCredito;

/**
 * Serviço que executa e demonstra a simulação de pagamentos com Template Method.
 */
public class TemplateMethodService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÃO TEMPLATE METHOD - PAGAMENTOS");
        System.out.println("==================================================\n");

        double valorPedido = 150.00;

        // 1. Processando boleto com código de barras válido
        System.out.println("--- 1. Boleto Bancário (Código Válido) ---");
        ProcessadorPagamento boletoValido = new ProcessadorBoleto("34191790001043510047910201500008272990000015000");
        boletoValido.processarPagamento(valorPedido);

        // 2. Processando boleto com código de barras inválido
        System.out.println("--- 2. Boleto Bancário (Código Inválido) ---");
        ProcessadorPagamento boletoInvalido = new ProcessadorBoleto("12345");
        boletoInvalido.processarPagamento(valorPedido);

        // 3. Processando cartão de crédito com dados válidos
        System.out.println("--- 3. Cartão de Crédito (Dados Válidos) ---");
        ProcessadorPagamento cartaoValido = new ProcessadorCartaoCredito("1234567890123456", "123");
        cartaoValido.processarPagamento(valorPedido);

        // 4. Processando cartão de crédito com dados inválidos
        System.out.println("--- 4. Cartão de Crédito (Dados Inválidos) ---");
        ProcessadorPagamento cartaoInvalido = new ProcessadorCartaoCredito("1234", "99");
        cartaoInvalido.processarPagamento(valorPedido);
    }
}
