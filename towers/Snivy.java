package towers;

public class Snivy extends Tower{
    public Snivy(int x, int y){
        super(25, 100, new VineWhip(), new Servine(x, y), x, y);
    }   
}
