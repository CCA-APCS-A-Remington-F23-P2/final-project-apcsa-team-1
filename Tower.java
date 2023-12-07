public class Tower{
    private int price;
    private int upgradePrice;
    private Attack attack;
    private Tower nextUpgrade;
    private int xPos;
    private int yPos;
    
    public Tower(int price, int upgradePrice, Attack attack, Tower nextUpgrade, int xPos, int yPos){
        this.price = price;
        this.upgradePrice = upgradePrice;
        this.attack = attack;
        this.nextUpgrade = nextUpgrade;
        this.xPos = xPos;
        this.yPos = yPos;
    }
}