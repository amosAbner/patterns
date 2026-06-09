package patterns.estruturais.flyweight.forest;

import patterns.estruturais.flyweight.context.Tree;
import patterns.estruturais.flyweight.factory.TreeFactory;
import patterns.estruturais.flyweight.flyweight.TreeType;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que atua como o Cliente/Contexto de negócio da floresta.
 * Gerencia a lista de árvores instanciadas.
 */
public class Forest {
    
    private final List<Tree> trees = new ArrayList<>();

    /**
     * Planta uma nova árvore usando a fábrica para obter o tipo compartilhado (Flyweight).
     */
    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    /**
     * Renderiza toda a floresta desenhando cada uma de suas árvores.
     */
    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }

    public List<Tree> getTrees() {
        return trees;
    }

    public int getTreesCount() {
        return trees.size();
    }
}
