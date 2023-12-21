import Enemies.Enemy;
import Entity.Entity;

public class Turn extends Entity{
    private String direction;
    public Turn(int x, int y, String d){
        super(0, x, y, 5, 5);
        direction = d;
    }
    public String getDirection(){
        return direction;
    }
    public void setDirection(String input){
        direction = input;
    }

  public void makeTurn(Enemy e){
    if(this.didCollide(e)){
      if(direction.equals("up")){
        e.setYSpeed(-(e.getSpeed()));
      }
      if(direction.equals("right")){
        e.setXSpeed(e.getSpeed());
      }
      if(direction.equals("down")){
        e.setYSpeed(e.getSpeed());
      }
      if(direction.equals("left")){
        e.setXSpeed(-e.getSpeed());
      }
    }
  }




}