package patterns.criacionais.abstractFactory.factory;

import patterns.criacionais.abstractFactory.model.Desktop;
import patterns.criacionais.abstractFactory.model.Notebook;

/**
 * Factory concreta para computadores de alto desempenho.
 * Cria desktops e notebooks otimizados para trabalho profissional.
 */
public class AltoDesempenhoFactory implements ComputadorFactory {

    @Override
    public Desktop criarDesktop() {
        return new Desktop("DESK_HP", "Intel Core i9", "64GB", "4TB NVMe", "1200W", "32\"");
    }

    @Override
    public Notebook criarNotebook() {
        return new Notebook("NB_HP", "Intel Core i7", "32GB", "2TB SSD", "8 horas", 2.0);
    }
}
