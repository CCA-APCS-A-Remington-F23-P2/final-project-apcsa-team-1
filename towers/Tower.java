package towers;

import java.util.ArrayList;
import Enemies.Enemy;

public class Tower {
	private int price;
	private int upgradePrice;
	private Tower nextUpgrade;
	private int xPos;
	private int yPos;
	private int id;
	private int range;

	private int attackCounter;

	public Tower(int price, int upgradePrice, Tower nextUpgrade, int range, int xPos, int yPos) {
		this.price = price;
		this.upgradePrice = upgradePrice;
		this.nextUpgrade = nextUpgrade;
		this.range = range;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getX() {
		return this.xPos;
	}

	public int getY() {
		return this.yPos;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int newPrice) {
		this.price = newPrice;
	}

	public int getUpgradePrice() {
		return upgradePrice;
	}

	public void setUpgradePrice(int newUpgradePrice) {
		this.upgradePrice = newUpgradePrice;
	}

	public Tower getNextUpgrade() {
		return nextUpgrade;
	}

	public void setNextUpgrade(Tower newNextUpgrade) {
		this.nextUpgrade = newNextUpgrade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getAttackCounter() {
		return attackCounter;
	}

	public void setAttackCounter(int attackCounter) {
		this.attackCounter = attackCounter;
	}

	public String getInfo() {
		return "" + id + " " + xPos + " " + yPos;
	}

}