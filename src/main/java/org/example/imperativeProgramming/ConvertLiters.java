package org.example.imperativeProgramming;

import java.util.Locale;

public class ConvertLiters {
    public static void main(String[] args) {
        double liquidInLiter;
        int scaledAmount;
        String unit;

        System.out.println("Input the liquid amount in Liter");
        liquidInLiter = new java.util.Scanner(System.in).nextDouble();

        if(liquidInLiter >= 1){
            scaledAmount = (int)liquidInLiter;
            unit = "l";
        } else if (liquidInLiter >= 0.1) {
            scaledAmount = (int)(liquidInLiter*100);
            unit = "cl";
        } else if (liquidInLiter >= 0.001) {
            scaledAmount = (int)(liquidInLiter * 1000);
            unit = "ml";
        } else{
            System.out.println("Value too small to display");
            return;
        }

        System.out.printf("approx. %d %s",scaledAmount,unit);
    }
}
