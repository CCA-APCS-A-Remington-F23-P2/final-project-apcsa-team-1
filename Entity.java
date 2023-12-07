public abstract class Entity{
    private int xPos;
    private int yPos;
    private int xSpeed;
    private int ySpeed;

    public Entity(int mhp, int speed, int xp, int yp){
        xPos = x;
        yPos = y;
        xSpeed = xS;
        ySpeed = yS;
    }

    public abstract boolean didCollide(Entity other);
    public void move(){
        xPos += xSpeed;
        yPos += ySpeed;
    }
    public int getXPos(){
        return xPos;
    }
    public int getYPos(){
        return yPos;
    }
    public int getXSpeed(){
        return xSpeed;
    }
    public int getYSpeed(){
        return ySpeed;
    }
    public void setXPos(int s){
        xPos = s;
    }
    public void setYPos(int s){
        yPos = s;
    }
    public void setXSpeed(int s){
        xSpeed = s;
    }
    public void setYSpeed(int s){
        ySpeed = s;
    }
}