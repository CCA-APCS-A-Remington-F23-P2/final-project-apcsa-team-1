package towers;
import java.util.List;

import Enemies.Enemy;

public class HitScanAttack extends Attack{
    public HitScanAttack(int delay, int dmg){
        super(delay, dmg);
    }

    public void cast(Enemy target, Tower tower, List<Enemy> enemies){
        target.takeDamage(getAttackDamage());
    }
}