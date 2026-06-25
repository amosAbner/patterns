package patterns.comportamentais.observer.observer;

/**
 * Observador concreto. Recebe atualizações via SMS simulado.
 */
public class SmsSubscriber implements Observer {
    private final String nome;
    private final String telefone;

    public SmsSubscriber(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public void atualizar(String noticia) {
        System.out.println("[SMS] Enviando SMS para " + nome + " (" + telefone + "): \"" + noticia + "\"");
    }

    @Override
    public String getNome() {
        return nome;
    }
}
