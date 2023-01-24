package com.materna.candyLord;

public class Mugging extends Event{
  public Mugging(){
    super("Mugging",0);
  }

  @Override
  public void process(Player player) {
    for(Candy c : player.getCandies()){
      c.reduceCountBy(c.getCount());
    }
  }
}
