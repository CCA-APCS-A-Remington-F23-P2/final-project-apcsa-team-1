package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Geodude extends Enemy{

    public Geodude(int xp, int yp){
        super(70, 4, xp, yp, 25);
      try{
        setImage(ImageIO.read(new File("images/Geodude.png")));
      } catch (Exception e){

      }
    }

}