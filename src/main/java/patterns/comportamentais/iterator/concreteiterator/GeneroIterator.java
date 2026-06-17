package patterns.comportamentais.iterator.concreteiterator;

import patterns.comportamentais.iterator.iterator.Iterator;
import patterns.comportamentais.iterator.model.Musica;
import patterns.comportamentais.iterator.collection.Playlist;

/**
 * Iterator concreto que filtra os itens de acordo com o gênero musical informado.
 */
public class GeneroIterator implements Iterator<Musica> {
    private final Playlist playlist;
    private final String generoAlvo;
    private int posicao = 0;

    public GeneroIterator(Playlist playlist, String generoAlvo) {
        this.playlist = playlist;
        this.generoAlvo = generoAlvo;
    }

    @Override
    public boolean hasNext() {
        while (posicao < playlist.getMusicas().size()) {
            Musica musica = playlist.getMusicas().get(posicao);
            if (musica.getGenero().equalsIgnoreCase(generoAlvo)) {
                return true;
            }
            posicao++;
        }
        return false;
    }

    @Override
    public Musica next() {
        if (hasNext()) {
            return playlist.getMusicas().get(posicao++);
        }
        return null;
    }
}
