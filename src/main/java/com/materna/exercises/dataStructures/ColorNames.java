package com.materna.exercises.dataStructures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ColorNames {
  private static final String DEFAULT_FILEPATH = "C:\\Users\\cegidy\\IdeaProjects" +
          "\\javaTraineeSchulung\\src" +
          "\\main\\resources\\colors.csv";

  private HashMap<Integer, Color> colorMap = new HashMap<>();

  ColorNames(String filepath)throws IOException {
    List<String> colorCSV = Files.readAllLines(Paths.get(filepath));
    for (String s : colorCSV) {
      String[] temp = s.split(",");
      Integer rgb = Integer.decode(temp[2]);
      colorMap.put(rgb, new Color(temp[1], rgb));
    }
  }

  public ColorNames()throws IOException{
    this(DEFAULT_FILEPATH);
  }


  public Optional<Color> decode(int rgb){
    return Optional.of(colorMap.get(rgb));
  }

}
