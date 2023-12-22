package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Blaziken extends Enemy{

    private int speedBoostCounter;
    private double speedBoostLevel;

    public Blaziken(int xp, int yp){
        super(200, 3, xp, yp, 50);
        speedBoostCounter = 300;
        speedBoostLevel = 1;
      try{
        setImage(ImageIO.read(new File("images/Blaziken.png")));
      } catch (Exception e){

      }
    }

    @Override
    public void move(){
        super.move();
        if(speedBoostCounter > 0) speedBoostCounter --;
        else{
            speedBoostCounter = 300;
            if(speedBoostLevel < 4){
                speedBoostLevel += 0.5;
                setSpeed((int) (speedBoostLevel * getSpeed()));
            }
        }
    }

    public int getSpeedBoostCounter(){
        return speedBoostCounter;
    }
    public void setSpeedBoostCounter(int s){
        speedBoostCounter = s;
    }
    public double getSpeedBoostLevel(){
        return speedBoostLevel;
    }
    public void setSpeedBoostLevel(int s){
        speedBoostLevel = s;
    }

}