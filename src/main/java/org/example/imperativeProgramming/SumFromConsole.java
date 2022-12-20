package org.example.imperativeProgramming;

import java.util.Scanner;

public class SumFromConsole {
    public static void main(String[] args) {
        int sum = 0;
        int last;
        Scanner scanner = new Scanner(System.in);
        do {
            last = scanner.nextInt();
            sum += last;
        }while(last != 0);

        System.out.printf("Sum: %d",sum);
    }
}
