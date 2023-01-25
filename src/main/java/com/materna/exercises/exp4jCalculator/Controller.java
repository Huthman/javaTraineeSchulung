package com.materna.exercises.exp4jCalculator;

import java.util.Objects;
import java.util.Scanner;

public class Controller {
  private final Model model;
  private final View view;

  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;
  }


  /**
   * The only public method of the controller. Gets accessed by the view to push the user input to
   * the business logic
   *
   * @param term the user input to be handled
   */
  public void evaluateTerm(String term) {
    if (term.contains("=")) {
      bindVariable(term);
    } else {
      model.computeTerm(term);
      view.refresh();
    }
  }

  /**
   * Gets called by evaluateTerm. Checks if the input is a variable assignment and calls the
   * model to save the (variable, value) pair for later use.
   *
   * @param input the potential variable assignment
   */
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
    if (!term[0].trim().matches("[_a-zA-Z]\\w*")) {
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

  /**
   * Accesses the model to get the latest result. Used by the view to update its display.
   *
   * @return the latest Result object of the model.
   */
  public Result getResultFromModel() {
    return model.getLastResult();
  }

}
