public class Blaziken extends Enemy{

    private int SpeedBoostCounter;
    private double SpeedBoostLevel;

    public Blaziken(int xp, int yp){
        super(35, 6, xp, yp);
        speedBoostCounter = 300;
        speedBoostLevel = 1;
    }

    @Override
    public void move(){
        super.move();
        if(speedBoostCounter > 0) speedBoostCounter --;
        else{
            speedBoostCounter = 300;
            if(speedBoostLevel < 4){
                speedBoostLevel += 0.5;
                setSpeed(speedBoostLevel * getSpeed());
            }
        }
    }

    public int getSpeedBoostCounter(){
        return speedBoostCounter;
    }
    public void setSpeedBoostCounter(int s){
        speedBoostCounter = s;
    }
    public int getSpeedBoostLevel(){
        return speedBoostLevel;
    }
    public void setSpeedBoostLevel(int s){
        speedBoostLevel = s;
    }

}