package patterns.comportamentais.strategy.strategy;

/**
 * Estratégia Concreta. Implementa o frete grátis.
 */
public class FreteGratis implements FreteStrategy {
    @Override
    public double calcular(double peso) {
        return 0.00;
    }
}
