package patterns.estruturais.composite.composite;

import patterns.estruturais.composite.component.FileSystemItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o Composite (Composto) no padrão.
 * Uma pasta pode conter tanto arquivos simples (Leaf) quanto outras pastas
 * (Composite).
 */
public class Folder implements FileSystemItem {

    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Adiciona um item (arquivo ou pasta) a esta pasta.
     * 
     * @param item item a ser adicionado
     */
    public void add(FileSystemItem item) {
        children.add(item);
    }

    /**
     * Remove um item desta pasta.
     * 
     * @param item item a ser removido
     */
    public void remove(FileSystemItem item) {
        children.remove(item);
    }

    /**
     * Calcula dinamicamente o tamanho total da pasta.
     * Ele delega o cálculo do tamanho para cada um dos seus filhos recursivamente.
     * 
     * @return tamanho total acumulado em bytes
     */
    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemItem child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "PASTA: " + name + "/ (Tamanho total: " + formatSize(getSize()) + ")");
        for (FileSystemItem child : children) {
            child.print(indent + "  ");
        }
    }

    /**
     * Helper para formatar o tamanho em bytes para formatos mais legíveis.
     */
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
