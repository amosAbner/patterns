package patterns.estruturais.bridge.abstraction;

import patterns.estruturais.bridge.implementation.Device;

/**
 * Implementacao concreta da abstracao: controle remoto basico.
 */
public class BasicRemote extends RemoteControl {

    public BasicRemote(Device device) {
        super(device);
    }

    // Funcoes adicionais do controle basico podem ser adicionadas aqui
}

