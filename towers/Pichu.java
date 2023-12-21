package towers;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Pichu extends HitScanTower {
  public static final int PRICE = 50;
  public static final int [] UPGRADE_PRICES = {150, 300, 450};
  public static final int [] RANGES = {30, 30, 50, 60};

  public Pichu(int x, int y) {
    super(new Nuzzle(), UPGRADE_PRICES, RANGES, x, y);
  }

  public int upgrade(int money) {
    int cost = 0;
    if (UPGRADE_PRICES[getTier()] <= money) {
      cost = super.upgrade(money);
      if (getTier() == 1) {
        setAttack(new Spark());
        try {
          setImage(ImageIO.read(new File("images/Pikachu.png")));
        } catch (Exception e) {

        }
      } else if (getTier() == 2) {
        setAttack(new VoltTackle());

      } else if (getTier() == 3) {
        setAttack(new Thunder());

      }
    }
    return cost;
  }
}
