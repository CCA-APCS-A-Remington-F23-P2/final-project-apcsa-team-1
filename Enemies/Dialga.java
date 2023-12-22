package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Dialga extends Enemy{

    public Dialga (int xp, int yp){
        super(1500, 7, xp, yp, 200);
      try{
        setImage(ImageIO.read(new File("images/Dialga.png")));
      } catch (Exception e){

      }
    }

}
