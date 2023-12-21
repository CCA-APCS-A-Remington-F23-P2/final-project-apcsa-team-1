package towers;
import Enemies.Enemy;

public class Hex extends Projectile{
    public Hex(int x, int y, double angle){
        super(5, angle, x, y, 30, 50, 3, 4);
        setSprite("hex");
    }
}
