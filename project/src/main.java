import nl.saxion.app.SaxionApp;
import objects.Fish;
import objects.Settings;

import java.awt.*;
import java.util.ArrayList;

public class main implements Runnable {

    ArrayList<Fish> fish = new ArrayList<>();
    static int screenWidth =  (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    static int screenHeight =  (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    Settings settings = new Settings();

    public static void main(String[] args) {
        SaxionApp.start(new main(), screenWidth, screenHeight);
    }

    public void run() {
        while(true){
            SaxionApp.drawImage("./resources/background.jpg",0,0,screenWidth,screenHeight);
            settings.Draw();

            AddFish();
            MoveFish();

            settings.Update(SaxionApp.readChar(0.07));
            SaxionApp.clear();

            CleanAquarium();
        }
    }

    private void AddFish() {
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

    private void MoveFish(){
        for (Fish fish : fish) {
            SaxionApp.drawImage(fish.getFileName(), fish.getX(), fish.getY(), fish.getWidth(), fish.getHeight());
            fish.Move();
        }
    }

    private void CleanAquarium() {
        fish.removeIf(
                fish -> fish.getX() < 0 ||
                fish.getX() - fish.getWidth() > screenWidth - fish.getWidth());
    }
}