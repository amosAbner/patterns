package patterns.comportamentais.strategy.service;

import patterns.comportamentais.strategy.context.CalculadoraFrete;
import patterns.comportamentais.strategy.strategy.FreteComum;
import patterns.comportamentais.strategy.strategy.FreteExpresso;
import patterns.comportamentais.strategy.strategy.FreteGratis;

/**
 * Serviço responsável por demonstrar o uso dinâmico do padrão Strategy.
 */
public class StrategyService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÃO STRATEGY - CÁLCULO DE FRETE");
        System.out.println("==================================================\n");

        CalculadoraFrete calculadora = new CalculadoraFrete();
        double pesoEncomenda = 5.0; // 5 kg
        System.out.println("Peso da encomenda: " + pesoEncomenda + " kg\n");

        // 1. Usando frete comum
        System.out.println("--- 1. Usando Estratégia de Frete Comum ---");
        calculadora.setStrategy(new FreteComum());
        double valorComum = calculadora.calcularFrete(pesoEncomenda);
        System.out.printf("Valor do frete comum: R$ %.2f\n\n", valorComum);

        // 2. Usando frete expresso
        System.out.println("--- 2. Usando Estratégia de Frete Expresso ---");
        calculadora.setStrategy(new FreteExpresso());
        double valorExpresso = calculadora.calcularFrete(pesoEncomenda);
        System.out.printf("Valor do frete expresso: R$ %.2f\n\n", valorExpresso);

        // 3. Usando frete grátis
        System.out.println("--- 3. Usando Estratégia de Frete Grátis ---");
        calculadora.setStrategy(new FreteGratis());
        double valorGratis = calculadora.calcularFrete(pesoEncomenda);
        System.out.printf("Valor do frete grátis: R$ %.2f\n", valorGratis);
    }
}
