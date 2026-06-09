package patterns.estruturais.flyweight.factory;

import patterns.estruturais.flyweight.flyweight.TreeType;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que atua como a Flyweight Factory (Fábrica de Pesos-Mosca).
 * Decide se cria um novo tipo ou reutiliza um existente a partir de um cache interno.
 */
public class TreeFactory {
    
    // Cache de tipos de árvores mapeados por uma chave combinada
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    /**
     * Retorna um tipo de árvore existente no cache ou cria um novo se não existir.
     */
    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "_" + color + "_" + texture;
        TreeType result = treeTypes.get(key);
        
        if (result == null) {
            result = new TreeType(name, color, texture);
            treeTypes.put(key, result);
            System.out.println("-> [FACTORY] Criando NOVO objeto TreeType em memoria: '" + name + "' (" + color + ", " + texture + ")");
        }
        
        return result;
    }

    /**
     * Retorna a quantidade total de tipos de árvores criados em memória.
     */
    public static int getTypesCount() {
        return treeTypes.size();
    }
}
