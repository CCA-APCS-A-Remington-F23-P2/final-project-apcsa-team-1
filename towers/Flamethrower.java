public class Flamethrower extends projectile{
    public Flamethrower(int x, int y, double angle){
        super(10, angle, x, y, 20, 75, 2);
        setBurnDamage(5);
        setBurnDuration(3);
    }
}
