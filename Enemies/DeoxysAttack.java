package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class DeoxysAttack extends Enemy{

    public DeoxysAttack (int xp, int yp){
        super(1000, 5, xp, yp, 200);
      try{
        setImage(ImageIO.read(new File("images/DeoxysAttack.png")));
      } catch (Exception e){

      }
    }

}