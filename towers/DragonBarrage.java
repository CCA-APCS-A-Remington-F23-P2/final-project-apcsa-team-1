package towers;
import Enemies.Enemy;

public class DragonBarrage extends Projectile {
	public DragonBarrage(int x, int y, double angle) {
		super(30, angle, x, y, 50, 250, 5);
	    setSprite("dreepy");
	}
}
