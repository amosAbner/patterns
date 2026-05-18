package patterns.estruturais.bridge.implementation;

/**
 * Implementacao concreta de Device: TV.
 */
public class TVDevice implements Device {

    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("TV: ligada");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("TV: desligada");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.clamp(percent, 0, 100);
        System.out.println("TV: volume ajustado para " + volume);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = Math.max(1, channel);
        System.out.println("TV: canal ajustado para " + this.channel);
    }
}

