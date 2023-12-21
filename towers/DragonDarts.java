package towers;
import Enemies.Enemy;

public class DragonDarts extends Projectile{
    public DragonDarts(int x, int y, double angle){
        super(100, angle, x, y, 85, 200, 10, 3);
        setSprite("dreepy");
    }
}
