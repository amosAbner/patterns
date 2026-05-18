package patterns.estruturais.bridge.implementation;
/**
 * Implementacao concreta de Device: Radio.
 */
public class RadioDevice implements Device {

    private boolean on = false;
    private int volume = 20;
    private int channel = 88; // frequência simulada

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("Radio: ligado");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Radio: desligado");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.clamp(percent, 0, 100);
        System.out.println("Radio: volume ajustado para " + volume);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = Math.max(1, channel);
        System.out.println("Radio: frequencia ajustada para " + this.channel);
    }
}

