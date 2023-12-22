package towers;
import Enemies.Enemy;

public class Hex extends Projectile{
    public Hex(int x, int y, double angle){
        super(5, angle, x, y, 20, 50, 3);
        setSprite("hex");
    }
}
