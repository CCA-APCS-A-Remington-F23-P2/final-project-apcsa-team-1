package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Dialga extends Boss{

    public Dialga (int xp, int yp){
        super(250, 6, xp, yp, 200);
      try{
        setImage(ImageIO.read(new File("images/Dialga.png")));
      } catch (Exception e){

      }
    }

}
