package towers;
import Enemies.Enemy;

public class FireBlastFragX extends Projectile{
    public FireBlastFragX(int x, int y, double angle){
        super(20, angle, x, y, 100, 150, 3);
        setBurnDamage(30);
        setBurnDuration(5);
        setSprite("fireBlastFragX");
    }
}
