package com.materna.exercises.dataStructures;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

import java.util.HashMap;
import java.util.Map;

public class MorseConversion {
  private static final String MORSE_ALPHABET =
          """
                  A .-      N -.      0 -----
                   B -...    O ---     1 .----
                   C -.-.    P .--.    2 ..---
                   D -..     Q --.-    3 ...--
                   E .       R .-.     4 ....-
                   F ..-.    S ...     5 .....
                   G --.     T -       6 -....
                   H ....    U ..-     7 --...
                   I ..      V ...-    8 ---..
                   J .---    W .--     9 ----.
                   K -.-     X -..-
                   L .-..    Y -.--
                   M --      Z --..""";

  private final ImmutableBiMap<String, String> textToMorse;

  public MorseConversion() {
    Map<String, String> morse = new HashMap<>();
    String[] morseArr = MORSE_ALPHABET.split("\\s+");
    for (int i = 0; i < morseArr.length / 2; i++) {
      morse.put(morseArr[2 * i], morseArr[2 * i + 1]);
    }
    ImmutableBiMap.Builder<String, String> biBuilder = ImmutableBiMap.builder();
    for (String s : morse.keySet()) {
      biBuilder.put(s, morse.get(s));
    }
    textToMorse = biBuilder.build();
  }

  public static void main(String[] args) {
    MorseConversion mc = new MorseConversion();
    System.out.println(mc.convertFromMorseCode(".... .- .-.. .-.. ---  .-- .- ...  --" +
            ". . ...." +
            " -"));
    System.out.println(mc.convertToMorseCode("Hey there"));
  }

  // one space: same Word
  // two spaces: next Word
  private String convertFromMorseCode(String morse) {
    BiMap<String, String> morseToText = textToMorse.inverse();
    StringBuilder text = new StringBuilder();
    for (String s : morse.split("\\s")) {
      text.append(s.isEmpty() ? " " : morseToText.get(s));
    }
    return text.toString();
  }

  private String convertToMorseCode(String text){

    StringBuilder morse = new StringBuilder();
    for (Character c : text.toCharArray()){
      morse.append(c == ' ' ? ' ' : textToMorse.get(""+Character.toUpperCase(c)) + " ");
    }
    return morse.toString();
  }

}
