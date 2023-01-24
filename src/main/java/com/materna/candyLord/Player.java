package com.materna.candyLord;

import java.util.Objects;

public class Player {
  private final int maxLoan;
  private int inventorySpace;
  private long debt;
  private long cash;
  private long accountBalance;
  private Neighborhood currentLocation;
  private Candy[] candies;

  public Player(Neighborhood startingNeighborhood) {
    maxLoan = 10000;
    inventorySpace = 100;
    cash = 2000;
    debt = 0;
    accountBalance = 0;
    this.currentLocation = Objects.requireNonNull(startingNeighborhood);
    candies = generateCandies();
  }

  public void lendFromLoanShark(long amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Negative parameters are not allowed. Given value: " + amount);
    }
    if (debt > 0) {
      throw new IllegalStateException("The loan shark wants his money back before lending you " +
              "more.");
    }
    if (amount > maxLoan) {
      throw new IllegalArgumentException("The loan shark is not willing to lend you that much " +
              "money");
    }


    debt = amount;
    cash += amount;
  }

  public void payOffLoanShark(long amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Negative parameters are not allowed. Given value: " + amount);
    }
    if (amount > cash) {
      throw new IllegalStateException("You don't have that much money. Given value: " + amount);
    }


    if (amount > debt) {
      cash -= debt;
      debt = 0;
    } else {
      cash -= amount;
      debt -= amount;
    }
  }

  public void depositMoney(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Negative parameters are not allowed. Given value: " + amount);
    }
    if (amount > cash) {
      throw new IllegalStateException("You don't have that kind of cash on hand. Given value: " + amount);
    }

    accountBalance += amount;
    cash -= amount;
  }

  public void withdrawMoney(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Negative parameters are not allowed. Given value: " + amount);
    }
    if (amount > accountBalance) {
      throw new IllegalStateException(String.format("You can't withdraw %d$ because your bank " +
              "account only contains %d$", amount, accountBalance));
    }

    accountBalance -= amount;
    cash += amount;
  }

  public void buyCandy(Candy candy, int amount) {
    int cost = Objects.requireNonNull(candy).getCurrentPrice() * amount;

    if (amount < 0) {
      throw new IllegalArgumentException("Negative parameters are not allowed. Given value: " + amount);
    }
    if (amount + countCandies() > inventorySpace) {
      throw new IllegalStateException(String.format("Your current maximum carry capacity is %d. " +
                      "You are already" +
                      " carrying %d candies. You cannot carry %d more!", inventorySpace,
              countCandies(),
              amount));
    }
    if (cost > cash) {
      throw new IllegalStateException(String.format("You don't have enough cash to pay for that " +
              "amount of " +
              "candies (cash: %d$, required %d$).", cash, cost));
    }

    cash -= cost;
    candy.increaseCountBy(amount);
  }

  public void sellCandy(Candy candy, int amount) {
    Objects.requireNonNull(candy);
    if (amount < 0) {
      throw new IllegalArgumentException("Negative parameters are not allowed. Given value: " + amount);
    }
    if (amount > candy.getCount()) {
      throw new IllegalStateException(String.format("You cannot sell %d%s because you only " +
              "own %d.", amount, candy.getName(), candy.getCount()));
    }

    candy.reduceCountBy(amount);
    cash += candy.getCurrentPrice() * amount;
  }

  public void travelTo(Neighborhood neighborhood, int cost) {
    if (cost > cash) {
      throw new IllegalStateException(String.format("You cannot afford this trip since it costs " +
              "%d$ while you only have %d$ on you.", cost, cash));
    }
    if(neighborhood.equals(currentLocation)){
      throw new IllegalStateException(String.format("You are already at %s, no need to travel " +
              "there", currentLocation.getName()));
    }

    cash -= cost;
    currentLocation = neighborhood;
    recalculateCandyPrices();
  }

  public Candy[] getCandies() {
    return candies;
  }

  private Candy[] generateCandies(){
    Candy[] generatedCandies = new Candy[8];

    candies[0] = new Candy("Skittles", 1, 10);
    candies[1] = new Candy("Toblerone", 11, 20);
    candies[2] = new Candy("Cookies", 21, 40);
    candies[3] = new Candy("Maoam", 41, 80);
    candies[4] = new Candy("Oreos", 81, 160);
    candies[5] = new Candy("Gummy Bears", 161, 320);
    candies[6] = new Candy("Giotto", 321, 640);
    candies[7] = new Candy("Chocolates", 641, 1280);

    return generatedCandies;
  }

  private void recalculateCandyPrices(){
    for(Candy c : candies){
      c.calculateCurrentPrice(currentLocation);
    }
  }

  private int countCandies(){
    int count = 0;
    for(Candy c : candies){
      count += c.getCount();
    }
    return count;
  }
}





























