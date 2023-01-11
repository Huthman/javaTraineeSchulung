package com.materna.exercises.ownClassesAndInterfaces;

public class ElectronicDeviceWattComparator implements java.util.Comparator<ElectronicDevice>{

    @Override
    public int compare(ElectronicDevice o1, ElectronicDevice o2) {
//        Tracer.trace("compare[%n%s,%n%s%n]", o1.toString(),o2.toString());
        return Integer.compare(o1.getWatt(),o2.getWatt());
    }
}
