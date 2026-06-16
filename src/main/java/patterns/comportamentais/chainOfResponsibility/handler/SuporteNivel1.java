package patterns.comportamentais.chainOfResponsibility.handler;

import patterns.comportamentais.chainOfResponsibility.model.Chamado;
import patterns.comportamentais.chainOfResponsibility.model.NivelDificuldade;

/**
 * Handler concreto responsável por tratar chamados de nível de dificuldade BAIXO.
 */
public class SuporteNivel1 extends SuporteHandler {
    @Override
    public void processar(Chamado chamado) {
        if (chamado.getNivel() == NivelDificuldade.BAIXO) {
            System.out.println("[Suporte Nível 1] Resolvendo chamado #" + chamado.getId() + ": \"" + chamado.getDescricao() + "\"");
            chamado.resolver("Suporte Técnico Nível 1 - Atendente de Triagem");
        } else if (proximoHandler != null) {
            System.out.println("[Suporte Nível 1] Chamado #" + chamado.getId() + " é muito complexo. Encaminhando para Nível 2...");
            proximoHandler.processar(chamado);
        } else {
            System.out.println("[Suporte Nível 1] Não há próximo nível configurado na cadeia para tratar o chamado #" + chamado.getId());
        }
    }
}
