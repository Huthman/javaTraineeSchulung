package com.materna.exercises.characterAndStringProcessing;

public class TopToBottom {
    public static void main(String[] args) {
        System.out.println(printVerticalToHorizontalWriting(
                     "s u\n" +
                        "ey!\n" +
                        "ao"));
        System.out.println(printVerticalToHorizontalWriting(
                     "Hor\n" +
                        "e l\n" +
                        "lWd\n" +
                        "lo!"));
    }

    static String printVerticalToHorizontalWriting(String s) {
        String[] lines = s.split("\n");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lines[0].length(); i++) {
            for (int row = 0; row < lines.length; row++) {
                if (i < lines[row].length()) {
                    result.append(lines[row].charAt(i));
                }
            }
        }

        return result.toString();
    }
}
