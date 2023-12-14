package towers;
import Enemies.Enemy;

public class FireBlast extends Projectile{
    public FireBlast(int x, int y, double angle){
        super(40, angle, x, y, 80, 50, 1);
        setBurnDamage(10);
        setBurnDuration(3);
    }
}
