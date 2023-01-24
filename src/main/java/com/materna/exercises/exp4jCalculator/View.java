package com.materna.exercises.exp4jCalculator;

public interface View {
  /**
   * forwards the controller to the view of which the latter gets its information to display
   *
   * @param controller the controller associated with the acting controller
   */
  public void setController(Controller controller);

  /**
   * updates the view to the current model state. Does not work if no controller is linked yet
   */
  public void refresh();

  /**
   * enables the flow of data from the view into the controller
   */
  public void run();
}
