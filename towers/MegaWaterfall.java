package towers;
import Enemies.Enemy;
import java.util.List;

public class MegaWaterfall extends HitScanAttack{
    public MegaWaterfall(){
        super(500, 80);
        setStunDuration(300);
    }
    public void cast(Tower t, List enemyList){
        int xPos = t.getXPos();
        int yPos = t.getYPos();
        for(Object badGuy: enemyList){
            Enemy e = (Enemy) badGuy;
        	int eX = e.getXPos();
            int eY = e.getYPos();
            int distance = (int) Math.sqrt((xPos - eX)^2 + (yPos - eY)^2);
            if(distance < getSplashRadius()){
                e.takeDamage(getAttackDamage());
                e.setStunCounter(getStunDuration());
            }
        }
    }
}
