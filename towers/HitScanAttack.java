package towers;
import java.util.List;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

import Enemies.Enemy;

public class HitScanAttack extends Attack{
    private String sprite;
  
    public HitScanAttack(int delay, int dmg){
        super(delay, dmg);
    }

    public void cast(Enemy target, Tower tower, List<Enemy> enemies){
        target.takeDamage(getAttackDamage());
    }

    public String getSprite(){
      return sprite;
    }

    public void setSprite(String sprite){
      this.sprite = sprite;
    }

    public Image getDirectionalSprite(String angle){
      try{
        return ImageIO.read(new File("images/hitscan_sprites/" + getSprite() + "/" + getSprite() + angle + ".png"));
      }
      catch(IOException e){
        return null;
      }
    }
}