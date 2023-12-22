package towers;
import Enemies.Enemy;

public class DragonDarts extends Projectile{
    public DragonDarts(int x, int y, double angle){
        super(30, angle, x, y, 15, 200, 3);
        setSprite("dreepy");
    }
}
