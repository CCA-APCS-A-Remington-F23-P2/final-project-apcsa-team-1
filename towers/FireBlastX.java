package towers;
import Enemies.Enemy;

public class FireBlastX extends Projectile{
    public FireBlastX(int x, int y, double angle){
        super(10, angle, x, y, 50, 150, 2);
        setBurnDamage(30);
        setBurnDuration(5);
        setSprite("fireBlastX");
    }
}
