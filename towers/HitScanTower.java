package towers;

import java.util.ArrayList;
import Enemies.Enemy;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;

public class HitScanTower extends Tower {
  private HitScanAttack attack;
  private Enemy target;

  public HitScanTower(HitScanAttack attack, int[] upgradePrices, int[] ranges, int xPos,
      int yPos) {
    super(upgradePrices, ranges, xPos, yPos);
    this.setAttack(attack);
  }

  public void cast(ArrayList<Enemy> enemies, ArrayList<Projectile> projectiles) {
	// System.out.println(getAttackCounter());
	int targetIndex = -1;
    int furthestProgress = -1;
    int i = 0;
    if (getAttackCounter() <= 0) {
      for (Enemy e : enemies) {
        int sqDistance = (int) Math.pow((getX() - e.getX()),2) + (int) Math.pow((getY() - e.getY()), 2);
        int sqRange = (int) Math.pow(getRange(),2);
        System.out.println("enemy in range " + sqDistance);
        if (sqDistance <= sqRange && e.getDistTraveled() > furthestProgress) {
          
          targetIndex = i;
          furthestProgress = e.getDistTraveled();
        }
        i++;
      }
      if (targetIndex != -1) {
        // A successfull attack has occured
//    	System.out.println("Hi-yah!");
        setAttackCounter(attack.getAttackDelay());
        Enemy target = enemies.get(targetIndex);
        this.target = target;
        attack.cast(target, this, enemies);
      }
    } else {
      this.target = null;
    }
    setAttackCounter(getAttackCounter() - 1);
  }

  public HitScanAttack getAttack() {
    return attack;
  }

  public void setAttack(HitScanAttack attack) {
    this.attack = attack;
  }
  public void draw(Graphics g){
    super.draw(g);
    if(target !=null){
      // System.out.println("Drawing sprites");
      // Draw a graphic connecting the tower to the enemy
      // Special cases: megaWaterfall, waterfall, thunder all just spawn a graphic on the target
      // waterGun tesselates every 20 (sorry)
      if(getAttack().getSprite().equals("megaWaterfall") || getAttack().getSprite().equals("waterfall") || getAttack().getSprite().equals("thunder")) {
    	  g.drawImage(getAttack().getDirectionalSprite(""), target.getX(), target.getY(), null);
      }else {
	      double angle = Math.atan2(getY() - target.getY(), getX() - target.getX()) * 180 / Math.PI;
	      if(angle < 0.0){
	        angle += 360.0;
	      }
	      String graphicAngle = "";
	      boolean vertical = false;
	      if(angle < 45 || angle > 315){
	        graphicAngle = "0";
	      }else if(angle > 45 && angle < 135){
	        graphicAngle = "90";
	        vertical = true;
	      }else if(angle > 135 && angle < 225){
	        graphicAngle = "180";
	      }else if(angle > 225 && angle < 315){
	        graphicAngle = "270";
	        vertical = true;
	      }else{
	        System.out.println("Invalid angle");
	      }
	      System.out.println(graphicAngle);
	      int numTesselations;
	      int offset;
	      if(vertical){
	        numTesselations = Math.abs(getY() - target.getY()) / 10 + 1;
	        offset = (target.getX() - getX()) / numTesselations;
	      }else{
	        numTesselations = Math.abs(getX() - target.getX()) / 10 + 1;
	        offset = (target.getY() - getY()) / numTesselations;        
	      }
	      if(getAttack().getSprite().equals("waterGun")) {
	    	  numTesselations /= 2;
	    	  offset *= 2;
	      }
	      if(graphicAngle.equals("0")){
	        // -->
	        for(int x = 0; x < numTesselations; x++){
	          g.drawImage(getAttack().getDirectionalSprite("0"), getX() + x*10, getY() + offset*x, null);
	          // System.out.println("Drawing a thing");
	          if(getAttack().getSprite().equals("waterGun")) {
	        	  x++;
	          }
	        }
	      }else if(graphicAngle.equals("90")){
	        // ^ 
	        // |
	        for(int y = 0; y < numTesselations; y++){
	          g.drawImage(getAttack().getDirectionalSprite("90"), getX() + offset*y, getY() - y*10 , null);
	          // System.out.println("Drawing a thing");
	          if(getAttack().getSprite().equals("waterGun")) {
	        	  y++;
	          }
	        }
	      }else if(graphicAngle.equals("180")){
	        // <--
	        for(int x = 0; x < numTesselations; x++){
	          g.drawImage(getAttack().getDirectionalSprite("180"), getX() - x*10, getY() + offset*x, null);
	          // System.out.println("Drawing a thing");
	          if(getAttack().getSprite().equals("waterGun")) {
	        	  x++;
	          }
	        }
	      }else if(graphicAngle.equals("270")){
	        // |
	        // V
	        for(int y = 0; y < numTesselations; y++){
	          g.drawImage(getAttack().getDirectionalSprite("270"), getX() + offset*y, getY() + y*10, null);
	          // System.out.println("Drawing a thing");
	          if(getAttack().getSprite().equals("waterGun")) {
	        	  y++;
	          }
	        }
	      }
      }
    }
    
  }
}
