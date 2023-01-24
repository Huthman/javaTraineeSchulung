package com.materna.candyLord;


public class Candy {
  private final String name;
  private final int minPrice;
  private final int maxPrice;
  private int count;
  private int currentPrice;

  public Candy(String name, int minPrice, int maxPrice){
    // make sure that minPrice is always the lower one of the two
    if(minPrice > maxPrice){
      int temp = minPrice;
      minPrice = maxPrice;
      maxPrice = temp;
    }
    this.name = name;
    this.minPrice = minPrice;
    this.maxPrice = maxPrice;
    count = 0;
    // preset currentPrice to the arithmetic mean
    currentPrice = (minPrice+maxPrice)/2;
  }

  public void calculateCurrentPrice(Neighborhood neighborhood){
    int baseRandom = minPrice + (int)Math.round(Math.random()*(maxPrice-minPrice));
    currentPrice = (int)Math.round(baseRandom*neighborhood.getCandyPriceAdjustment().get(this));

    if(currentPrice > maxPrice){
      currentPrice = maxPrice;
    }
    if(currentPrice < minPrice){
      currentPrice = minPrice;
    }
  }

  public void increaseCountBy(int amount){
    if(amount<0){
      throw new IllegalArgumentException("No negative Parameter allowed. Input was: "+amount);
    }
    count += amount;
  }

  public void reduceCountBy(int amount){
    if(amount<0){
      throw new IllegalArgumentException("No negative Parameter allowed. Input was: "+amount);
    }
    if(amount > count){
      throw new IllegalArgumentException("Parameter may not be greater than the current count. " +
              "Input was: "+amount);
    }
    count -= amount;
  }

  public String getName() {
    return name;
  }

  public int getCount() {
    return count;
  }

  public int getCurrentPrice() {
    return currentPrice;
  }
}
