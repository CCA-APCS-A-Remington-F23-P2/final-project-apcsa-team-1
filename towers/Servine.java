package towers;

public class Servine extends Tower{
    public Servine(int x, int y){
        super(100, 500, new Serperior(x, y), 60, x, y);
    }
}