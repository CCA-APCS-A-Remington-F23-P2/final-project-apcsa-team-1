package towers;

public class Snivy extends Tower{
    public Snivy(int x, int y){
    	// price, upgradePrice, nextUpgrade, range, x, y
        super(25, 100, new Servine(x, y), 40, x, y);
    }   
}
