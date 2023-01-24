package com.materna.exercises.dataStructures;



public class Color {
  private String name;
  private int rgb;

  public Color(String name, int rgb){
    this.name = name;
    this.rgb = rgb;
  }

  @Override
  public String toString() {
    return "Color{" +
            "name='" + name + '\'' +
            ", rgb=" + rgb +
            '}';
  }

  public String getName() {
    return name;
  }
}
