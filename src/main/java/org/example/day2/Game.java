package org.example.day2;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private int id;
    private List<Reveal> revealed;

    private boolean valid;

    public Game(int id, List<Reveal> revealed) {
        this.id = id;
        this.revealed = revealed;
        this.valid = false;
    }

    public Game(int id) {
        this.id = id;
        this.revealed = new ArrayList<>();
        this.valid = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Reveal> getRevealed() {
        return revealed;
    }

    public void setRevealed(List<Reveal> revealed) {
        this.revealed = revealed;
    }

    public boolean isValid() {
        return valid;
    }



    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", revealed=" + revealed + ", valid=" + valid + '}';
    }

    public void isValid(Integer red, Integer green, Integer blue) {
        this.valid = true;
        int i = 0;
        while (this.valid && i < this.revealed.size()){
            valid = this.revealed.get(i).isValid(red, green, blue);
            i++;
        }
    }

    public int getPower() {
        Optional<Integer> maxBlue = revealed.stream().map(Reveal::getBlue).collect(
                Collectors.toList()).stream().filter(Objects::nonNull).max(Integer::compareTo);
        Optional<Integer> maxGreen =
                revealed.stream().map(Reveal::getGreen).collect(Collectors.toList()).stream().filter(
                        Objects::nonNull).max(Integer::compareTo);
        Optional<Integer> maxRed = revealed.stream().map(Reveal::getRed).collect(Collectors.toList()).stream().filter(
                Objects::nonNull).max(Integer::compareTo);

     return (maxBlue.orElse(1))*
             (maxGreen.orElse(1))*
             (maxRed.orElse(1));
    }

}
