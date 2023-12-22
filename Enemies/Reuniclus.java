package Enemies;

import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Reuniclus extends Enemy{

    public Reuniclus(int xp, int yp){
        super(400, 3, xp, yp, 5);
      try{
        setImage(ImageIO.read(new File("images/Reuniclus.png")));
      } catch (Exception e){

      }
    }

}