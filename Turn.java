public class Turn{
    private int x;
    private int y; 
    private String direction;
    public Turn(int x, int y, String d){
        this.x = x;
        this.y = y;
        direction = d;
    }

    public int getX() {
        return x;
    }
    public void setX(int input) {
        x = input;
    }
    public int getY(){
        return y;
    }
    public void setY(int input){
        y = input;
    }
    public String getDirection(){
        return direction;
    }
    public void setDirection(String input){
        direction = input;
    }


}