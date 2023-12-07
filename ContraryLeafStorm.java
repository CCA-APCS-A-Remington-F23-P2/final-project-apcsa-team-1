public class ContraryLeafStorm extends HitScanAttack{
    public ContraryLeafStorm(){
        super(10, 0.25);
    }
    @Override
    public void cast(Enemy target){
        target.takeDamage(getAttackDamage());
        if(getAttackDelay() >= 0.0625){
            setAttackDelay(getAttackDelay() * 0.9);
        }
    }
}