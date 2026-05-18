package patterns.estruturais.bridge;

import patterns.estruturais.bridge.service.BridgeService;

/**
 * Classe principal para executar os exemplos do padrão Bridge.
 */
public class PatternBridgeApplication {

    public static void main(String[] args) {
        // Executar os exemplos do padrão Bridge
        BridgeService service = new BridgeService();
        service.executarExemplos();
    }
}

