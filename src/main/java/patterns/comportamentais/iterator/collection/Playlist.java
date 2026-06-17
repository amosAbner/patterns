package patterns.comportamentais.iterator.collection;

import patterns.comportamentais.iterator.iterator.Iterator;
import patterns.comportamentais.iterator.model.Musica;
import patterns.comportamentais.iterator.concreteiterator.SequentialIterator;
import patterns.comportamentais.iterator.concreteiterator.GeneroIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Coleção Concreta. Armazena uma lista de músicas e fornece fábricas para instanciar iterators.
 */
public class Playlist implements IterableCollection<Musica> {
    private final List<Musica> musicas = new ArrayList<>();

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    @Override
    public Iterator<Musica> criarIteratorSequencial() {
        return new SequentialIterator(this);
    }

    @Override
    public Iterator<Musica> criarIteratorPorGenero(String genero) {
        return new GeneroIterator(this, genero);
    }
}
