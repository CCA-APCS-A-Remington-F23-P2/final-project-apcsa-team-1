package towers;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Sobble extends HitScanTower{
  public static final int PRICE = 30;
  public static final int [] UPGRADE_PRICES = {75,150,250};
  public static final int [] RANGES = {50,100,150,500};

  public Sobble(int x, int y){
    super(new WaterGun(), UPGRADE_PRICES, RANGES, x, y);
    try{
      setImage(ImageIO.read(new File("images/Sobble.png")));
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