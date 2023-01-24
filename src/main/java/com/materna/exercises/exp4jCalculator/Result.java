package com.materna.exercises.exp4jCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * embodies the result of a calculation. It either works and yields a result or fails due to
 * errors. Both cases are condensed into one object to simplify return values of methods.
 */
public class Result {
  private final double result;
  private final List<String> errors;

  /**
   * constructor for working calculations
   *
   * @param result the result of the calculation
   */
  public Result(double result) {
    this.result = result;
    this.errors = null;
  }

  /**
   * constructor fitted to take the errors of a ValidationResult
   *
   * @param errors the errors that occurred during a validation
   */
  public Result(List<String> errors) {
    this.result = Double.NaN;
    this.errors = errors;
  }

  /**
   * constructor fitted for custom errors
   *
   * @param reqError one error is required since something had to have gone wrong if you call
   *                 this constructor
   * @param errors   optional errors if multiple custom errors need to be created
   */
  public Result(String reqError, String... errors) {
    this.result = Double.NaN;
    this.errors = new ArrayList<>();
    this.errors.add(reqError);
    this.errors.addAll(Arrays.asList(errors));
  }

  /**
   * returns if this is a result of a calculation where an error has occurred
   *
   * @return
   */
  public boolean hasError() {
    return errors != null;
  }

  // getter
  public double getResult() {
    return result;
  }

  public List<String> getErrors() {
    return errors;
  }
}
