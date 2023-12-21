package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Pigeot extends Enemy{

    public Pigeot(int xp, int yp){
           super(35, 10, xp, yp, 20);
      try{
        setImage(ImageIO.read(new File("images/Pigeot.png")));
      } catch (Exception e){

      }
    }

}