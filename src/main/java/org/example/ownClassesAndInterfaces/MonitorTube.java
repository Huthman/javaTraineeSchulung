package org.example.ownClassesAndInterfaces;

public class MonitorTube {
    private boolean isOn;
    private TV tv;

    public MonitorTube(TV tv){
        isOn = false;
        this.tv = tv;
    }

    public void on(){
        isOn = true;
        Tracer.trace("MonitorTube on");
    }

    public void off(){
        isOn = false;
        Tracer.trace("MonitorTube off");
    }

    public TV getTv() {
        return tv;
    }
}
