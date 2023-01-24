package com.materna.exercises.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  private static final String DEFAULT_PATH = "src/main/resources/persons.csv";

  public static void main(String[] args) {
    Stream.generate(UUID::randomUUID)
            .map(UUID::toString)
            .limit(500000000)
            .parallel()
            .peek(e -> System.out.println(Thread.currentThread().toString()))
            .forEach(System.out::println);
//    System.out.println(readInPersons(DEFAULT_PATH));
  }

  private static String readInPersons(String filePath) {
    try (Stream<String> stream = Files.lines(Path.of(filePath))) {
      return stream
              .skip(1)
              .map(convertCSVLineToPerson)
              .map(Person::name)
              .collect(Collectors.joining("\n"));
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  private static Function<String, Person> convertCSVLineToPerson =
          (str) -> {
            String[] temp = str.split(",");
            return new Person(temp[0], temp[1], Year.of(Integer.parseInt(temp[2])));
          };
}
