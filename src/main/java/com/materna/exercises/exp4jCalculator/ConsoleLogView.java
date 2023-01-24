package com.materna.exercises.exp4jCalculator;


import java.util.Scanner;

/**
 * An implementation of a View using the console as user interface
 */
public class ConsoleLogView implements View {
  // ANSI Presets to colorize the console output. Used to differentiate between errors (red) and
  // results (green)
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  final Scanner scanner = new Scanner(System.in);
  Controller controller;

  @Override
  public void setController(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void refresh() {
    if (controller.getResultFromModel() == null) {
      System.out.print(ANSI_GREEN + ">" + ANSI_RESET);
      return;
    }
    if (controller.getResultFromModel().hasError()) {
      controller.getResultFromModel().getErrors().forEach(str -> System.out.println(ANSI_RED + str + ANSI_RESET));
    } else {
      double result = controller.getResultFromModel().getResult();
      if (result % 1 == 0) {
        System.out.println((int) result);
      } else {
        System.out.println(result);
      }
    }
    System.out.print(ANSI_GREEN + ">" + ANSI_RESET);
  }

  public void run() {
    boolean running = true;
    refresh();
    while (running) {
      String input = scanner.nextLine();
      if (!input.matches("(?i)exit")) {
        controller.evaluateTerm(input.replace(',', '.'));
      } else {
        running = false;
      }
    }
  }
}
