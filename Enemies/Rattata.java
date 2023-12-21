package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.File;

public class Rattata extends Enemy{

    public Rattata(int xp, int yp){
           super(30, 5, xp, yp, 3);
      try{
        setImage(ImageIO.read(new File("images/Ratata.png")));
        } catch (Exception e){
        	System.out.println("error fail");
        }
    }
  

}