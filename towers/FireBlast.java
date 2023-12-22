package towers;
import Enemies.Enemy;

public class FireBlast extends Projectile{
    public FireBlast(int x, int y, double angle){
        super(10, angle, x, y, 20, 150, 1);
        setBurnDamage(10);
        setBurnDuration(3);
        setSprite("fireBlast");
    }
}
