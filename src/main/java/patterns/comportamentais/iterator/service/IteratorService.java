package patterns.comportamentais.iterator.service;

import patterns.comportamentais.iterator.collection.Playlist;
import patterns.comportamentais.iterator.iterator.Iterator;
import patterns.comportamentais.iterator.model.Musica;

/**
 * Serviço responsável por demonstrar o uso prático do padrão Iterator.
 */
public class IteratorService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÃO ITERATOR - PLAYLIST DE MÚSICAS");
        System.out.println("==================================================\n");

        // 1. Criar e popular a coleção (Playlist)
        Playlist playlist = new Playlist();
        playlist.adicionarMusica(new Musica("Bohemian Rhapsody", "Queen", "Rock"));
        playlist.adicionarMusica(new Musica("Take Five", "Dave Brubeck", "Jazz"));
        playlist.adicionarMusica(new Musica("Hotel California", "Eagles", "Rock"));
        playlist.adicionarMusica(new Musica("So What", "Miles Davis", "Jazz"));
        playlist.adicionarMusica(new Musica("Stairway to Heaven", "Led Zeppelin", "Rock"));
        playlist.adicionarMusica(new Musica("Clair de Lune", "Claude Debussy", "Clássica"));

        // 2. Demonstrar iteração sequencial
        System.out.println("--- 1. Tocando toda a Playlist (Iterador Sequencial) ---");
        Iterator<Musica> sequencial = playlist.criarIteratorSequencial();
        while (sequencial.hasNext()) {
            System.out.println("Tocando: " + sequencial.next());
        }
        System.out.println();

        // 3. Demonstrar iteração filtrada (Rock)
        System.out.println("--- 2. Tocando apenas músicas de Rock (Iterador por Gênero) ---");
        Iterator<Musica> rockIterator = playlist.criarIteratorPorGenero("Rock");
        while (rockIterator.hasNext()) {
            System.out.println("Tocando: " + rockIterator.next());
        }
        System.out.println();

        // 4. Demonstrar iteração filtrada (Jazz)
        System.out.println("--- 3. Tocando apenas músicas de Jazz (Iterador por Gênero) ---");
        Iterator<Musica> jazzIterator = playlist.criarIteratorPorGenero("Jazz");
        while (jazzIterator.hasNext()) {
            System.out.println("Tocando: " + jazzIterator.next());
        }
    }
}
