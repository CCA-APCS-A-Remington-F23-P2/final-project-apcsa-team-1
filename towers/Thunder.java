package towers;

public class Thunder extends HitScanAttack{
  public Thunder(){
    super(3, 100);
    setSplashRadius(60);
    setSprite("thunder");
  }
}