package patterns.criacionais.abstractFactory.factory;

import patterns.criacionais.abstractFactory.model.Desktop;
import patterns.criacionais.abstractFactory.model.Notebook;

/**
 * Interface abstrata para a Factory de Computadores.
 * Define o contrato para criar famílias de produtos Computador.
 */
public interface ComputadorFactory {

    /**
     * Cria um Desktop da família específica.
     */
    Desktop criarDesktop();

    /**
     * Cria um Notebook da família específica.
     */
    Notebook criarNotebook();
}
