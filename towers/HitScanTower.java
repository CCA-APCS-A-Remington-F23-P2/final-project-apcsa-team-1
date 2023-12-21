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
    int targetIndex = -1;
    int furthestProgress = -1;
    int i = 0;
    if (getAttackCounter() <= 0) {
      for (Enemy e : enemies) {
        int sqDistance = (int) Math.pow((getX() - e.getX()),2) + (int) Math.pow((getY() - e.getY()), 2);
        int sqRange = (int) Math.pow(getRange(),2);
        if (sqDistance <= sqRange && e.getDistTraveled() > furthestProgress) {
          targetIndex = i;
          furthestProgress = e.getDistTraveled();
        }
        i++;
      }
      if (targetIndex != -1) {
        // A successfull attack has occured
        setAttackCounter(attack.getAttackDelay());
        Enemy target = enemies.get(targetIndex);
        this.target = target;
        attack.cast(target, this, enemies);
      }
    } else {
      setAttackCounter(getAttackCounter() - 1);
      this.target = null;
    }
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
      // Draw a graphic connecting the tower to the enemy
      double angle = Math.atan2(getY() - target.getY(), getX() - target.getX());
      if(angle < 360.0){
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
        System.out.println("What the heck bro Skibidi Ohio Gyatt Rizz");
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
      if(graphicAngle.equals("0")){
        // -->
        for(int x = 0; x < numTesselations; x++){
          g.drawImage(getAttack().getDirectionalSprite("0"), getX() + x*10, getY() + offset*x, null);
        }
      }else if(graphicAngle.equals("90")){
        // ^ 
        // |
        for(int y = 0; y < numTesselations; y++){
          g.drawImage(getAttack().getDirectionalSprite("90"), getY() + offset*y, getY() - y*10 , null);
        }
      }else if(graphicAngle.equals("180")){
        // <--
        for(int x = 0; x < numTesselations; x++){
          g.drawImage(getAttack().getDirectionalSprite("180"), getX() - x*10, getY() + offset*x, null);
        }
      }else if(graphicAngle.equals("270")){
        // |
        // V
        for(int y = 0; y < numTesselations; y++){
          g.drawImage(getAttack().getDirectionalSprite("270"), getY() + offset*y, getY() + y*10, null);
        }
      }
    }
    
  }
}
