package towers;

import java.util.ArrayList;
import Enemies.Enemy;

public class MeleeTower extends Tower {
	private MeleeAttack attack;

	public MeleeTower(MeleeAttack attack, int price, int upgradePrice, Tower nextUpgrade, int range, int xPos,
			int yPos) {
		super(price, upgradePrice, nextUpgrade, range, xPos, yPos);
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

	public MeleeAttack getAttack() {
		return attack;
	}

	public void setAttack(MeleeAttack attack) {
		this.attack = attack;
	}
}
