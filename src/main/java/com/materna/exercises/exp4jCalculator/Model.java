package com.materna.exercises.exp4jCalculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;

import java.util.HashMap;

public class Model {
  private HashMap<String, Double> variables = new HashMap<>();
  private Result lastResult = null;

  public void bindVariable(String name, double value) {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("Variable name may not be empty or null");
    }
    variables.put(name, value);
  }

  public void computeTerm(String term) {
    if (term == null || term.length() == 0) {
      // Set result to error result
      lastResult = new Result("No term given.");
    } else {
      try {
        Expression e = new ExpressionBuilder(term)
                .variables(variables.keySet())
                .build()
                .setVariables(variables);
        if (e.validate().isValid()) {
          lastResult = new Result(e.evaluate());
        } else {
          lastResult = new Result(e.validate().getErrors());
        }
      } catch (Exception e) {
        lastResult = new Result(e.getMessage());
      }
    }
  }

  public HashMap<String, Double> getVariables() {
    return variables;
  }

  public Result getLastResult() {
    return lastResult;
  }

  public void setLastResult(Result lastResult) {
    this.lastResult = lastResult;
  }
}
