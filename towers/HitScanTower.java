package towers;

import java.util.ArrayList;
import Enemies.Enemy;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class HitScanTower extends Tower {
  private HitScanAttack attack;
  private Image self;

  public HitScanTower(HitScanAttack attack, int[] upgradePrices, int[] ranges, int xPos,
      int yPos) {
    super(upgradePrices, ranges, xPos, yPos);
    this.setAttack(attack);
  }

  public void cast(ArrayList<Tower> towers, ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles) {
    int targetIndex = -1;
    int furthestProgress = -1;
    int i = 0;
    if (getAttackCounter() <= 0) {
      for (Enemy e : enemies) {
        int distance = (int) Math.sqrt((getX() - e.getX()) ^ 2 + (getY() - e.getY()) ^ 2);
        if (distance <= getRange() && e.getDistTraveled() > furthestProgress) {
          targetIndex = i;
          furthestProgress = e.getDistTraveled();
          setAttackCounter(attack.getAttackDelay());
        }
        i++;
      }
      if (targetIndex != -1) {
        Enemy target = enemies.get(targetIndex);
        attack.cast(target, this, enemies);
      }
    } else {
      setAttackCounter(getAttackCounter() - 1);
    }
  }

  public HitScanAttack getAttack() {
    return attack;
  }

  public void setAttack(HitScanAttack attack) {
    this.attack = attack;
  }

  public void setImage(Image self){
    this.self = self;
  }
  public void draw(Graphics g){
    g.drawImage(this.self, getX(), getY(), null);
  }
}
