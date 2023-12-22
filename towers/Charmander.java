package towers;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Charmander extends ProjectileTower{
  public static final int PRICE = 30;
  public static final int [] UPGRADE_PRICES = {75,150,250};
  public static final int [] RANGES = {70,80,90,110};
  public static final int [] ATTACK_DELAYS = {6, 2, 7, 6};
  
  public Charmander(int x, int y){
    super(new Ember(1000, 1000, 0.0), UPGRADE_PRICES, RANGES ,x, y);
    setAttackDelay(ATTACK_DELAYS[0]);
    try{
    setImage(ImageIO.read(new File("images/Charmander.png")));
    } catch (Exception e){
      
    }
  }
  
  public Charmander(int x, int y, int tier){
	    super(new Ember(1000, 1000, 0.0), UPGRADE_PRICES, RANGES ,x, y);
	    try{
	    setImage(ImageIO.read(new File("images/Charmander.png")));
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
      setProjectile(new Flamethrower(1000, 1000, 0.0));
      try{
        setImage(ImageIO.read(new File("images/Charmeleon.png")));
        } catch (Exception e){

        }
    } else if (getTier()==2){
      setProjectile(new FireBlast(1000, 1000, 0.0));
      try{
        setImage(ImageIO.read(new File("images/Charizard.png")));
        } catch (Exception e){

        }
    } else if (getTier()==3){
      setProjectile(new FireBlastX(1000, 1000, 0.0));
      try{
        setImage(ImageIO.read(new File("images/Megacharizardx.png")));
        } catch (Exception e){

        }
    }
      setAttackDelay(ATTACK_DELAYS[getTier()]);
    }
    return cost;
  }
}