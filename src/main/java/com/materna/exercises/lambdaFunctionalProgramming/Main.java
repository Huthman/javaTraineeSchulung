package com.materna.exercises.lambdaFunctionalProgramming;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
  float f;
  record City(String name, int population){}
  public static void main(String[] args) {
//    Runnable              runnable   = ()->{};
//    ActionListener listener   = (e)->{};
//    Supplier<String> supplier   = () -> {return "";};
//    Consumer<Point> consumer   = (p)-> {};
//    Comparator<Rectangle> comparator = (r1,r2) -> {return 0;};

    List<City> cityTour = new ArrayList<>();
    City g = new City( "Gotham (cathedral)", 8_000_000 );
    City m = new City( "Metropolis (pleasure garden)", 1_600_000 );
    City h = new City( "Hogsmeade (Shopping Street)", 1_124 );
    Collections.addAll( cityTour, g, m, h );

    cityTour.removeIf(c -> c.population() < 10000);
    cityTour.replaceAll(c -> new City(c.name().substring(0,c.name().indexOf('(')),
            c.population()));
    cityTour.forEach((c) -> System.out.println(c));

    new Main().p();
  }
  public void p(){
    char c = 0;
    System.out.println(c);
  }



}
