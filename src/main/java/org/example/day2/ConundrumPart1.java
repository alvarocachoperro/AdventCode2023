package org.example.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConundrumPart1 {
    private static List<Game> mapGame(Path path) {
        List<Game> games = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(path);
            for (String linea : lineas) {
//                System.out.println(linea);
                Game juego = new Game(Integer.parseInt(linea.substring(linea.indexOf(' ')+1, linea.indexOf(':'))));
                String[] juegos = linea.substring(linea.indexOf(':') + 1, linea.length()).split(";");
                List<Reveal> subgames = new ArrayList<>();
                for (int i=0; i< juegos.length; i++){
                    String[] subjuegos = juegos[i].split(",");
                    Reveal reveal = new Reveal();
                    for ( int j=0; j < subjuegos.length; j++){
                        if (subjuegos[j].contains("blue")){
                            reveal.setBlue(Integer.valueOf(subjuegos[j].substring(1,linea.indexOf(' ')-1).trim()));
                        }
                        if (subjuegos[j].contains("green")){
                            reveal.setGreen(Integer.valueOf(subjuegos[j].substring(1,linea.indexOf(' ')-1).trim()));
                        }
                        if (subjuegos[j].contains("red")){
                            reveal.setRed(Integer.valueOf(subjuegos[j].substring(1,linea.indexOf(' ')-1).trim()));
                        }
                    }
                    subgames.add(reveal);
                }
                juego.setRevealed(subgames);
                games.add(juego);
            }
        } catch (IOException e) {
            System.out.printf(e.toString());
        }
        return games;
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/java/org/example/day2/ConundrumInput.txt");
        long sum=0;

        List<Game> games = mapGame(path);
        games.forEach(game -> game.isValid(Integer.valueOf(args[0]), Integer.valueOf(args[1]),
                Integer.valueOf(args[2])));
        System.out.println(games.stream().filter(Game::isValid).mapToInt(Game::getId).sum());
    }

}

