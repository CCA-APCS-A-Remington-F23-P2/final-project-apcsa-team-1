public class ContraryLeafStorm extends HitScanAttack{
    public ContraryLeafStorm(){
        super(250, 10);
    }
    @Override
    public void cast(Enemy target){
        target.takeDamage(getAttackDamage());
        if(getAttackDelay() >= 50){
            setAttackDelay((int) (getAttackDelay() * 0.9));
        }
    }
}