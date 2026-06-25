package patterns.comportamentais.observer.subject;

import patterns.comportamentais.observer.observer.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Subject (Sujeito/Publicador). Gerencia o cadastro e notificação dos observadores.
 */
public class CanalNoticias {
    private final String nomeCanal;
    private final List<Observer> inscritos = new ArrayList<>();
    private String ultimaNoticia;

    public CanalNoticias(String nomeCanal) {
        this.nomeCanal = nomeCanal;
    }

    public void inscrever(Observer observer) {
        inscritos.add(observer);
        System.out.println("[Canal " + nomeCanal + "] Novo inscrito cadastrado: " + observer.getNome());
    }

    public void desinscrever(Observer observer) {
        inscritos.remove(observer);
        System.out.println("[Canal " + nomeCanal + "] Inscrito removido: " + observer.getNome());
    }

    public void publicarNoticia(String noticia) {
        this.ultimaNoticia = noticia;
        System.out.println("\n--- [NOTÍCIA PUBLICADA NO " + nomeCanal.toUpperCase() + "]: \"" + noticia + "\" ---");
        notificarInscritos();
    }

    private void notificarInscritos() {
        for (Observer inscrito : inscritos) {
            inscrito.atualizar(ultimaNoticia);
        }
    }
}
