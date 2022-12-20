package org.example.ownClassesAndInterfaces;

public class TV extends ElectronicDevice {

    private MonitorTube tube = new MonitorTube(this);

    @Override
    public void on() {
        tube.on();
        super.on();
        Tracer.trace("TV on");
    }

    @Override
    public void off() {
        tube.off();
        super.off();
        Tracer.trace("TV off");
    }

    public boolean tubeReferencesThisTV() {
        return this.equals(tube.getTv());
    }

}
