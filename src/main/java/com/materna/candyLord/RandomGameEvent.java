package com.materna.candyLord;

public class RandomGameEvent {
  private RandomGameEvent(){};

  public static Event next(){
    double rand = Math.random();

    if(rand<0.1){
      return new Mugging();
    } else if (rand <0.2) {
      return new CandyFind();
    } else{
      return new NoEvent();
    }
  }
}
