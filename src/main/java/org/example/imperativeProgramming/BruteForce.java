package org.example.imperativeProgramming;

public class BruteForce {
    public static void main(String[] args) {
        int solution;
        boolean allDifferent;
        for (int x = 0; x <= 9; x++) {
            for (int o = 0; o <= 9; o++) {
                for (int l = 0; l <= 9; l++) {
                    for (int t = 0; t <= 9; t++) {
                        solution = (x + l - t) * 100 + (o + x - l) * 10 + (l + x - t);
                        if (solution == t) {
                            allDifferent = x != o && x != l && x != t
                                    && o != l && o != t
                                    && l != t;
                            if (allDifferent) {
                                System.out.println("All different");
                            }
                            System.out.printf("X: %d, O: %d, L: %d, T: %d %n", x, o, l, t);
                        }
                    }
                }
            }
        }
    }
}
