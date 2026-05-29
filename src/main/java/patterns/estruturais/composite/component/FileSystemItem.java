package patterns.estruturais.composite.component;

/**
 * Interface que atua como o Component do padrão Composite.
 * Define as operações comuns tanto para arquivos (folhas) quanto para pastas (compostos).
 */
public interface FileSystemItem {
    
    /**
     * Retorna o nome do item.
     * @return nome do item
     */
    String getName();

    /**
     * Retorna o tamanho do item em bytes.
     * Se for um arquivo, retorna o tamanho do arquivo.
     * Se for uma pasta, calcula recursivamente o tamanho de todos os itens contidos nela.
     * @return tamanho do item em bytes
     */
    long getSize();

    /**
     * Exibe a estrutura do item no console de forma hierárquica.
     * @param indent recuo/formatação visual da árvore
     */
    void print(String indent);
}
