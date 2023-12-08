public class Projectile extends Entity{
     
    private int range;
    private int pierce;
    private int attackDelay;
    private int attackDamage;
    private int splashRadius;
    private int chainLength;
    private int chainDistance;
    private double slowAmount;
    private int slowDuration;
    private double freezeChance;
    private int burnDamage;
    private int burnDuration;
    private int stunDuration;

    public Projectile(int speed, double angle, int x, int y, int damage, int range, int pierce){
        super(speed*Math.sin(angle), speed*Math.cos(angle), x, y);
        this.attackDamage = damage;
        this.range = range;
        this.pierce = pierce;
    }

    public int getAttackDelay(){
        return this.attackDelay;
    }
    public int getAttackDamage(){
        return this.attackDamage;
    }
    public int getSplashRadius(){
        return this.splashRadius;    
    }
    public int getChainDistance(){
        return this.chainDistance;
    }
    public int getChainLength(){
        return this.chainLength;
    }
    public double getSlowAmount(){
        return this.slowAmount;
    }
    public int getSlowDuration(){
        return this.slowDuration;
    }
    public double getFreezeChance(){
        return this.freezeChance;
    }
    public int getBurnDamage(){
        return this.burnDamage;
    }
    public int getBurnDuration(){
        return this.burnDuration;
    }
    public int getStunDuration(){
        return this.stunDuration;
    }

    public void setAttackDelay(int delay){
        this.attackDelay = delay;
    }
    public void setAttackDamage(int dmg){
        this.attackDamage = dmg;
    }
    public void setSplashRadius(int radius){
        this.splashRadius = radius;
    }
    public void setChainLength(int length){
        this.chainLength = length;
    }

    public void setChainDistance(int distance){
        this.chainDistance = distance;
    }

    public void setSlowAmount(double amt){
        this.slowAmount = amt;
    }

    public void setSlowDuration(int amt){
        this.slowDuration = amt;
    }

    public void setFreezeChance(double chance){
        this.freezeChance = chance;
    }
    public void setBurnDamage(int dmg){
        this.burnDamage = dmg;
    }
    public void setBurnDuration(int duration){
        this.burnDuration = duration;
    }
    public void setStunDuration(int duration){
        this.stunDuration = duration;
    }

    public int getRange(){
        return range;
    }
    public void setRange(int s){
        range = s;
    }

    public int getPierce(){
        return pierce;
    }

    public void setPierce(int p){
        pierce = p;
    }

}