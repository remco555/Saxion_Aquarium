package objects;

public class Fish {
    String fileName;
    int screenWidth, screenHeight, width, height, x, y;
    float vel;

    public Fish(String fileName, int screenWidth, int screenHeight, int width, int height, float vel) {
        this.fileName = fileName;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.width = width;
        this.height = height;
        this.vel = vel;

        //set X to either left or right side of screen
        if (Math.random() < 0.5){
            this.x = 0;
        } else {
            this.x = screenWidth;
            this.vel *= -1;
            //Flip image if it starts on the right side of the screen
            this.width *= -1;
        }
        //Set random Y
        this.y = (int) (Math.random() * (screenHeight));
    }

    public String getFileName() {
        return fileName;
    }

    public int getWidth() {
        return width;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getHeight() {
        return height;
    }

    public void Move(){
        x += vel;
    }
}
