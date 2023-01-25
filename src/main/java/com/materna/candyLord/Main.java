package com.materna.candyLord;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Game game = new Game();
//    game.startGame();
    test();
  }

  private static void test() throws IOException {

    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);

    TextGraphics tg = screen.newTextGraphics();
    screen.startScreen();
    tg.putString(10,10,""+ ('c'-3));
    screen.refresh();
    screen.readInput();
    screen.stopScreen();
  }


}