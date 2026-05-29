package patterns.estruturais.composite.service;

import patterns.estruturais.composite.component.FileSystemItem;
import patterns.estruturais.composite.leaf.File;
import patterns.estruturais.composite.composite.Folder;

/**
 * Serviço que demonstra o uso do padrão Composite usando um exemplo de Sistema de Arquivos.
 */
public class CompositeService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRAO COMPOSITE - SISTEMA DE ARQUIVOS");
        System.out.println("==================================================\n");

        // 1. Criando arquivos individuais (Leaf)
        FileSystemItem doc1 = new File("README.md", 1524); // ~1.49 KB
        FileSystemItem img1 = new File("logo.png", 524288); // 500 KB (512.00 KB)
        FileSystemItem script1 = new File("build.sh", 128); // 128 B

        // 2. Criando pastas (Composite)
        Folder root = new Folder("projeto-principal");
        Folder docsFolder = new Folder("documentacao");
        Folder srcFolder = new Folder("src");
        Folder assetsFolder = new Folder("assets");

        // 3. Montando a estrutura em árvore (Composição)
        docsFolder.add(doc1);
        assetsFolder.add(img1);
        
        srcFolder.add(new File("Main.java", 2048)); // 2.00 KB
        srcFolder.add(new File("Utils.java", 1024)); // 1.00 KB

        // Montando o root
        root.add(script1);
        root.add(docsFolder);
        root.add(srcFolder);
        root.add(assetsFolder);

        // 4. Demonstrando o tratamento uniforme (Transparência)
        System.out.println("--- Exemplo 1: Exibindo detalhes de um arquivo individual (Folha/Leaf) ---");
        doc1.print("");
        System.out.println("Tamanho retornado pelo arquivo: " + formatSize(doc1.getSize()));
        System.out.println();

        System.out.println("--- Exemplo 2: Exibindo detalhes de um subdiretorio (Composite Parcial) ---");
        srcFolder.print("");
        System.out.println();

        System.out.println("--- Exemplo 3: Exibindo a estrutura completa a partir do Root (Composite Raiz) ---");
        root.print("");
        System.out.println();

        System.out.println("--- Exemplo 4: Removendo a pasta de assets e recalculando o tamanho ---");
        System.out.println("Tamanho total antes: " + formatSize(root.getSize()));
        root.remove(assetsFolder);
        System.out.println("Tamanho total depois: " + formatSize(root.getSize()));
        System.out.println("\nEstrutura atualizada:");
        root.print("");
    }

    private String formatSize(long sizeInBytes) {
        if (sizeInBytes < 1024) {
            return sizeInBytes + " B";
        } else if (sizeInBytes < 1024 * 1024) {
            return String.format("%.2f KB", sizeInBytes / 1024.0);
        } else {
            return String.format("%.2f MB", sizeInBytes / (1024.0 * 1024.0));
        }
    }
}
