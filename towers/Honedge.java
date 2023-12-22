package towers;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Honedge extends MeleeTower{
  public static final int PRICE = 75;
  public static final int [] UPGRADE_PRICES = {125,250,500};
  public static final int [] RANGES = {50,50,50,75};

  public Honedge(int x, int y){
    super(new Slash(), UPGRADE_PRICES, RANGES, x, y);
    try{
      setImage(ImageIO.read(new File("images/Honedge.png")));
    } catch (Exception e){

    }
  }
  
  public Honedge(int x, int y, int tier){
	    super(new Slash(), UPGRADE_PRICES, RANGES, x, y);
	    try{
	      setImage(ImageIO.read(new File("images/Honedge.png")));
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
        setAttack(new NightSlash());
        try{
          setImage(ImageIO.read(new File("images/Doublade.png")));
          } catch (Exception e){
  
          }
      } else if (getTier()==2){
        setAttack(new SacredSword());
        try{
          setImage(ImageIO.read(new File("images/Aegislash.png")));
          } catch (Exception e){
  
          }
      } else if (getTier()==3){
        setAttack(new SacredSword());
      }
    }
    return cost;
  }
}