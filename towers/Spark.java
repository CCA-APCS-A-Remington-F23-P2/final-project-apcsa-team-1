package towers;

public class Spark extends HitScanAttack{
  public Spark(){
    super(3, 20);
    setSplashRadius(30);
    setSprite("spark");
  }
}