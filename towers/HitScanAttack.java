package towers;
import java.util.List;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

import Enemies.Enemy;

public class HitScanAttack extends Attack{
    private Image sprite;
  
    public HitScanAttack(int delay, int dmg){
        super(delay, dmg);
    }

    public void cast(Enemy target, Tower tower, List<Enemy> enemies){
        target.takeDamage(getAttackDamage());
    }

    public Image getSprite(){
      return sprite;
    }
}