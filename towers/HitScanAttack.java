public class HitScanAttack extends Attack{
    public HitScanAttack(int delay, int dmg){
        super(delay, dmg);
    }

    public void cast(Enemy target){
        target.takeDamage(getAttackDamage());
    }
}