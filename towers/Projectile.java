package towers;
import Entity.Entity;
import Enemies.Enemy;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Projectile extends Entity{
     
    private int range;
    private int pierce;
    private int attackDelay;
    private int attackDamage;
    private int splashRadius;
    private int chainLength;
    private int chainDistance;
    private double slowAmount;
    private int slowDuration;
    private double freezeChance;
    private int burnDamage;
    private int burnDuration;
    private int stunDuration;
    private ArrayList<Enemy> enemiesHit;
    
    private int direction;
    /**
     * 225 270 315
     *  180 T 0 
     *  135 90 45
     */

    private String sprite;
    
    private int travel;
    
    
    // When first starting the game, create a set of reference projectiles that are not drawn
    // and instead float endlessly into space with all the correct properties. It's really
    // scuffed but it'll work
    public Projectile(int speed, double angle, int x, int y, int damage, int range, int pierce){
        super((int) (speed*Math.cos(angle)), (int) (speed*Math.sin(angle)), x, y);
        this.attackDamage = damage;
        this.range = range;
        this.pierce = pierce;
        this.enemiesHit = new ArrayList<Enemy>();
        this.travel = 0;//all are now transparent
    }
    
    // Deep copy constructor
    public Projectile(int speed, double angle, int x, int y, Projectile that) {
      super((int) (speed*Math.cos(angle)), (int) (speed*Math.sin(angle)), x, y);
      this.attackDamage = that.getAttackDamage();
      this.range = that.getRange();
      this.pierce = that.getPierce();
      this.enemiesHit = new ArrayList<Enemy>();
      this.travel = 0;
      this.sprite = that.getSprite();
    }

    public int getAttackDelay(){
        return this.attackDelay;
    }
    public int getAttackDamage(){
        return this.attackDamage;
    }
    public int getSplashRadius(){
        return this.splashRadius;    
    }
    public int getChainDistance(){
        return this.chainDistance;
    }
    public int getChainLength(){
        return this.chainLength;
    }
    public double getSlowAmount(){
        return this.slowAmount;
    }
    public int getSlowDuration(){
        return this.slowDuration;
    }
    public double getFreezeChance(){
        return this.freezeChance;
    }
    public int getBurnDamage(){
        return this.burnDamage;
    }
    public int getBurnDuration(){
        return this.burnDuration;
    }
    public int getStunDuration(){
        return this.stunDuration;
    }

    public void setAttackDelay(int delay){
        this.attackDelay = delay;
    }
    public void setAttackDamage(int dmg){
        this.attackDamage = dmg;
    }
    public void setSplashRadius(int radius){
        this.splashRadius = radius;
    }
    public void setChainLength(int length){
        this.chainLength = length;
    }

    public void setChainDistance(int distance){
        this.chainDistance = distance;
    }

    public void setSlowAmount(double amt){
        this.slowAmount = amt;
    }

    public void setSlowDuration(int amt){
        this.slowDuration = amt;
    }

    public void setFreezeChance(double chance){
        this.freezeChance = chance;
    }
    public void setBurnDamage(int dmg){
        this.burnDamage = dmg;
    }
    public void setBurnDuration(int duration){
        this.burnDuration = duration;
    }
    public void setStunDuration(int duration){
        this.stunDuration = duration;
    }

    public int getRange(){
        return range;
    }
    public void setRange(int s){
        range = s;
    }

    public int getPierce(){
        return pierce;
    }

    public void setPierce(int p){
        pierce = p;
    }

    public ArrayList<Enemy> getEnemiesHit(){
      return enemiesHit;
    }

    public void hitEnemy(Enemy e){
      enemiesHit.add(e);
    }
    
    public boolean moveAndCheck() {
    	/**
    	 * Returns true if move was successful
    	 * Returns false if maximum lifespan or pierce reached
    	 */

      
    	this.move();
    	travel += (int) Math.hypot(getXSpeed(), getYSpeed());
    	if(travel >= getRange() || enemiesHit.size() >= getPierce()) {
    		return false;
    	}else {
    		return true;
    	}
    }

    public String getSprite() {
      return this.sprite;
    }

    public void setSprite(String sprite) {
      this.sprite = sprite;
    }

    public Image getDirectionalSprite(String direction){
      try{
        return ImageIO.read(new File("images/projectile_sprites/" + getSprite() + "/" + getSprite() + direction + ".png"));
      } catch (IOException e){
        System.out.println("Error loading sprite " + "images/projectile_sprites/" + getSprite() + "/" + getSprite() + direction + ".png: " + e);
        return null;
      }
    }

    public void draw(Graphics g){
      double angle = Math.atan2(getYSpeed(), getXSpeed()) * 180 / Math.PI;
      if(angle < 0){
        angle += 360.0;
      }

      String direction = ""; 

      // FireBlastFragX is rendered differently (pentagonal) 
      if(this instanceof FireBlastFragX){
        if(angle < 36 || angle >= 324){
          direction = "Right";
        }else if(angle >= 36 && angle < 108){
          direction = "Up";
        }else if(angle >= 108 && angle < 180){
          direction = "Left";
        }else if(angle >= 180 && angle < 252){
          direction = "DL";
        }else if(angle >= 252 && angle < 324){
          direction = "DR";
        }
        g.drawImage(getDirectionalSprite(direction), getX(), getY(), null);
        return;
      }
    
      if(angle < 22.5 || angle >= 337.5){
        direction = "0";
      }else if(angle >= 22.5 && angle < 67.5){
        direction = "45";
      }else if(angle >= 67.5 && angle < 112.5){
        direction = "90";
      }else if(angle >= 112.5 && angle < 157.5){
        direction = "135";
      }else if(angle >= 157.5 && angle < 202.5){
        direction = "180";
      }else if(angle >= 202.5 && angle < 247.5){
        direction = "225";
      }else if(angle >= 247.5 && angle < 292.5){
        direction = "270";
      }else if(angle >= 292.5 && angle < 337.5){
        direction = "315";
      }
      g.drawImage(getDirectionalSprite(direction), getX(), getY(), null);
      
    }
}