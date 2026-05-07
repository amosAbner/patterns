package patterns.abstractFactory.factory;

import patterns.abstractFactory.model.Desktop;
import patterns.abstractFactory.model.Notebook;

/**
 * Factory concreta para computadores básicos.
 * Cria desktops e notebooks otimizados para uso cotidiano.
 */
public class BasicoFactory implements ComputadorFactory {

    @Override
    public Desktop criarDesktop() {
        return new Desktop("DESK_BASIC", "Intel Core i3", "8GB", "256GB SSD", "400W", "21\"");
    }

    @Override
    public Notebook criarNotebook() {
        return new Notebook("NB_BASIC", "Intel Core i3", "8GB", "256GB SSD", "4 horas", 1.5);
    }
}
