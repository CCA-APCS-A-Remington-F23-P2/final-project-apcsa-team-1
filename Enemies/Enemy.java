package Enemies;

import Entity.Entity;
import java.awt.Graphics;

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
    super(0-speed, 0, xp, yp);
    this.speed = speed;
    this.maxHp = mhp;
    hp = mhp;
    burnCounter = 0;
    stunCounter = 0;
    slowCounter = 0;
    this.money = money;
  }

  public void draw(Graphics g){
    g.drawString(""+getClass(),getX(),getY());
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

  public int getMaxHp() {
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

  public int getBurnCounter() {
    return burnCounter;
  }

  public int getStunCounter() {
    return stunCounter;
  }

  public int getSlowCounter() {
    return slowCounter;
  }

  public boolean isDead() {
    return hp <= 0;
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
