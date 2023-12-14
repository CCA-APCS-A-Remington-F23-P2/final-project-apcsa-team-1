package towers;

public class Tower{
    private int price;
    private int upgradePrice;
    private Attack attack;
    private Tower nextUpgrade;
    private int xPos;
    private int yPos;
    private int attackDelay;
    
    public Tower(int price, int upgradePrice, Attack attack, Tower nextUpgrade, int xPos, int yPos, int aD){
        this.price = price;
        this.upgradePrice = upgradePrice;
        this.attack = attack;
        this.nextUpgrade = nextUpgrade;
        this.xPos = xPos;
        this.yPos = yPos;
        attackDelay = aD;
    }
    
    public int getXPos() {
    	return this.xPos;
    }
    
    public int getYPos() {
    	return this.yPos;
    }
    public int getPrice() {
        return price;
      }
      
    public void setPrice(int newPrice) {
        this.price = newPrice;
    }
      
    public int getUpgradePrice() {
        return upgradePrice;
    }
      
    public void setUpgradePrice(int newUpgradePrice) {
        this.upgradePrice = newUpgradePrice;
    }
      
    public Attack getAttack() {
        return attack;
    }
      
    public void setAttack(Attack newAttack) {
        this.attack = newAttack;
    }
      
    public Tower getNextUpgrade() {
        return nextUpgrade;
    }
      
    public void setNextUpgrade(Tower newNextUpgrade) {
        this.nextUpgrade = newNextUpgrade;
    }
    public int getAttackDelay(){
        return attackDelay;
    }
    public void setAttackDelat(int s){
        attackDelay = s;
    }

}