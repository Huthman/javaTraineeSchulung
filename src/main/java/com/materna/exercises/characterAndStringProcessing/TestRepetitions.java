package com.materna.exercises.characterAndStringProcessing;

public class TestRepetitions {
    public static void main(String[] args) {
        System.out.println(repeatingStrings("🌼🌼🌼"));
        System.out.println(repeatingStrings("🌼🌻" + "🌼🌻" + "🌼🌻"));
        System.out.println(repeatingStrings("Ciao" + "Ciao"));
        System.out.println(repeatingStrings("Captain CiaoCiaoCaptain CiaoCiao"));
        System.out.println(repeatingStrings("🌕🌔🌓🌑"));
        System.out.println(repeatingStrings("CaptainCiaoCiaoCaptain"));
        System.out.println(repeatingStrings("🌼"));
        System.out.println(repeatingStrings(""));
        System.out.println(repeatingStrings(null));
    }

    static String repeatingStrings(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder repeatTest = new StringBuilder();
        for (int i = 0; i < s.length() / 2; i++) {
            repeatTest.append(s.charAt(i));
            if (s.length() % (i + 1) == 0 && s.equals(repeatTest.toString().repeat(s.length() / (i + 1)))) {
                return repeatTest.toString();
            }
        }
        return null;
    }
}
