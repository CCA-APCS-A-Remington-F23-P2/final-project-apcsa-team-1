public class Gengar extends Enemy{

    private int intangibilityCounter; 

    public Gengar(int xp, int yp){
           super(25, 6, xp, yp);
           intangibilityCounter = 0;
    }

    @Override
    public void takeDamage(int d){
        super(d);
        intangibilityCounter = 10;
    }

}