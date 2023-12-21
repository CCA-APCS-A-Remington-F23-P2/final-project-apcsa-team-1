package towers;
import Enemies.Enemy;

public class FireBlastFragX extends Projectile{
    public FireBlastFragX(int x, int y, double angle){
        super(30, angle, x, y, 100, 50, 3, 0);
        setBurnDamage(30);
        setBurnDuration(5);
        setSprite("fireBlastFragX");
    }
}
