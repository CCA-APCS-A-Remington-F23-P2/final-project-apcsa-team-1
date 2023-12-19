import Enemies.Enemy;
import Entity.Entity;

public class Turn extends Entity{
    private String direction;
    public Turn(int x, int y, String d){
        super(0, x, y);
        direction = d;
    }
    public String getDirection(){
        return direction;
    }
    public void setDirection(String input){
        direction = input;
    }

}