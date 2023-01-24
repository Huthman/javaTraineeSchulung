package com.materna.exercises.exp4jCalculator;

public class Main {
  public static void main(String[] args) {
    View v = new ConsoleLogView();
    Model m = new Model();
    Controller c = new Controller(m,v);
    v.setModel(m);
    c.run();
  }
}
