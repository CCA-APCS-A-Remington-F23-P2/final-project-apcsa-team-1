package towers;
import Enemies.Enemy;

public class FireBlastX extends Projectile{
    public FireBlastX(int x, int y, double angle){
        super(60, angle, x, y, 100, 100, 1, 2);
        setBurnDamage(30);
        setBurnDuration(5);
        setSprite("fireBlastX");
    }
}
