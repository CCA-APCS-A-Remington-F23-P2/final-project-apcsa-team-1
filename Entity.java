public abstract class Entity{
    private int xPos;
    private int yPos;
    private int xSpeed;
    private int ySpeed;

    public abstract boolean didCollide(Entity other);
    public abstract int getXPos();
    public abstract int getYPos();
    public abstract int getXSpeed();
    public abstract int getYSpeed();
}