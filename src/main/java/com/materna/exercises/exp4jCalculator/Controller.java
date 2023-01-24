package com.materna.exercises.exp4jCalculator;

import java.util.Objects;
import java.util.Scanner;

public class Controller {
  private final Model model;
  private final View view;
  Scanner scanner = new Scanner(System.in);

  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;
  }

  public void run() {
    boolean running = true;
    view.refresh();
    while (running) {
      String input = scanner.nextLine();
      if (!input.matches("(?i)exit")) {
        evaluateTerm(input.replace(',', '.'));
      } else {
        running = false;
      }
    }
  }

  private void evaluateTerm(String term) {
    if(term.contains("=")){
      bindVariable(term);
    }else{
      model.computeTerm(term);
      view.refresh();
    }
  }

  private void bindVariable(String input) {
    if (input == null || input.length() == 0) {
      throw new IllegalArgumentException("No input given");
    }

    String[] term = Objects.requireNonNull(input).split("=");

    // A variable assignment contains exactly one '=' thus resulting in term having two elements
    if (term.length != 2) {
      model.setLastResult(new Result("Not precisely one '='"));
      view.refresh();
      return;
    }
    // Additionally the identifier has structural requirements
    if(!term[0].matches("\\u0020*[_a-zA-Z][_a-zA-Z0-9]*\\u0020*")){
      model.setLastResult(new Result("Invalid identifier"));
      view.refresh();
      return;
    }

    // try to compute the term part of the assignment
    model.computeTerm(term[1]);
    if (!model.getLastResult().hasError()) {
      model.bindVariable(term[0].trim(), model.getLastResult().getResult());
    }
    view.refresh();
  }

}
