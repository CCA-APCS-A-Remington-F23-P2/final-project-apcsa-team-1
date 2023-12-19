package towers;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;


public class Snivy extends HitScanTower{
  public static final int PRICE = 30;
  public static final int [] UPGRADE_PRICES = {75,150,250};
  public static final int [] RANGES = {40,50,60,70};
    
    public Snivy(int x, int y){
      super(new VineWhip(), UPGRADE_PRICES, RANGES ,x, y);
      try{
      setImage(ImageIO.read(new File("images/Snivy.png")));
      } catch (Exception e){

      }
    }
  
    public void upgrade(){
      super.upgrade();
      if(getTier()==1){
        setAttack(new LeafBlade());
        try{
          setImage(ImageIO.read(new File("images/Servine.png")));
          } catch (Exception e){

          }
      } else if (getTier()==2){
        setAttack(new LeafStorm());
        try{
          setImage(ImageIO.read(new File("images/Serperior.png")));
          } catch (Exception e){

          }
      } else if (getTier()==3){
        setAttack(new ContraryLeafStorm());
      }
    }
}
