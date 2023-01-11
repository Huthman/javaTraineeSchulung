package com.materna.candyLord;

public class NoEvent extends Event{

  public NoEvent(){
    super("No Event", 0);
  }

  @Override
  public void process(Player player) {
  }
}
