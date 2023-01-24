package com.materna.exercises.exp4jCalculator;


public class ConsoleLogView implements View {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  Model model;

  @Override
  public void setModel(Model model) {
    this.model = model;
  }

  @Override
  public void refresh() {
    if(model.getLastResult() == null){
      System.out.print(ANSI_GREEN+">"+ANSI_RESET);
      return;
    }
    if (model.getLastResult().hasError()) {
      model.getLastResult().getErrors().forEach(str-> System.out.println(ANSI_RED+str+ANSI_RESET));
    } else {
      double result = model.getLastResult().getResult();
      if(result%1 ==0){
        System.out.println((int)result);
      }else {
        System.out.println(result);
      }
    }
    System.out.print(ANSI_GREEN+">"+ANSI_RESET);
  }
}
