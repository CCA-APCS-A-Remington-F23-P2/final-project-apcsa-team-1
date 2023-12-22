package towers;

import java.util.ArrayList;
import Enemies.Enemy;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Cleffa extends Tower {
  public static final int PRICE = 50;
  public static final int [] UPGRADE_PRICES = {100,150,200};
  public static final int [] RANGES = {2000,2000,2000,2000};
  private int moneyAmount;
  private String coinSprite;
  public static int cleffaCounter = 0;

  public Cleffa(int x, int y){
    super(UPGRADE_PRICES, RANGES, x, y);
    moneyAmount = 1;
    coinSprite = "coin1";
    try{
      setImage(ImageIO.read(new File("images/Cleffa.png")));
    } catch (Exception e){

    }
  }
  
  public Cleffa(int x, int y, int tier){
	    super(UPGRADE_PRICES, RANGES, x, y);
	    try{
	      setImage(ImageIO.read(new File("images/Cleffa.png")));
	    } catch (Exception e){

	    }
	    for(int i = 0; i < tier; i++) {
			  upgrade(Integer.MAX_VALUE);
		  }
	  }
  public int getPrice(){
    return PRICE;
  }
  
  public int upgrade(int money){
    int cost = 0;
    if(UPGRADE_PRICES[getTier()] <= money){
      cost = super.upgrade(money);
      if (getTier() == 1) {
        moneyAmount = 2;
        coinSprite = "coin2";
        }
      } else if (getTier() == 2) {
        moneyAmount = 3;
        coinSprite = "coin3";

      } else if (getTier() == 3) {
        moneyAmount = 4;
        coinSprite = "coin4";
      }
    return cost;
  }

  public int getMoneyAmount(){
    return this.moneyAmount;
  }

  public void displayCoin(Graphics g){
	  try {
    g.drawImage(ImageIO.read(new File("images/" + coinSprite + ".png")), getX() + 15, getY() - 50, null);
	  } catch (IOException e) {
		  System.out.println("There is no coin!!!");
	  }
  }
}