package patterns.estruturais.decorator.decorator;

import patterns.estruturais.decorator.component.Beverage;

/**
 * Decorador Concreto (Concrete Decorator) que estende o comportamento de Beverage.
 * Adiciona a funcionalidade de colocar Chantilly à bebida.
 */
public class WhippedCreamDecorator extends BeverageDecorator {

    public WhippedCreamDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Chantilly";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.00; // Adiciona R$ 2,00 ao custo
    }
}
