package patterns.comportamentais.chainOfResponsibility.handler;

import patterns.comportamentais.chainOfResponsibility.model.Chamado;

/**
 * Classe base abstrata para todos os elos da cadeia de responsabilidade (Handlers).
 */
public abstract class SuporteHandler {
    protected SuporteHandler proximoHandler;

    /**
     * Define o próximo handler na cadeia. Retorna o próximo handler para permitir chamadas fluentes.
     */
    public SuporteHandler setNext(SuporteHandler proximoHandler) {
        this.proximoHandler = proximoHandler;
        return proximoHandler;
    }

    /**
     * Método abstrato de processamento do chamado.
     */
    public abstract void processar(Chamado chamado);
}
