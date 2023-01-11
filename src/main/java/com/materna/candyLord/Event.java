package com.materna.candyLord;

public abstract class Event {
  private final String description;
  private final int duration;

  public Event(String description, int duration){
    this.description = description;
    this.duration = duration;
  }

  public abstract void process(Player player);
  public String getDescription(){
    return description;
  }
  public int getDuration(){
    return duration;
  }
}
