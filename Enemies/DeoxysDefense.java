package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class DeoxysDefense extends Boss{

  
    public DeoxysDefense (int xp, int yp){
        super(500, 3, xp, yp, 200);
      try{
        setImage(ImageIO.read(new File("images/DeoxysDefense.png")));
      } catch (Exception e){

      }
    }

}