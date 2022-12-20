package org.example.imperativeProgramming;

public class randomColorSwitchCase {
    public static void main(String[] args) {

        String color;
        int random = (int) (Math.random()*3);
        color = switch(random){
            case 0 -> "red";
            case 1 -> "green";
            case 2 -> "blue";
            default -> "black";
        };

        System.out.println( color );

        System.out.printf( "<circle cx=\"20\" cy=\"20\" r=\"5\" fill=\"%s\"/>",
                color );
    }
}
