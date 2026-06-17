package patterns.comportamentais.iterator.iterator;

/**
 * Interface Iterator padrão. Declara os métodos para percorrer a coleção.
 */
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
