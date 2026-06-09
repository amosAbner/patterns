package patterns.estruturais.decorator.decorator;

import patterns.estruturais.decorator.component.Beverage;

/**
 * Decorador Concreto (Concrete Decorator) que estende o comportamento de Beverage.
 * Adiciona a funcionalidade de colocar açúcar à bebida.
 */
public class SugarDecorator extends BeverageDecorator {

    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Açúcar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.40; // Adiciona R$ 0,40 ao custo
    }
}
