package com.materna.exercises.arrays;

import java.awt.Point;

public class NearestCinema {
  public static void main(String[] args) {
    Point[] points = {new Point(10, 20), new Point(12, 2), new Point(44, 4)};

    System.out.println(minDistance(points, 3));
  }


  static double minDistance(Point[] points, int size) {
    if (points == null || size == 0) {
      throw new IllegalArgumentException();
    }

    double min = points[0].distance(new Point());

    for (int i = 1; i < size && i < points.length; i++) {
      double distance = points[i].distance(new Point());
      if (distance < min) {
        min = distance;
      }
    }

    return min;
  }
}

