package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Solosis extends Enemy{

    public Solosis(int xp, int yp){
        super(10, 7, xp, yp, 2);
      try{
        setImage(ImageIO.read(new File("images/Solosis.png")));
      } catch (Exception e){

      }
    }
  
}