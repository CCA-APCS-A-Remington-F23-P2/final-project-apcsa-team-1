package towers;
import Enemies.Enemy;

public class DragonBarrage extends Projectile {
	public DragonBarrage(int x, int y, double angle) {
		super(150, angle, x, y, 100, 250, 15);
	    setSprite("dreepy");
	}
}
