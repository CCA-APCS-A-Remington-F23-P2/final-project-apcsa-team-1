package towers;
import java.util.List;
import Enemies.Enemy;

public class MeleeAttack extends Attack{
    public int radius;
    public int sectorAngle;
    public MeleeAttack(int delay, int damage, int radius, int sectorAngle){
        super(delay, damage);
        this.radius = radius;
        this.sectorAngle = sectorAngle;
    }
    public int getRadius(){
        return this.radius;
    }
    public int getSectorAngle(){
        return this.sectorAngle;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public void setSectorAngle(int sectorAngle){
        this.sectorAngle = sectorAngle;
    }
    public void cast(Enemy target, Tower tower, List<Enemy> enemies){
        int castAngle = (int) Math.atan(((double) (tower.getY() - target.getYPos())) / ((double) (tower.getX() - target.getXPos())));
        for(Object en: enemies){
        	Enemy e = (Enemy) en;
            int angle = (int) Math.atan(((double) (tower.getY() - e.getYPos())) / ((double) (tower.getX() - e.getXPos())));
            if(Math.abs(angle - castAngle) <= getSectorAngle() / 2){
                e.takeDamage(getAttackDamage());
            }
        }
    }
}