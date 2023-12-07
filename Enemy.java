public class Enemy extends Entity{
    private int maxHp;
    private int hp;
    private int speed;
    private int burnCounter = 0;
    private int stunCounter = 0;
    private int slowCounter = 0;


    public Enemy(int mhp, int speed, int xp, int yp){
        super(xp, yp, speed, 0);
        this.speed = speed;
        maxHp = mhp;
    }

    public void takeDamage(int d){
        hp -= d;
    }

    public void setSpeed(int s){
        speed = s;
    }

    public int getSpeed(){
        return speed;
    }

    public void setMaxHp(int s){
        maxHp = s;
    }

    public int setMaxHp(){
        return maxHp;
    }

    public voif setHp(int s){
        hp = s;
    }

    public int getHp(){
        return hp;
    }

    public void setBurnCounter(int s){
        burnCounter = s;
    }
    public void setStunCounter(int s){
        stunCounter = s;
    }
    public void setSlowCounter(int s){
        slowCounter = s;
    }
    public int getBurnCounter(int s){
        return burnCounter;
    }
    public int getStunCounter(int s){
        return stunCounter;
    }
    public int getSlowCounter(int s){
        return slowCounter;
    }

}