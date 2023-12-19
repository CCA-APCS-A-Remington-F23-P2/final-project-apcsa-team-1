package towers;

import java.util.ArrayList;
import Enemies.Enemy;

public class Tower {
  private int tier;
	public int PRICE;
	private int[] upgradePrices;
	private int xPos;
	private int yPos;
	private int[] range;

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
		if(tier != 2){
      return upgradePrices[tier];
    }
    return -1;
	}
  public void upgrade(){
    tier++;
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

	public String getInfo() {
		return "" + getClass() + " " + xPos + " " + yPos;
	}

}