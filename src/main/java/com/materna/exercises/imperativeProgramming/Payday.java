package com.materna.exercises.imperativeProgramming;

public class Payday {
    public static void main(String[] args) {
        double worth = 1000;
        double lowerBound = 0.9;
        double upperBound = 1.2;
        double offer = new java.util.Scanner(System.in).nextDouble();
        if(offer < worth * lowerBound || offer > worth * upperBound){
            System.out.println("You son of a bi***!");
        } else{
            System.out.println("Good boy!");
        }
    }
}
