package towers;

public class Tower{
    private int price;
    private int upgradePrice;
    private Tower nextUpgrade;
    private int xPos;
    private int yPos;
    
    public Tower(int price, int upgradePrice, Tower nextUpgrade, int xPos, int yPos){
        this.price = price;
        this.upgradePrice = upgradePrice;
        this.nextUpgrade = nextUpgrade;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public int getX() {
    	return this.xPos;
    }
    
    public int getY() {
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
      
    public Tower getNextUpgrade() {
        return nextUpgrade;
    }
      
    public void setNextUpgrade(Tower newNextUpgrade) {
        this.nextUpgrade = newNextUpgrade;
    }

}