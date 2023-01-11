package com.materna.exercises.imperativeProgramming;

import java.util.Scanner;

public class TwentyOne {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int dealer,player;
        System.out.println("Enter dealer points");
        dealer = s.nextInt();
        System.out.println("Enter player points");
        player = s.nextInt();

        if(dealer < 2 || player <2 ){
            return;
        }

        if(dealer > 21 && player > 21){
            System.out.println(0);
        } else if (dealer > 21){
            System.out.println(player);
        } else if(player > 21){
            System.out.println(dealer);
        } else{
            System.out.println(player>dealer?player:dealer);
        }
    }
}
