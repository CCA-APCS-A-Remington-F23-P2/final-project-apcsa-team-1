package towers;
import Enemies.Enemy;
import java.util.ArrayList;

public class ContraryLeafStorm extends HitScanAttack{
  
  public ContraryLeafStorm(){
      super(250, 10);
      setSprite("contraryLeafStorm");
  }
	public void cast(Enemy target, Tower t, ArrayList<Enemy> enemies){
	    target.takeDamage(getAttackDamage());
	    if(getAttackDelay() >= 50){
	        setAttackDelay((int) (getAttackDelay() * 0.9));
	    }
	}
}