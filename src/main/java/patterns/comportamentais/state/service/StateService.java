package patterns.comportamentais.state.service;

import patterns.comportamentais.state.context.ReprodutorMusica;

/**
 * Serviço responsável por simular e demonstrar as mudanças de comportamento orientadas ao estado (State).
 */
public class StateService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRÃO STATE - REPRODUTOR DE MÚSICA");
        System.out.println("==================================================\n");

        // 1. Instanciando o player (inicia no estado Parado)
        ReprodutorMusica player = new ReprodutorMusica();
        System.out.println("Reprodutor de música ligado. (Estado: Parado)\n");

        // 2. Chamar parar no estado parado
        System.out.println("--- 1. Chamando parar() com player Parado ---");
        player.parar();
        System.out.println();

        // 3. Tocar música (deve mudar para Reproduzindo)
        System.out.println("--- 2. Chamando tocar() com player Parado ---");
        player.tocar();
        System.out.println("-> Estado Atual: " + player.getEstado().getClass().getSimpleName());
        System.out.println();

        // 4. Pausar música (deve mudar para Pausado ao chamar tocar() de novo)
        System.out.println("--- 3. Chamando tocar() com player Reproduzindo ---");
        player.tocar();
        System.out.println("-> Estado Atual: " + player.getEstado().getClass().getSimpleName());
        System.out.println();

        // 5. Retomar música (deve voltar para Reproduzindo)
        System.out.println("--- 4. Chamando tocar() com player Pausado ---");
        player.tocar();
        System.out.println("-> Estado Atual: " + player.getEstado().getClass().getSimpleName());
        System.out.println();

        // 6. Parar música tocando (deve voltar para Parado)
        System.out.println("--- 5. Chamando parar() com player Reproduzindo ---");
        player.parar();
        System.out.println("-> Estado Atual: " + player.getEstado().getClass().getSimpleName());
    }
}
