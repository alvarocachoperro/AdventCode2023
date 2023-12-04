package org.example.ex2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise2 {
    public static void main(String[] args) throws FileNotFoundException {
        Path path = Paths.get("src/main/java/org/example/ex2/Input.txt");

        try {
            List<String> lineas = Files.readAllLines(path);
            Integer suma = 0;
            String expresion = "(^[0-9]|one|two|three|four|five|six|seven|eight|nine|[0-9]$)";

            List<List<Object>> resultados = new ArrayList<>();

            for (String linea : lineas) {
                List<Object> resultado = new ArrayList<>();
                List<String> coincidencias = new ArrayList<>();
                int ocurrencias = 0;
                Pattern p = Pattern.compile(expresion);
                Matcher m = p.matcher( linea );
                while (m.find()) {
                    ocurrencias++;
                    coincidencias.add(m.group());
                }
                resultado.add(linea);
                resultado.add(ocurrencias);
                resultado.addAll(coincidencias);
                resultados.add(resultado);
            }
            for (List<Object> resultado: resultados) {
                if ((int)resultado.get(1)>0) {
                    if ((int)resultado.get(1)==1) {
                        System.out.println( "linea:"+resultado.get(0)+", ocurrencias:" +resultado.get(1)+", resultado:"+Integer.valueOf(convertirNumero((String)resultado.get(2))));
                        suma += Integer.valueOf(convertirNumero((String)resultado.get(2)));
                    } else {
                        System.out.println( "linea:"+resultado.get(0)+", ocurrencias:" +resultado.get(1)+", resultado:"+Integer.valueOf(convertirNumero((String)resultado.get(2))+convertirNumero((String)resultado.get(((int)resultado.get(1))+1))));
                        suma += Integer.valueOf(convertirNumero((String)resultado.get(2))+convertirNumero((String)resultado.get(((int)resultado.get(1))+1)));
                    }
                }
            }


            System.out.println( "suma:"+suma );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String convertirNumero(String number) {
        String numero = null;
        if (number.matches("-?\\d+(\\.\\d+)?")) {
            numero = number;
        } else {
            if (number.compareTo("one")==0){
                numero = "1";
            } else if (number.compareTo("two")==0){
                numero = "2";
            } else if (number.compareTo("three")==0){
                numero = "3";
            } else if (number.compareTo("four")==0){
                numero = "4";
            } else if (number.compareTo("five")==0){
                numero = "5";
            } else if (number.compareTo("six")==0){
                numero = "6";
            } else if (number.compareTo("seven")==0){
                numero = "7";
            } else if (number.compareTo("eight")==0){
                numero = "8";
            } else if (number.compareTo("nine")==0){
                numero = "9";
            }
        }
        return numero;
    }
}
