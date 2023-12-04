package org.example.ex1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {
    public static void main(String[] args) throws FileNotFoundException {
        Path path = Paths.get("src/main/java/org/example/ex1/Input.txt");

        try {
            List<String> lineas = Files.readAllLines(path);
            Integer suma = 0;
            for (String linea : lineas) {
                System.out.println( "linea:"+linea );
                String numbers = linea.replaceAll("[^0-9]", "");
                System.out.println( "numbers:"+numbers );
                String number = "";
                    number = new StringBuilder().append("").append(numbers.charAt(0)).append(numbers.charAt(numbers.length()-1)).toString();
                System.out.println( "number:"+number );
                suma += Integer.valueOf(number);
            }
            System.out.println( "suma:"+suma );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
