package patterns.estruturais.bridge.implementation;

/**
 * Implementor do Bridge: define a interface de baixo nivel para dispositivos.
 */
public interface Device {

    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);
}

