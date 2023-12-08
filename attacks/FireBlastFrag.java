public public class FireBlastFrag extends Projectile{
    public FireBlastFrag(int x, int y, double angle){
        super(30, angle, x, y, 40, 50, 1);
        setBurnDamage(10);
        setBurnDuration(3);
    }
}
