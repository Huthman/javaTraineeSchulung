package com.materna.candyLord;

import java.awt.*;

public class City {
  private final double travelCostPerDistance;
  private Neighborhood[] neighborhoods;

  public City(double travelCostPerDistance, Candy[] candies){
    this.travelCostPerDistance = travelCostPerDistance;
    neighborhoods = generateDefaultNeighborhoods(candies);
  }

  public int calculateTravelCost(Neighborhood from, Neighborhood to){
    return (int)Math.round(from.distanceTo(to)*travelCostPerDistance);
  }

  public Neighborhood[] getNeighborhoods() {
    return neighborhoods;
  }

  private Neighborhood[] generateDefaultNeighborhoods(Candy[] candies){
    Neighborhood[] generatedNeighborhoods = new Neighborhood[8];

    generatedNeighborhoods[0] = new Neighborhood("A", new Point(0,0), candies);
    generatedNeighborhoods[1] = new Neighborhood("B", new Point(1,0), candies);
    generatedNeighborhoods[2] = new Neighborhood("C", new Point(2,0), candies);
    generatedNeighborhoods[3] = new Neighborhood("D", new Point(1,1), candies);
    generatedNeighborhoods[4] = new Neighborhood("E", new Point(2,1), candies);
    generatedNeighborhoods[5] = new Neighborhood("F", new Point(0,2), candies);
    generatedNeighborhoods[6] = new Neighborhood("G", new Point(1,2), candies);
    generatedNeighborhoods[7] = new Neighborhood("H", new Point(2,2), candies);

    //TODO: add cost price variations to candies in different Locations

    return generatedNeighborhoods;
  }
}
