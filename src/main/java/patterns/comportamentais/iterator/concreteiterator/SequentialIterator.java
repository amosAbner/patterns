package patterns.comportamentais.iterator.concreteiterator;

import patterns.comportamentais.iterator.iterator.Iterator;
import patterns.comportamentais.iterator.model.Musica;
import patterns.comportamentais.iterator.collection.Playlist;

/**
 * Iterator concreto para percorrer sequencialmente todos os itens da playlist.
 */
public class SequentialIterator implements Iterator<Musica> {
    private final Playlist playlist;
    private int posicao = 0;

    public SequentialIterator(Playlist playlist) {
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return posicao < playlist.getMusicas().size();
    }

    @Override
    public Musica next() {
        if (hasNext()) {
            return playlist.getMusicas().get(posicao++);
        }
        return null;
    }
}
