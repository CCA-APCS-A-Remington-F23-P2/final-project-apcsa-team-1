package towers;

public class Nuzzle extends HitScanAttack{
    public Nuzzle(){
        super(3, 15);
        setSplashRadius(20);
        setSprite("nuzzle");
    }
}