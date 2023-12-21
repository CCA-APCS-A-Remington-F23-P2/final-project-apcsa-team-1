package towers;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Snivy extends HitScanTower {
  public static final int PRICE = 30;
  public static final int [] UPGRADE_PRICES = {75, 150, 250};
  public static final int [] RANGES = {50, 100, 150, 200};

  public Snivy(int x, int y) {
    super(new VineWhip(), UPGRADE_PRICES, RANGES, x, y);
    try {
      setImage(ImageIO.read(new File("images/Snivy.png")));
    } catch (Exception e) {

    }
  }
  
  public Snivy(int x, int y, int tier) {
	  super(new VineWhip(), UPGRADE_PRICES, RANGES, x, y);
	  try {
	      setImage(ImageIO.read(new File("images/Snivy.png")));
	    } catch (Exception e) {

	    }
	  for(int i = 0; i < tier; i++) {
		  upgrade(Integer.MAX_VALUE);
	  }
  }


  public int getPrice(){
    return PRICE;
  }
  
  public int upgrade(int money) {
    int cost = 0; 
    if (UPGRADE_PRICES[getTier()] <= money) {
      cost = super.upgrade(money);
      if (getTier() == 1) {
        setAttack(new LeafBlade());
        try {
          setImage(ImageIO.read(new File("images/Servine.png")));
        } catch (Exception e) {

        }
      } else if (getTier() == 2) {
        setAttack(new LeafStorm());
        try {
          setImage(ImageIO.read(new File("images/Serperior.png")));
        } catch (Exception e) {

        }
      } else if (getTier() == 3) {
        setAttack(new ContraryLeafStorm());
      }
    }
    return cost;
  }
}
