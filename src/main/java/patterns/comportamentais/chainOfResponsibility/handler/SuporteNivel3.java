package patterns.comportamentais.chainOfResponsibility.handler;

import patterns.comportamentais.chainOfResponsibility.model.Chamado;
import patterns.comportamentais.chainOfResponsibility.model.NivelDificuldade;

/**
 * Handler concreto responsável por tratar chamados de nível de dificuldade ALTO.
 */
public class SuporteNivel3 extends SuporteHandler {
    @Override
    public void processar(Chamado chamado) {
        if (chamado.getNivel() == NivelDificuldade.ALTO) {
            System.out.println("[Suporte Nível 3] Resolvendo chamado #" + chamado.getId() + ": \"" + chamado.getDescricao() + "\"");
            chamado.resolver("Suporte Técnico Nível 3 - Administrador de Redes/Banco de Dados");
        } else if (proximoHandler != null) {
            System.out.println("[Suporte Nível 3] Chamado #" + chamado.getId() + " é muito complexo. Encaminhando para o próximo nível...");
            proximoHandler.processar(chamado);
        } else {
            System.out.println("[Suporte Nível 3] Chamado #" + chamado.getId() + " (Nível " + chamado.getNivel() + ") atingiu o fim da linha de suporte e não pôde ser resolvido.");
        }
    }
}
