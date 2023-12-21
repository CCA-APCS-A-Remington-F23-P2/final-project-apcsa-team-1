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

  public Cleffa(int x, int y){
    super(UPGRADE_PRICES, RANGES, x, y);
    try{
      setImage(ImageIO.read(new File("images/Cleffa.png")));
    } catch (Exception e){

    }
  }
  public int getPrice(){
    return PRICE;
  }

  public int upgrade(int money){
    int cost = 0;
    if(UPGRADE_PRICES[getTier()] <= money){
      cost = super.upgrade(money);
    }
    return cost;
  }
}