package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Gengar extends Enemy{

    private int intangibilityCounter; 

    public Gengar(int xp, int yp){
           super(25, 6, xp, yp, 30);
           intangibilityCounter = 0;
      try{
        setImage(ImageIO.read(new File("images/Gengar.png")));
      } catch (Exception e){

      }
    }

    @Override
    public void takeDamage(int d){
        super.takeDamage(d);
        intangibilityCounter = 10;
    }

}