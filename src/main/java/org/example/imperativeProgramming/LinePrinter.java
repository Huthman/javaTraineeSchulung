package org.example.imperativeProgramming;

public class LinePrinter {
    static void line() {
        System.out.println("♥".repeat(10));
    }

    static void line(String prefix, int len, char c, String suffix) {
        System.out.println(prefix + ("" + c).repeat(len) + suffix);
    }

    static void line(int len, char c) {
        line("", len, c, "");
    }

    static void line(int len) {
        line(len, '-');
    }

    static void line(int len, String s) {
        int strlen = s.length();
        if (strlen == 0) {
            return;
        }

        for (int i = 0; i < len; i++) {
            System.out.print(s.charAt(i%strlen));
        }
    }

}
