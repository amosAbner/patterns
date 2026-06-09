package patterns.estruturais.decorator.concretecomponent;

import patterns.estruturais.decorator.component.Beverage;

/**
 * Classe que representa um Concrete Component (Componente Concreto) no padrão Decorator.
 * Define um objeto básico no qual responsabilidades adicionais podem ser anexadas.
 */
public class SimpleCoffee implements Beverage {

    @Override
    public String getDescription() {
        return "Café Simples";
    }

    @Override
    public double getCost() {
        return 2.50; // Custo básico de R$ 2,50
    }
}
