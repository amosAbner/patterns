package patterns.estruturais.flyweight.service;

import patterns.estruturais.flyweight.forest.Forest;
import patterns.estruturais.flyweight.factory.TreeFactory;
import patterns.estruturais.flyweight.context.Tree;

/**
 * Serviço que demonstra a aplicação do padrão Flyweight.
 * Planta diversas árvores e demonstra que tipos repetidos compartilham o mesmo objeto físico em memória,
 * minimizando o consumo geral de heap da JVM.
 */
public class FlyweightService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRAO FLYWEIGHT - FLORESTA DIGITAL");
        System.out.println("==================================================\n");

        Forest forest = new Forest();

        // 1. Plantando árvores (os tipos idênticos serão compartilhados automaticamente pela fábrica)
        System.out.println("--- 1. Plantando arvores ---");
        forest.plantTree(10, 20, "Carvalho", "Verde Escuro", "Textura Rústica");
        forest.plantTree(15, 35, "Carvalho", "Verde Escuro", "Textura Rústica"); // Reutilizado
        forest.plantTree(50, 80, "Pinheiro", "Verde Claro", "Textura Lisa");
        forest.plantTree(60, 95, "Pinheiro", "Verde Claro", "Textura Lisa"); // Reutilizado
        forest.plantTree(12, 22, "Carvalho", "Amarelo Outono", "Textura Rústica"); // Tipo diferente
        System.out.println();

        // 2. Desenhando as árvores
        System.out.println("--- 2. Renderizando a floresta ---");
        forest.draw();
        System.out.println();

        // 3. Mostrando as estatísticas de memória
        System.out.println("--- 3. Estatisticas de Memoria ---");
        int totalTrees = forest.getTreesCount();
        int totalTypes = TreeFactory.getTypesCount();
        
        System.out.println("Total de arvores criadas: " + totalTrees);
        System.out.println("Total de objetos TreeType mantidos em cache: " + totalTypes);
        System.out.println("Objetos economizados: " + (totalTrees - totalTypes));
        System.out.println();

        // 4. Provando que a referência na memória é compartilhada (mesma referência de objeto)
        System.out.println("--- 4. Validacao de Referencia ---");
        Tree arvore1 = forest.getTrees().get(0); // Carvalho (Verde Escuro)
        Tree arvore2 = forest.getTrees().get(1); // Carvalho (Verde Escuro)
        Tree arvore5 = forest.getTrees().get(4); // Carvalho (Amarelo Outono)

        System.out.println("Identidade do tipo da arvore 1: " + System.identityHashCode(arvore1.getType()));
        System.out.println("Identidade do tipo da arvore 2: " + System.identityHashCode(arvore2.getType()));
        System.out.println("Identidade do tipo da arvore 5: " + System.identityHashCode(arvore5.getType()));
        System.out.println("Arvore 1 e Arvore 2 compartilham a mesma instancia? " + (arvore1.getType() == arvore2.getType()));
        System.out.println("Arvore 1 e Arvore 5 compartilham a mesma instancia? " + (arvore1.getType() == arvore5.getType()));
    }
}
