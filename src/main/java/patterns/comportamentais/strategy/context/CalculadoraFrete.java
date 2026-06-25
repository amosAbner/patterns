package patterns.comportamentais.strategy.context;

import patterns.comportamentais.strategy.strategy.FreteStrategy;

/**
 * Classe Contexto. Mantém a referência para a estratégia de frete ativa e delega a execução.
 */
public class CalculadoraFrete {
    private FreteStrategy strategy;

    public void setStrategy(FreteStrategy strategy) {
        this.strategy = strategy;
    }

    public double calcularFrete(double peso) {
        if (strategy == null) {
            throw new IllegalStateException("Nenhuma estratégia de frete foi definida.");
        }
        return strategy.calcular(peso);
    }
}
