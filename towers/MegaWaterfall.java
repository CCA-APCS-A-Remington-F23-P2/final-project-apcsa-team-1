package towers;
import Enemies.Enemy;

import java.util.ArrayList;

public class MegaWaterfall extends HitScanAttack{
    public MegaWaterfall(){
        super(500, 80);
        setStunDuration(300);
        setSprite("megaWaterfall");
    }
    public void cast(Enemy target, Tower t, ArrayList<Enemy> enemyList){
        int xPos = t.getX();
        int yPos = t.getY();
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
