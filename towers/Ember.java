package towers;
import Enemies.Enemy;

public class Ember extends Projectile{
    public Ember(int x, int y, double angle){
        super(20, angle, x, y, 20, 60, 1);
        setBurnDamage(5);
        setBurnDuration(2);
      setSprite("ember");
    }   
}