// Happy birthday Ozan!!!!
package Entity;

public abstract class Entity{
    private int xPos;
    private int yPos;
    private int xSpeed;
    private int ySpeed;
    private int width;
    private int height;

    public Entity(int speed, int xp, int yp){
        xPos = xp;
        yPos = yp;
        xSpeed = speed;
        ySpeed = 0;
        width = 20;
    	height = 20;
    }
    
    public Entity(int speed, int xp, int yp, int w, int h) {
    	xPos = xp;
    	yPos = yp;
    	xSpeed = speed;
    	ySpeed = 0;
    	width = w;
    	height = h;
    }
    
    public Entity(int xSpeed, int ySpeed, int x, int y) {
    	xPos = x;
    	yPos = y;
    	this.xSpeed = xSpeed;
    	this.ySpeed = ySpeed;
    	width = 10;
    	height = 10;
    }

    public boolean didCollide(Object obj) {
    	Entity other = (Entity) obj;
    	int thisX = getX() + getWidth()/2;
        int thisY = getY() + getHeight()/2;
        int thatX = other.getX() + other.getWidth() / 2;
        int thatY = other.getY() + other.getHeight() / 2;
        int boxX = (getWidth() + other.getWidth()) / 2;
        int boxY = (getHeight() + other.getHeight()) / 2;
        // this center must be within a box centered at that center with width average of this and that and height average of this and that 
        return thisX > thatX - boxX && thisX < thatX + boxX && thisY > thatY - boxY && thisY < thatY + boxY;	
    }
    
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
    public int getX() {
    	return xPos;
    }
    public int getY() {
    	return yPos;
    }
    public int getXSpeed(){
        return xSpeed;
    }
    public int getYSpeed(){
        return ySpeed;
    }
    public int getWidth() {
    	return this.width;
    }
    public int getHeight() {
    	return this.height;
    }
    public void setWidth(int s) {
      width = s;
    }
    public void setHeight(int s) {
      height = s;
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