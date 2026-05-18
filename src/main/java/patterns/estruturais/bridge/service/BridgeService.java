package patterns.estruturais.bridge.service;

import patterns.estruturais.bridge.abstraction.BasicRemote;
import patterns.estruturais.bridge.abstraction.AdvancedRemote;
import patterns.estruturais.bridge.implementation.RadioDevice;
import patterns.estruturais.bridge.implementation.TVDevice;
import patterns.estruturais.bridge.implementation.Device;

/**
 * Serviço que demonstra o uso do padrão Bridge.
 */
public class BridgeService {

    public void executarExemplos() {
        System.out.println("==================================================");
        System.out.println("  PADRAO BRIDGE - REMOTO E DISPOSITIVO");
        System.out.println("==================================================\n");

        // Exemplo 1: TV com Remote básico
        exemplo1_TVBasic();

        // Exemplo 2: Radio com Remote avançado
        exemplo2_RadioAdvanced();
    }

    private void exemplo1_TVBasic() {
        System.out.println("\n--- Exemplo 1: TV com BasicRemote ---\n");

        Device tv = new TVDevice();
        BasicRemote remote = new BasicRemote(tv);

        remote.togglePower();
        remote.volumeUp();
        remote.channelUp();
        remote.channelUp();
        remote.volumeDown();
        remote.togglePower();
    }

    private void exemplo2_RadioAdvanced() {
        System.out.println("\n--- Exemplo 2: Radio com AdvancedRemote ---\n");

        Device radio = new RadioDevice();
        AdvancedRemote advRemote = new AdvancedRemote(radio);

        advRemote.togglePower();
        advRemote.volumeUp();
        advRemote.mute();
        advRemote.channelUp();
        advRemote.togglePower();
    }
}

