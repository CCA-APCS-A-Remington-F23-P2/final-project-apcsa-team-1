public class FireBlastX extends Projectile{
    public FireBlastX(int x, int y, double angle){
        super(60, angle, x, y, 100, 100, 1);
        setBurnDamage(30);
        setBurnDuration(5);
    }
}
