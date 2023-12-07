public class HitScanAttack extends Attack{
    public HitScanAttack(double delay, int dmg){
        super(delay, dmg);
    }

    public void cast(Enemy target){
        target.takeDamage(getAttackDamage());
    }
}