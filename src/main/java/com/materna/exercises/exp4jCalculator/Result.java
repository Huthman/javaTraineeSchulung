package com.materna.exercises.exp4jCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
  private final double result;
  private final List<String> errors;

  public Result(double result){
    this.result = result;
    this.errors = null;
  }
  public Result(List<String> errors){
    this.result = Double.NaN;
    this.errors = errors;
  }
  public Result(String reqError, String... errors){
    this.result = Double.NaN;
    this.errors = new ArrayList<>();
    this.errors.add(reqError);
    this.errors.addAll(Arrays.asList(errors));
  }

  public boolean hasError(){
    return errors != null;
  }

  // Getter
  public double getResult(){
    return result;
  }
  public List<String> getErrors() {
    return errors;
  }
}
