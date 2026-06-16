package patterns.comportamentais.chainOfResponsibility.handler;

import patterns.comportamentais.chainOfResponsibility.model.Chamado;
import patterns.comportamentais.chainOfResponsibility.model.NivelDificuldade;

/**
 * Handler concreto responsável por tratar chamados de nível de dificuldade MEDIO.
 */
public class SuporteNivel2 extends SuporteHandler {
    @Override
    public void processar(Chamado chamado) {
        if (chamado.getNivel() == NivelDificuldade.MEDIO) {
            System.out.println("[Suporte Nível 2] Resolvendo chamado #" + chamado.getId() + ": \"" + chamado.getDescricao() + "\"");
            chamado.resolver("Suporte Técnico Nível 2 - Analista de Sistemas");
        } else if (proximoHandler != null) {
            System.out.println("[Suporte Nível 2] Chamado #" + chamado.getId() + " é muito complexo. Encaminhando para Nível 3...");
            proximoHandler.processar(chamado);
        } else {
            System.out.println("[Suporte Nível 2] Não há próximo nível configurado na cadeia para tratar o chamado #" + chamado.getId());
        }
    }
}
