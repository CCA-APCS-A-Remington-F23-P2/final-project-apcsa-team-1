public class Attack{
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
    
    private int timeUntilAttack;

    public Attack(int delay, int dmg){
        this.attackDelay = delay;
        this.attackDamage = dmg;
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

    public int getTimeUntilAttack(){
        return this.timeUntilAttack;
    }
    public void setTimeUntilAttack(int time){
        this.timeUntilAttack = time;
    }
    public void decrementTime(){
        this.timeUntilAttack--;
    }
}