package patterns.estruturais.decorator.decorator;

import patterns.estruturais.decorator.component.Beverage;

/**
 * Decorador Concreto (Concrete Decorator) que estende o comportamento de Beverage.
 * Adiciona a funcionalidade de colocar leite à bebida.
 */
public class MilkDecorator extends BeverageDecorator {

    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Leite";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.20; // Adiciona R$ 1,20 ao custo
    }
}
