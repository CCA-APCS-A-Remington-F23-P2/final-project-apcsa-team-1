package Turn;

import Enemies.Enemy;
import Entity.Entity;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Turn extends Entity{
    private String direction;
    public Turn(int x, int y, String d){
        super(0, x, y, 2, 2);
        direction = d;
      if(direction.equals("up")){
        this.setYPos(this.getYPos()-40);
        this.setHeight(40);
      }
      if(direction.equals("down")){
        this.setHeight(40);
      }
      if(direction.equals("left")){
        this.setXPos(this.getXPos()-40);
        this.setWidth(40);
      }
      if(direction.equals("right")){
        this.setWidth(40);
      }
    }
    public String getDirection(){
        return direction;
    }
    public void setDirection(String input){
        direction = input;
    }


  //ONLY FOR TESTING
  public void draw(Graphics g){
    g.fillRect(getX(), getY(), getWidth(), getHeight());
  }

}