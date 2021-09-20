package objects;

import nl.saxion.app.SaxionApp;
import java.awt.*;

public class Settings {
    int amountOfFish;
    int randomMaxSpeed;
    int minSpeed;
    int randomMaxSize;
    int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

    public Settings() {
        this.amountOfFish = 12;
        this.randomMaxSpeed = 15;
        this.minSpeed = 10;
        this.randomMaxSize = 100;

        SaxionApp.turnFillOff();
        SaxionApp.setBorderColor(Color.BLACK);
    }

    public int getAmountOfFish() {
        return amountOfFish;
    }

    public double getRandomMaxSpeed() {
        return randomMaxSpeed;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public int getRandomMaxSize() {
        return randomMaxSize;
    }

    public void Update(Character character){
        if(character != null){
            switch (character) {
                case '1' -> amountOfFish += 1;
                case '2' -> amountOfFish -= 1;
                case '3' -> randomMaxSpeed += 5;
                case '4' -> randomMaxSpeed -= 5;
                case '5' -> minSpeed += 5;
                case '6' -> minSpeed -= 5;
                case '7' -> randomMaxSize += 25;
                case '8' -> randomMaxSize -= 25;
            }

        }
    }

    public void Draw(){
        SaxionApp.drawRectangle(0,0, width / 5,height / 12);
        SaxionApp.drawText("Amount of fish = " + amountOfFish + " : 1, 2", width / 80,height / 80,26);
        SaxionApp.drawText("Random max speed = " + randomMaxSpeed + " : 3, 4", width / 80,height / 80 + (height / 60),26);
        SaxionApp.drawText("Min speed = " + minSpeed + " : 5, 6", width / 80,height / 80 + + (height / 60 * 2),26);
        SaxionApp.drawText("Random max size = " + randomMaxSize + " : 7, 8", width / 80,height / 80 + (height / 60 * 3),26);
    }

}
