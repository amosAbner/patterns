package patterns.estruturais.composite.leaf;

import patterns.estruturais.composite.component.FileSystemItem;

/**
 * Classe que representa a Leaf (Folha) no padrão Composite.
 * Um arquivo é o nível mais baixo da hierarquia e não contém outros elementos.
 */
public class File implements FileSystemItem {

    private final String name;
    private final long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "ARQUIVO: " + name + " (" + formatSize(size) + ")");
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
