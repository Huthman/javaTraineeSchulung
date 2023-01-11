package com.materna.exercises.ownClassesAndInterfaces;

import java.util.Objects;

public abstract class ElectronicDevice {

    private boolean isOn = false;
    private int watt = 0;

    public ElectronicDevice() {

    }

    public ElectronicDevice(ElectronicDevice device) {
        isOn = device.isOn;
    }

    public void on() {
        isOn = true;
    }

    public void off() {
        isOn = false;

    }

    public int getWatt() {
        return watt;
    }

    public void setWatt(int watt) {
        if (watt > 0) {
            this.watt = watt;
        }
    }

    public boolean isOn() {
        Tracer.trace("%s: %b", getClass().getSimpleName(), isOn);
        return isOn;
    }


    @Override
    public String toString() {
        return String.format("ElectronicDevice[isOn = %b, watt = %.1fkW]", isOn, (double)watt/1000);
    }

    public static int numberOfElectronicDevicesSwitchedOn(ElectronicDevice... devices) {
        int count = 0;
        for (ElectronicDevice device : Objects.requireNonNull(devices, "null received, ElectronicDevice... expected")) {
            if (device.isOn()) {
                count++;
            }
        }
        return count;
    }
}
