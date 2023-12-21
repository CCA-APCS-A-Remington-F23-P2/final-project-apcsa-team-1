package towers;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;


public class Dreepy extends ProjectileTower{
  public static final int PRICE = 100;
  public static final int [] UPGRADE_PRICES = {125,250,400};
  public static final int [] RANGES = {40,80,100,250};

    public Dreepy(int x, int y){
      super(new Hex(1000, 1000, 0), UPGRADE_PRICES, RANGES ,x, y);
      try{
      setImage(ImageIO.read(new File("images/Dreepy.png")));
      } catch (Exception e){

      }
    }
    
    public Dreepy(int x, int y, int tier){
        super(new Hex(1000, 1000, 0), UPGRADE_PRICES, RANGES ,x, y);
        try{
        setImage(ImageIO.read(new File("images/Dreepy.png")));
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
          setAttack(new ShadowBall(1000, 1000, 0));
          try{
            setImage(ImageIO.read(new File("images/Drakloak.png")));
            } catch (Exception e){
  
            }
        } else if (getTier()==2){
          setAttack(new DragonDarts(1000, 1000, 0));
          try{
            setImage(ImageIO.read(new File("images/Dragapult.png")));
            } catch (Exception e){
  
            }
        } else if (getTier()==3){
          setAttack(new DragonBarrage(1000, 1000, 0));
        }
    }
      return cost;
    }
}
