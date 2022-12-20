package org.example.imperativeProgramming;

import java.util.Locale;
import java.util.Scanner;

public class SvgCircle1 {
    public static void main(String[] args){
        int x /* = 100*/;
        int y /* = 100*/;
        double r /* = 10+Math.random()*20 */;
        Scanner s = new Scanner(System.in);


        System.out.println("Insert x");
        x = s.nextInt();
        System.out.println("Insert y");
        y = s.nextInt();
        System.out.println("Insert r");
        r = s.nextDouble();


        System.out.printf(Locale.ENGLISH,"<svg height=\"%d\"width = \"%d\">%n  <circle cx = \"%d\" cy = \"%d\" r = \"%s\" />%n</svg>",400,1000,x,y,r);
    }
}
