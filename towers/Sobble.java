package towers;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Sobble extends HitScanTower{
  public static final int PRICE = 30;
  public static final int [] UPGRADE_PRICES = {150,450,800};
  public static final int [] RANGES = {80,120,160,500};

  public Sobble(int x, int y){
    super(new WaterGun(), UPGRADE_PRICES, RANGES, x, y);
    try{
      setImage(ImageIO.read(new File("images/Sobble.png")));
    } catch (Exception e){

    }
  }
  
  public Sobble(int x, int y, int tier){
	    super(new WaterGun(), UPGRADE_PRICES, RANGES, x, y);
	    try{
	      setImage(ImageIO.read(new File("images/Sobble.png")));
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
        setAttack(new WaterPulse());
        try{
          setImage(ImageIO.read(new File("images/Drizzile.png")));
          } catch (Exception e){
  
          }
      } else if (getTier()==2){
        setAttack(new HydroPump());
        try{
          setImage(ImageIO.read(new File("images/Inteleon.png")));
          } catch (Exception e){
  
          }
      } else if (getTier()==3){
        setAttack(new Hydrosnipe());
  
      }
    }
    return cost;
  }
}