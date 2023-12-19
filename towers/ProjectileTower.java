package towers;

import java.util.ArrayList;
import Enemies.Enemy;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class ProjectileTower extends Tower {
	private Projectile attack;
  private Image self;
	public ProjectileTower(Projectile attack, int[] upgradePrices, int[] ranges, int xPos, int yPos) {
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
  
  // synonyms
  public Projectile getProjectile(){
    return getAttack();
  }

  public void setProjectile(Projectile attack){
    setAttack(attack);
  }
  
  public void setImage(Image self){
    this.self = self;
  }
  public void draw(Graphics g){
    g.drawImage(self,getX(),getY(),null);
  }
}
