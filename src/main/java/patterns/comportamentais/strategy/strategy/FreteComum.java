package patterns.comportamentais.strategy.strategy;

/**
 * Estratégia Concreta. Implementa o cálculo do frete comum.
 */
public class FreteComum implements FreteStrategy {
    @Override
    public double calcular(double peso) {
        // R$ 5,00 base mais R$ 1,50 por kg
        return 5.00 + (peso * 1.50);
    }
}
