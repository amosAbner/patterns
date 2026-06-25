package patterns.comportamentais.strategy.strategy;

/**
 * Estratégia Concreta. Implementa o cálculo do frete expresso.
 */
public class FreteExpresso implements FreteStrategy {
    @Override
    public double calcular(double peso) {
        // R$ 15,00 base mais R$ 3,00 por kg
        return 15.00 + (peso * 3.00);
    }
}
