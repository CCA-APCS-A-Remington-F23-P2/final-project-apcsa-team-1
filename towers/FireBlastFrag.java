package towers;
import Enemies.Enemy;

public class FireBlastFrag extends Projectile{
    public FireBlastFrag(int x, int y, double angle){
        super(20, angle, x, y, 20, 100, 1);
        setBurnDamage(10);
        setBurnDuration(3);
        setSprite("ember");
    }
}
