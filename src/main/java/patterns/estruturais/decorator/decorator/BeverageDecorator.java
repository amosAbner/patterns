package patterns.estruturais.decorator.decorator;

import patterns.estruturais.decorator.component.Beverage;

/**
 * Classe decoradora abstrata (Decorator) que implementa a interface do componente base.
 * Mantém uma referência para um objeto Beverage envelopado (composto) e delega
 * as chamadas de método para esse objeto.
 */
public abstract class BeverageDecorator implements Beverage {
    
    protected final Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double getCost() {
        return beverage.getCost();
    }
}
