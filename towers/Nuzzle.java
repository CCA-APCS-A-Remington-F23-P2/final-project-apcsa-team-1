package towers;

public class Nuzzle extends HitScanAttack{
    public Nuzzle(){
        super(500, 15);
        setSplashRadius(20);
        setSprite("nuzzle");
    }
}