package patterns.comportamentais.observer.observer;

/**
 * Observador concreto. Recebe atualizações via e-mail simulado.
 */
public class EmailSubscriber implements Observer {
    private final String nome;
    private final String email;

    public EmailSubscriber(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    @Override
    public void atualizar(String noticia) {
        System.out.println("[E-MAIL] Enviando e-mail para " + nome + " (" + email + "): \"" + noticia + "\"");
    }

    @Override
    public String getNome() {
        return nome;
    }
}
