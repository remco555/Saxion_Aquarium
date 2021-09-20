import nl.saxion.app.SaxionApp;
import objects.Fish;
import objects.Settings;

import java.awt.*;
import java.util.ArrayList;

public class main implements Runnable {


    ArrayList<Fish> fish = new ArrayList<>();
    int screenWidth =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int screenHeight =  (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    Settings settings = new Settings();


    public static void main(String[] args) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        SaxionApp.start(new main(), (int) size.getWidth(), (int) size.getHeight());
    }



    public void run() {
        while(true){
            SaxionApp.drawImage("./resources/background.jpg",0,0,screenWidth,screenHeight);
            settings.Draw();
            addFish();
            for (Fish fish : fish) {
                SaxionApp.drawImage(fish.getFileName(), fish.getX(), fish.getY(), fish.getWidth(), fish.getHeight());
                fish.Move();
            }
            settings.Update(SaxionApp.readChar(0.07));
            SaxionApp.clear();
            cleanAquarium();
        }
    }

    private void addFish() {
        while (fish.size() < settings.getAmountOfFish()) {
            fish.add(new Fish(
                    "./resources/fish_" + (int) (Math.random() * (10) + 1) + ".png",
                    screenWidth,
                    screenHeight,
                    (int) (Math.random() * (settings.getRandomMaxSize()) + 100),
                    (int) (Math.random() * (settings.getRandomMaxSize()) + 100),
                    (int) (Math.random() * (settings.getRandomMaxSpeed()) + settings.getMinSpeed())));
        }
    }

    private void cleanAquarium() {
        fish.removeIf(fish -> fish.getX() < 0 ||
                fish.getX() - fish.getWidth() > Toolkit.getDefaultToolkit().getScreenSize().getWidth() - fish.getWidth());
    }
}