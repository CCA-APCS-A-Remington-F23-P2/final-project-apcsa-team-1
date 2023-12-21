package towers;

import java.util.ArrayList;
import Enemies.Enemy;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class ProjectileTower extends Tower {
	private Projectile attack;

	public ProjectileTower(Projectile attack, int[] upgradePrices, int[] ranges, int xPos, int yPos) {
		super(upgradePrices, ranges, xPos, yPos);
		this.setAttack(attack);
	}

  
	public void cast(ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles) {
		int targetIndex = -1;
		int furthestProgress = -1;
		int i = 0;
		if (getAttackCounter() <= 0) {
			for (Enemy e : enemies) {
				int sqDistance = (int) Math.pow((getX() - e.getX()),2) + (int) Math.pow((getY() - e.getY()), 2);
        int sqRange = (int) Math.pow(getRange(),2);
				if (sqDistance <= sqRange && e.getDistTraveled() > furthestProgress) {
					targetIndex = i;
					furthestProgress = e.getDistTraveled();
				}
				i++;
			}
			if (targetIndex != -1) {
        setAttackCounter(attack.getAttackDelay());
				Enemy target = enemies.get(targetIndex);
				double angle = Math.atan2(getY() - target.getY(), getX() - target.getX());
				if(angle < 0) {
					angle += 360.0;
				}
				projectiles.add(new Projectile((int) Math.hypot(attack.getXSpeed(), attack.getYSpeed()), angle, getX(), getY(), attack));
			}
		} else {
			setAttackCounter(getAttackCounter() - 1);
		}
	}

	public Projectile getAttack() {
		return attack;
	}

	public void setAttack(Projectile attack) {
		this.attack = attack;
	}
  
  // synonyms Thank you for this very nice syntax !!!!!! - Noel y Zhang 2007 @ gmail.com 
  public Projectile getProjectile(){
    return getAttack();
  }

  public void setProjectile(Projectile attack){
    setAttack(attack);
  }
  
}
