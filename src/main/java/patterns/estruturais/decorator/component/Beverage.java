package patterns.estruturais.decorator.component;

/**
 * Interface que representa o Component no padrão Decorator.
 * Define a interface comum para os objetos que podem ter responsabilidades adicionadas dinamicamente.
 */
public interface Beverage {
    
    /**
     * Retorna a descrição detalhada da bebida.
     * @return descrição da bebida
     */
    String getDescription();

    /**
     * Retorna o preço/custo total da bebida.
     * @return custo da bebida em reais
     */
    double getCost();
}
