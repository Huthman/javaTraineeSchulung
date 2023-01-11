package com.materna.candyLord;

import java.awt.*;
import java.util.HashMap;

public class Neighborhood {
  private final String name;
  private final HashMap<Candy,Double> candyPriceAdjustment;
  private final Point coordinates;

  public Neighborhood(String name, Point coordinates, Candy[] candies){
    this.name = name;
    this.coordinates = coordinates;
    candyPriceAdjustment = generateDefaultPriceAdjustments(candies);
  }

  public Neighborhood changePriceAdjustment(Candy candy, double multiplier){
    candyPriceAdjustment.put(candy, multiplier);
    return this;
  }

  public double distanceTo(Neighborhood neighborhood){
    return coordinates.distance(neighborhood.coordinates);
  }

  public String getName() {
    return name;
  }

  public HashMap<Candy, Double> getCandyPriceAdjustment() {
    return candyPriceAdjustment;
  }

  private HashMap<Candy,Double> generateDefaultPriceAdjustments(Candy[] candies){
    if(candies == null){
      throw new IllegalArgumentException("Null not allowed as parameter");
    }
    for(Candy c : candies){
      if(c == null){
        throw new IllegalArgumentException("Null value inside of parameter Array not allowed");
      }
    }

    HashMap<Candy,Double> generated = new HashMap<>();
    for(Candy c: candies){
      generated.put(c,1.0);
    }
    return generated;
  }
}
