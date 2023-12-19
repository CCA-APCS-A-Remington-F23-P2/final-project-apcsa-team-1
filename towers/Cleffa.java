package towers;

import java.util.ArrayList;
import Enemies.Enemy;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class Cleffa extends Tower {
  public static final int PRICE = 75;
  public static final int [] UPGRADE_PRICES = {100,200,300};
  public static final int [] RANGES = {20,20,20,20};
  private Image self;

  public Cleffa(int x, int y){
    super(UPGRADE_PRICES, RANGES, x, y);
    try{
      setImage(ImageIO.read(new File("images/Cleffa.png")));
    } catch (Exception e){

    }
  }

  public void upgrade(){
    super.upgrade();
  }
  public void setImage(Image self){
    this.self = self;
  }
  public void draw(Graphics g){
    g.drawImage(self,getX(),getY(),null);
  }
}