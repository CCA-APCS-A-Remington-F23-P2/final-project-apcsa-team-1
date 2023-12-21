package towers;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Magikarp extends HitScanTower{
  public static final int PRICE = 50;
  public static final int [] UPGRADE_PRICES = {75,500,1000};
  public static final int [] RANGES = {50,50,100,250};

  public Magikarp(int x, int y){
    super(new Splash(), UPGRADE_PRICES, RANGES, x, y);
    try{
      setImage(ImageIO.read(new File("images/Magicarp.png")));
    } catch (Exception e){

    }
  }
  
  public Magikarp(int x, int y, int tier){
	    super(new Splash(), UPGRADE_PRICES, RANGES, x, y);
	    try{
	      setImage(ImageIO.read(new File("images/Magicarp.png")));
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
      if(getTier()==1){
        setAttack(new Splash2());
      } else if (getTier()==2){
        setAttack(new Waterfall());
        try{
          setImage(ImageIO.read(new File("images/Gyarados.png")));
          } catch (Exception e){
  
          }
      } else if (getTier()==3){
        setAttack(new MegaWaterfall());
        try{
          setImage(ImageIO.read(new File("images/Megagyarados.png")));
          } catch (Exception e){
  
          }
      }
    }
    return cost;
  }
}