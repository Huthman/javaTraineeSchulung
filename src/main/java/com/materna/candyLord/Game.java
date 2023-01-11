package com.materna.candyLord;

import java.net.StandardSocketOptions;
import java.util.Scanner;

public class Game {
  private enum MenuType{
    START_GAME,
    OVERVIEW,
    LOAN_SHARK_OVERVIEW,
    LEND_MONEY,
    PAY_BACK_MONEY,
    BANK_OVERVIEW,
    WITHDRAW,
    DEPOSIT,
    BUY_CANDY,
    SELL_CANDY,
    TRAVEL,
    EVENT
  }
  private int currentDay;
  private MenuType currentMenu;

  public Game(){
    currentDay = 0;
    currentMenu = MenuType.START_GAME;
  }

  public void startGame(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("To start the game, press any key.");
    scanner.next();
    while(currentDay < 30){

    }
  }

  private void executeAction(int numberKeyInput){
   switch(currentMenu){

   }
  }

  private void printCurrentMenu(){
    switch(currentMenu){
      case START_GAME -> System.out.printf("Press any Key to start the Game%n");
    }
  }
}
