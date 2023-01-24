package com.materna.exercises.threadsExecutors;


import java.time.LocalTime;

import java.util.concurrent.CompletableFuture;

import java.util.concurrent.TimeUnit;

import java.util.logging.Logger;


class Pirate {


  public static void main(String[] arg) throws Throwable {


    String result = CompletableFuture.supplyAsync(Pirate::newName)

            .thenApply(Pirate::swears)

            .thenCombine(drinkRum(), Pirate::combinePiratAndDrinks)

            .thenCombine(drinkRum(), Pirate::combinePiratAndDrinks)

            .get();

    System.out.println(result); // Pirat Guybrush flucht und trinkt dann 10 Flaschen Rum und
    // trinkt dann 11 Flaschen Rum

  }


  static String newName() {

    Logger.getGlobal().info("" + Thread.currentThread());

    return "Pirat Guybrush";

  }


  static String swears(String pirate) {

    Logger.getGlobal().info("" + Thread.currentThread());

    return pirate + " flucht";

  }


  static CompletableFuture<Integer> drinkRum() {

    Logger.getGlobal().info("" + Thread.currentThread());

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (Exception e) {
    }

    return CompletableFuture.supplyAsync(() -> LocalTime.now().getSecond());

  }


  static String combinePiratAndDrinks(String pirat, int bottlesOfRum) {

    Logger.getGlobal().info("" + Thread.currentThread());

    return pirat + " und trinkt dann " + bottlesOfRum + " Flaschen Rum";

  }

}
