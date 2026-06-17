package patterns.comportamentais.iterator.model;

/**
 * Classe que representa o modelo de dados de uma música.
 */
public class Musica {
    private final String titulo;
    private final String artista;
    private final String genero;

    public Musica(String titulo, String artista, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "\"" + titulo + "\" por " + artista + " [" + genero + "]";
    }
}
