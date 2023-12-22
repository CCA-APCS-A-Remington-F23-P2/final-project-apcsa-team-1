package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Duosion extends Enemy{
    public Duosion(int xp, int yp){
        super(50, 6, xp, yp, 4);
      try{
        setImage(ImageIO.read(new File("images/Duosion.png")));
      } catch (Exception e){

      }
    }

}