package towers;

import java.util.ArrayList;
import Enemies.Enemy;
import java.awt.Image;
import java.awt.Graphics;

public class Tower implements Serializable{
  private int tier;
	public int PRICE;
	private int[] upgradePrices;
	private int xPos;
	private int yPos;
	private int[] range;
  
  private Image self;

	private int attackCounter;

	public Tower(int[] upgradePrices, int[] ranges, int xPos, int yPos) {
		this.upgradePrices = upgradePrices;
		this.range = ranges;
		this.xPos = xPos;
		this.yPos = yPos;
    tier = 0;
	}

	public int getX() {
		return this.xPos;
	}

	public int getY() {
		return this.yPos;
	}


	public int getUpgradePrice() {
		if(tier != 3){
      return upgradePrices[tier];
    }
    return Integer.MAX_VALUE;
	}
  
  public int upgrade(int money){
    int a = getUpgradePrice();
    if(money >= a){  
      tier++;
      return a;
    }
    return 0;
  }


	public int[] getUpgradePrices() {
		return upgradePrices;
	}

	public int getRange() {
		return range[tier];
	}


	public int getAttackCounter() {
		return attackCounter;
	}

	public void setAttackCounter(int attackCounter) {
		this.attackCounter = attackCounter;
	}

  public int getTier(){
    return tier;
  }

  public void setTier(int tier){
    this.tier = tier;
  }

  public void setImage(Image self){
    this.self = self;
  }
  public void draw(Graphics g){
    g.drawImage(this.self, getX(), getY(), null);
  }

  public void cast(ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles){};

  
	public String getInfo() {
		return "" + getClass() + " " + getTier() + " " + xPos + " " + yPos;
	}

  public boolean canAttack(Enemy e){
    if((int) Math.pow(e.getX() - xPos, 2) + (int) Math.pow(e.getY() - yPos, 2) <= Math.pow(range[tier], 2)){
      return true;
  }
    return false;
}
}