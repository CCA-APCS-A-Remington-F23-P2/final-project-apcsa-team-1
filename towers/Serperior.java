package towers;

public class Serperior extends Tower{
    public Serperior(int x, int y){
        super(500, 1500, new ContrarySerperior(x, y), 80, x, y);    
    }
}