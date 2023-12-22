package towers;

public class ShadowBall extends Projectile{
    public ShadowBall(int x, int y, double angle){
        super(4, angle, x, y, 30, 100, 5);
        setSprite("shadowBall");
    }
}
