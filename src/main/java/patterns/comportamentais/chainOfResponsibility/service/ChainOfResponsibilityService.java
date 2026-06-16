package patterns.comportamentais.chainOfResponsibility.service;

import patterns.comportamentais.chainOfResponsibility.handler.SuporteHandler;
import patterns.comportamentais.chainOfResponsibility.handler.SuporteNivel1;
import patterns.comportamentais.chainOfResponsibility.handler.SuporteNivel2;
import patterns.comportamentais.chainOfResponsibility.handler.SuporteNivel3;
import patterns.comportamentais.chainOfResponsibility.model.Chamado;
import patterns.comportamentais.chainOfResponsibility.model.NivelDificuldade;

import java.util.ArrayList;
import java.util.List;

/**
 * Serviço que gerencia e demonstra o uso do padrão Chain of Responsibility.
 */
public class ChainOfResponsibilityService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÃO CHAIN OF RESPONSIBILITY - SUPORTE TÉCNICO");
        System.out.println("==================================================\n");

        // 1. Configurando a cadeia de responsabilidade (Chain)
        SuporteHandler nivel1 = new SuporteNivel1();
        SuporteHandler nivel2 = new SuporteNivel2();
        SuporteHandler nivel3 = new SuporteNivel3();

        // Nível 1 repassa para Nível 2, que repassa para Nível 3
        nivel1.setNext(nivel2).setNext(nivel3);

        // 2. Criando chamados de suporte variados
        List<Chamado> chamados = new ArrayList<>();
        chamados.add(new Chamado("101", "Resetar senha do usuário 'joao.silva'", NivelDificuldade.BAIXO));
        chamados.add(new Chamado("102", "Instalar e configurar Java SDK 21 na máquina de testes", NivelDificuldade.MEDIO));
        chamados.add(new Chamado("103", "Falha de hardware/corrupção no banco de dados de produção", NivelDificuldade.ALTO));
        chamados.add(new Chamado("104", "Ataque cibernético em andamento bloqueando acesso externo", NivelDificuldade.CRITICO));

        // 3. Processando os chamados sempre a partir do primeiro elo (Nível 1)
        for (Chamado chamado : chamados) {
            System.out.println("--> Chamado #" + chamado.getId() + " recebido na triagem central.");
            System.out.println("    Descrição: " + chamado.getDescricao());
            System.out.println("    Criticidade: " + chamado.getNivel());
            
            // Inicia o fluxo
            nivel1.processar(chamado);

            if (chamado.isResolvido()) {
                System.out.println("    [RESULTADO] Resolvido por: " + chamado.getResolvedor() + "\n");
            } else {
                System.out.println("    [RESULTADO] PENDENTE - Chamado enviado para comitê extraordinário.\n");
            }
        }
    }
}
