package patterns.estruturais.bridge.abstraction;

import patterns.estruturais.bridge.implementation.Device;

/**
 * Controle remoto avançado que estende as operações básicas.
 */
public class AdvancedRemote extends RemoteControl {

    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }
}

