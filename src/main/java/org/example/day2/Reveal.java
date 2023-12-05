package org.example.day2;

import java.util.Optional;

public class Reveal {
    private Integer red;
    private Integer blue;
    private Integer green;


    public Reveal(Integer red, Integer blue, Integer green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public Reveal() {
        this.red = null;
        this.blue = null;
        this.green = null;
    }

    public Integer getGreen() {
        return green;
    }

    public Optional<Integer> getOptionalGreen() {
        return Optional.of(green);
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public Integer getBlue() {
        return blue;
    }

    public Optional<Integer> getOptionalBlue() {
        return Optional.of(blue);
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public Integer getRed() {
        return red;
    }

    public Optional<Integer> getOptionalRed() {
        return Optional.of(red);
    }

    public void setRed(int red) {
        this.red = red;
    }


    @Override
    public String toString() {
        return "Reveal{" + "red=" + red + ", blue=" + blue + ", green=" + green + '}';
    }

    public boolean isValid(Integer red, Integer green, Integer blue) {
        Boolean  vRed, vGreen, vBlue = null;
        vBlue = (this.blue == null || this.blue <= blue);
        vGreen = (this.green == null || this.green <= green);
        vRed = (this.red == null || this.red <= red);
        return (vBlue && vGreen && vRed);
    }


}
