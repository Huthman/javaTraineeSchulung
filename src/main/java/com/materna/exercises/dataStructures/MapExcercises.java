package com.materna.exercises.dataStructures;

import java.io.IOException;

public class MapExcercises {

  public static void main(String[] args) throws Exception{
    System.out.println(translate("For the background, let's use #89cff0 or #bcd4e6, and for the text, maybe #fffaf0 or #f8f8ff."));
  }

  public static String translate(String text) throws IOException {
    ColorNames cn = new ColorNames();
    String[] words = text.split(" ");

    for(int i = 0; i<words.length; i++){
      if(words[i].charAt(0) == '#'){
        int rgb =
                Integer.decode(Character.getType(words[i].charAt(words[i].length()-1)) == Character.DECIMAL_DIGIT_NUMBER? words[i] : words[i].substring(0,words[i].length()-1));

        words[i] = cn.decode(rgb).orElse(new Color("#Color not found#",
                rgb)).getName();
      }
    }

    StringBuilder sb = new StringBuilder();
    for(String s : words){
      sb.append(s);
      sb.append(" ");
    }
    return sb.toString();
  }

}
