package patterns.estruturais.flyweight.context;

import patterns.estruturais.flyweight.flyweight.TreeType;

/**
 * Classe que atua como o Contexto no padrão.
 * Contém o estado extrínseco (coordenadas x, y únicas para cada árvore)
 * e uma referência para o objeto Flyweight correspondente.
 */
public class Tree {
    
    private final int x;
    private final int y;
    private final TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * Delega a renderização para o objeto Flyweight, passando o estado extrínseco por parâmetro.
     */
    public void draw() {
        type.draw(x, y);
    }

    public TreeType getType() {
        return type;
    }
}
