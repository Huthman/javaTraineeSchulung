package org.example.ownClassesAndInterfaces;

public class Tracer {
    private static boolean tracing = false;

    public static void trace(String toTrace) {
        trace(toTrace, null);
    }

    public static void on() {
        tracing = true;
    }

    public static void off() {
        tracing = false;
    }

    public static void trace(String format, Object... args) {
        if (tracing) {
            System.out.printf(format + "%n", args);
        }
    }
}
