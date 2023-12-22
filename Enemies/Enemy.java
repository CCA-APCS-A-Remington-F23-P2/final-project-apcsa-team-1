package Enemies;

import Turn.Turn;
import java.util.ArrayList;
import Entity.Entity;
import java.awt.Image;
import java.awt.Graphics;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Enemy extends Entity {
  private int maxHp;
  private int hp;
  private int speed;
  private int burnCounter;
  private int stunCounter;
  private int slowCounter;
  private int distTraveled;
  private int money;
  private Image self;

  public Enemy(int mhp, int speed, int xp, int yp, int money) {
    super(0 - speed, 0, xp, yp);
    setWidth(45);
    setHeight(45);
    this.speed = speed;
    this.maxHp = mhp;
    hp = mhp;
    burnCounter = 0;
    stunCounter = 0;
    slowCounter = 0;
    this.money = money;
  }

  public void draw(Graphics g) {
    // System.out.println(self==null);
//    g.fillRect(getX(), getY(), getWidth(), getHeight());
    g.drawImage(self, getX(), getY(), null);
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

  public void setImage(Image self) {
    this.self = self.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
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

  public void makeTurn(Turn t) {
    if (t.didCollide(this)) {
      if (t.getDirection().equals("up")) {
        setYSpeed(-(getSpeed()));
        setXSpeed(0);
      } else if (t.getDirection().equals("right")) {
        setXSpeed(getSpeed());
        setYSpeed(0);
      } else if (t.getDirection().equals("down")) {
        setYSpeed(getSpeed());
        setXSpeed(0);
      } else if (t.getDirection().equals("left")) {
        setXSpeed(-getSpeed());
        setYSpeed(0);
      }
    }
  }

}