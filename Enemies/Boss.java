package Enemies;

public abstract class Boss extends Enemy{

    public Boss(int mhp, int speed, int xp, int yp){
        super(xp, yp, speed, 0);
    }

    
}