package towers;
import java.util.List;
import Enemies.Enemy;

public class Waterfall extends HitScanAttack{
    public Waterfall(){
        super(750, 40);
        setSplashRadius(50);
    }
    
    public void cast(Tower t, List enemyList){
        int xPos = t.getXPos();
        int yPos = t.getYPos();
        for(Object en: enemyList){
        	Enemy e = (Enemy) en;
            int eX = e.getXPos();
            int eY = e.getYPos();
            int distance = (int) Math.sqrt((xPos - eX)^2 + (yPos - eY)^2);
            if(distance < getSplashRadius()){
                e.takeDamage(getAttackDamage());
            }
        }
    }
}