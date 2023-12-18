import java.util.ArrayList;
import towers.*;
import Enemies.Enemy;

public class Game1{
    private Button[] towerSlots;
    private Enemy[][] rounds;
    private Turn[] path;
    private ArrayList<Tower> selectedTowers;
    private ArrayList<Tower> placedTowers;

    public Game1(ArrayList<String> towers){
        towerSlots = new Button[12];
        towerSlots[0] = new Button(145, 215, 20, 20);
        towerSlots[1] = new Button(145, 284, 20, 20);
        towerSlots[2] = new Button(145, 350, 20, 20);
        towerSlots[3] = new Button(245, 440, 20, 20);
        towerSlots[4] = new Button(380, 487, 20, 20);
        towerSlots[5] = new Button(380, 387, 20, 20);
        towerSlots[6] = new Button(380, 270, 20, 20);
        towerSlots[7] = new Button(457, 388, 20, 20);
        towerSlots[8] = new Button(568, 115, 20, 20);
        towerSlots[9] = new Button(638, 265, 20, 20);
        towerSlots[10] = new Button(829, 282, 20, 20);
        towerSlots[11] = new Button(829, 451, 20, 20);
        path = new Turn[11];
        path[0] = new Turn(785, 228, "up");
        path[1] = new Turn(780, 450, "left");
        path[2] = new Turn(636, 447, "down");
        path[3] = new Turn(630, 340, "left");
        path[4] = new Turn(470, 333, "down");
        path[5] = new Turn(470, 75, "left");
        path[6] = new Turn(378, 75, "up");
        path[7] = new Turn(378, 199, "left");
        path[8] = new Turn(343, 197, "up");
        path[9] = new Turn(343, 490, "left");
        path[10] = new Turn(195, 490, "down");
        selectedTowers = new ArrayList<Tower>();
        for(int i=0; i < towers.size(); i++){
            if(towers.get(i) == "SNIVY") selectedTowers.add(new Snivy(0, 0));
            // if(towers.get(i) == "DREEPY") selectedTowers.add(new ());
            // if(towers.get(i) == "PICHU") selectedTowers.add(new ());
            // if(towers.get(i) == "CHARMANDER") selectedTowers.add(new ());
            // if(towers.get(i) == "") selectedTowers.add(new Snivy());
            // if(towers.get(i) == "") selectedTowers.add(new Snivy());
            // if(towers.get(i) == "") selectedTowers.add(new Snivy());
            // if(towers.get(i) == "") selectedTowers.add(new Snivy());
            // if(towers.get(i) == "") selectedTowers.add(new Snivy());
        }
    }


}