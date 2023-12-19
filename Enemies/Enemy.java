package Enemies;

import Entity.Entity;

public class Enemy extends Entity {
  private int maxHp;
  private int hp;
  private int speed;
  private int burnCounter;
  private int stunCounter;
  private int slowCounter;
  private int distTraveled;
  private int money;

  public Enemy(int mhp, int speed, int xp, int yp, int money) {
    super(xp, yp, 0 - speed, 0);
    this.speed = speed;
    this.maxHp = mhp;
    maxHp = mhp;
    burnCounter = 0;
    stunCounter = 0;
    slowCounter = 0;
    this.money = money;
  }

  public void takeDamage(int d) {
    hp -= d;
  }

  public void setSpeed(int s) {
    speed = s;
  }

  public int getSpeed() {
    return speed;
  }

  public void setMaxHp(int s) {
    maxHp = s;
  }

  public int setMaxHp() {
    return maxHp;
  }

  public void setHp(int s) {
    hp = s;
  }

  public int getHp() {
    return hp;
  }

  public void setBurnCounter(int s) {
    burnCounter = s;
  }

  public void setStunCounter(int s) {
    stunCounter = s;
  }

  public void setSlowCounter(int s) {
    slowCounter = s;
  }

  public int getBurnCounter(int s) {
    return burnCounter;
  }

  public int getStunCounter(int s) {
    return stunCounter;
  }

  public int getSlowCounter(int s) {
    return slowCounter;
  }

  public boolean isDead() {
    if (hp > 0)
      return false;
    return true;
  }

  public int getDistTraveled() {
    return distTraveled;
  }

  public void setDistTraveled(int s) {
    distTraveled = s;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int s) {
    money = s;
  }

  @Override
  public void move() {
    super.move();
    distTraveled += speed;
  }

}