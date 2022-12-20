package org.example.classesObjectsPackages;

import java.awt.*;

public class BermudaTriangle {

    // 3. Name of function: addPoint(int x,int y);
    // 5. Name of function: (inside(int x, int y)) / contains(Point p)
    public static void main(String[] args) {
        printMap(createRandomTriangle());
    }

    private static Polygon createRandomTriangle() {
        return resetWithRandomTriangle(new Polygon());
    }

    private static Polygon resetWithRandomTriangle(Polygon polygon){
        int xMax, yMax;
        xMax = yMax = 50;
        int x, y;

        polygon.reset();
        for (int i = 0; i < 3; i++) {
            x = (int) (Math.random() * (xMax + 1));
            y = (int) (Math.random() * (yMax + 1));
            polygon.addPoint(x, y);
        }


        return polygon;
    }

    private static void printMap(Polygon bermudaTriangle) {
        for (int y = 0; y < 50; y++) {
            if(y == 0 || y == 49){
                System.out.println("\uD83C\uDF08".repeat(50));
                continue;
            }
            for (int x = 0; x < 50; x++) {
                if(x == 0 || x == 49){
                    System.out.print("\uD83C\uDF08");
                    continue;
                }
                System.out.print(bermudaTriangle.contains(new Point(x, y)) ? "\uD83D\uDC19" : "\uD83C\uDF2B");
            }
            System.out.println();
        }
    }
}
