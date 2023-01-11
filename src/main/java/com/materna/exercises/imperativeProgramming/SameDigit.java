package com.materna.exercises.imperativeProgramming;

import java.util.Scanner;

public class SameDigit {
    public static void main(String[] args){
        System.out.println(sameDigit());
    }

    static boolean sameDigit(){
        Scanner s = new Scanner(System.in);
        int a,b,aFirst,aSecond,bFirst,bSecond;

        System.out.println("Insert first tile number");
        a = s.nextInt()%100;
        System.out.println("Insert second tile number");
        b = s.nextInt()%100;

        aFirst = a/10;
        aSecond = a%10;
        bFirst = b/10;
        bSecond = b%10;

        return aFirst == bFirst || aFirst == bSecond || aSecond == bFirst || aSecond == bSecond;
    }
}
