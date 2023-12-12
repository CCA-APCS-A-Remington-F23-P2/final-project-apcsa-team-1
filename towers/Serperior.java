package towers;

public class Serperior extends Tower{
    public Serperior(int x, int y){
        super(500, 1500, new LeafStorm(), new ContrarySerperior(x, y), x, y);    
    }
}