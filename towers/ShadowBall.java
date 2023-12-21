package towers;

public class ShadowBall extends Projectile{
    public ShadowBall(int x, int y, double angle){
        super(30, angle, x, y, 50, 100, 5);
        setSprite("shadowBall");
    }
}
