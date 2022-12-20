package org.example.ownClassesAndInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Ship {

    private final ArrayList<ElectronicDevice> devices = new ArrayList<>();
    private static final ElectronicDeviceWattComparator ELECTRONIC_DEVICE_WATT_COMPARATOR = new ElectronicDeviceWattComparator();

    public void load(ElectronicDevice device) {
        Objects.requireNonNull(device, "received null, ElectronicDevice object expected");
        if (!devices.contains(device)) {
            if (device instanceof Radio radio) {
                if (radio.getVolume() == 0) {
                    Tracer.trace("Radio volume is 0, Radio was not added to the ships load");
                    return;
                }else{
                    Tracer.trace("Remember to pay license fee!");
                }
            }
            devices.add(device);
            devices.sort(ELECTRONIC_DEVICE_WATT_COMPARATOR);
            Tracer.trace(toString());
        }
    }

    public int countDevicesSwitchedOn() {
        return ElectronicDevice.numberOfElectronicDevicesSwitchedOn(devices.toArray(new ElectronicDevice[devices.size()]));
    }

    public void holiday(){
        for(ElectronicDevice device: devices){
            device.off();
        }
    }

    public ElectronicDevice findMostPowerConsumingElectronicDevice(){
        return Collections.max(devices,ELECTRONIC_DEVICE_WATT_COMPARATOR);
    }

    @Override
    public String toString() {
        return String.format("Ship:{%s}",devices);
    }

}
