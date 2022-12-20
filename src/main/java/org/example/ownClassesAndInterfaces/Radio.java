package org.example.ownClassesAndInterfaces;

import java.util.Objects;

import static org.example.ownClassesAndInterfaces.Modulation.*;

public class Radio extends ElectronicDevice {
    private int volume;
    private double frequency;
    private Modulation modulation;

    public Radio() {
        this(0.);
    }

    public Radio(double frequency) {
        super();
        setFrequency(frequency);
        setModulation(FM);
    }

    public Radio(String stationName) {
        this(stationNameToFrequency(stationName));
    }

    public Radio(Radio toCopy) {
        super(Objects.requireNonNull(toCopy, "null given, Radio object expected"));
        frequency = toCopy.frequency;
        volume = toCopy.volume;
        modulation = toCopy.modulation;
    }

    public static double stationNameToFrequency(String name) {
        if (name == null) {
            return 0.0;
        }

        return switch (name.toLowerCase()) {
            case "walking the plank" -> 98.3;
            case "uncreative name" -> 100.7;
            case "1live" -> 106.7;
            default -> 0.0;
        };
    }

    public void volumeUp() {
        if (volume < 100) {
            volume++;
        }
    }

    public void volumeDown() {
        if (volume > 0) {
            volume--;
        }
    }

//    public String toString() {
//        return String.format("[volume=%d, is %s, sending on frequency %.1f with modulation %s]%n", volume, (isOn() ? "on" : "off"), frequency, modulation.toString());
//    }


    @Override
    public String toString() {
        return String.format("Radio{volume=%d, frequency=%.1f, modulation=%s, %s",
                volume, frequency, modulation, super.toString());
    }

    public Modulation getModulation() {
        return modulation;
    }

    public void setModulation(Modulation modulation) {
        this.modulation = Objects.requireNonNull(modulation, "Null is not allowed as Modulation");
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            volume = 0;
        }
        if (volume > 100) {
            volume = 100;
        }
        this.volume = volume;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
}
