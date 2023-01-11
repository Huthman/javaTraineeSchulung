package com.materna.exercises.ownClassesAndInterfaces;

public class Firebox extends ElectronicDevice {
    public Firebox(){
        super();
        on();
    }
    @Override
    public void off(){
        Tracer.trace("Firebox can't be turned off");
    }

}
