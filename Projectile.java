public class Projectile extends Entity{
    private int damage; 
    private int range;

    public Projectile(int damage, int speed, double angle, int x, int y){
        super(speed*Math.sin(angle), speed*Math.cos(angle), x, y);
        this.damage = damage;
    }

    public void setDamage(int s){
        damage = s;
    }
    
    public int getDamage(){
        return damage;
    }

    public int getRange(){
        return range;
    }
    public void setRange(int s){
        range = s;
    }

}