package patterns.comportamentais.iterator.collection;

import patterns.comportamentais.iterator.iterator.Iterator;

/**
 * Interface que define as coleções que podem criar Iterators.
 */
public interface IterableCollection<T> {
    Iterator<T> criarIteratorSequencial();
    Iterator<T> criarIteratorPorGenero(String genero);
}
