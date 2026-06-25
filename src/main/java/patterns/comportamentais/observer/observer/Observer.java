package patterns.comportamentais.observer.observer;

/**
 * Interface Observer (Observador). Define o contrato para receber atualizações do Subject.
 */
public interface Observer {
    void atualizar(String noticia);
    String getNome();
}
