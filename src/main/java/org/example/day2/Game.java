package org.example.day2;

import java.util.ArrayList;
import java.util.List;

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
}
