package patterns.estruturais.decorator.concretecomponent;

import patterns.estruturais.decorator.component.Beverage;

/**
 * Classe que representa outro Concrete Component (Componente Concreto) no padrão Decorator.
 * Define outra bebida base para demonstração do padrão.
 */
public class Espresso implements Beverage {

    @Override
    public String getDescription() {
        return "Café Espresso";
    }

    @Override
    public double getCost() {
        return 4.00; // Custo básico de R$ 4,00
    }
}
