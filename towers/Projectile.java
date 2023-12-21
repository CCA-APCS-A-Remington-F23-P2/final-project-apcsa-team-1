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
        super((int) (speed*Math.sin(angle)), (int) (speed*Math.cos(angle)), x, y);
        this.attackDamage = damage;
        this.range = range;
        this.pierce = pierce;
        this.enemiesHit = new ArrayList<Enemy>();
        this.travel = 0;
    }
    
    // Deep copy constructor
    public Projectile(int speed, double angle, int x, int y, Projectile that) {
    	this(speed, angle, x, y, that.getAttackDamage(), that.getRange(), that.getPierce());
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
    	travel += (int) Math.sqrt(getXSpeed()^2 + getYSpeed()^2);
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
        return ImageIO.read(new File("images/projectile_sprites/" + getSprite() + "/" + getSprite() + direction));
      } catch (IOException e){
        return null;
      }
    }
    

}