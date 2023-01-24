package com.materna.exercises.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class countLinesOfText {
  private static final String DEFAULT_PATH = "src/main/resources/lines";
  public static void main(String[] args) throws Exception {
//    System.out.println(countLines(DEFAULT_PATH));
//    System.out.println(anyLineContainsDigit(DEFAULT_PATH));
//    System.out.println(joinLinesWith(DEFAULT_PATH, ","));
    System.out.println(sortLinesByLength(DEFAULT_PATH));

  }


  public static long countLines(String filePath)throws IOException {
    try(Stream<String> lines = Files.lines(Paths.get(filePath))){
      return lines.count();
    }catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public static boolean anyLineContainsDigit(String filePath){
    try(Stream<String> lines = Files.lines(Paths.get(filePath))){
      return lines.anyMatch((str)->{
        for(char c: str.toCharArray()){
          if(Character.isDigit(c)){
            return true;
          }
        }
        return false;
      });
    }catch (IOException e){
      e.printStackTrace();
    }

    return false;
  }

  public static String joinLinesWith(String filePath, String delimiter){
    try(Stream<String> lines = Files.lines(Paths.get(filePath))){
      return lines.collect(Collectors.joining(delimiter));
    }catch (IOException e){
      e.printStackTrace();
    }
    return "";
  }

  public static String sortLinesByLength(String filePath){
    try(Stream<String> lines = Files.lines(Paths.get(filePath))){
      return lines.sorted((o1, o2) -> o1.length()-o2.length()).collect(Collectors.joining(","));
    }catch(IOException e){
      e.printStackTrace();
    }
    return "";
  }
}
