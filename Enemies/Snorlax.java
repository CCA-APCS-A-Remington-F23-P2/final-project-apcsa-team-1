package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Snorlax extends Enemy{

    public Snorlax(int xp, int yp){
        super(300, 2, xp, yp, 50);
      try{
        setImage(ImageIO.read(new File("images/Snorlax.png")));
      } catch (Exception e){

      }
    }

}