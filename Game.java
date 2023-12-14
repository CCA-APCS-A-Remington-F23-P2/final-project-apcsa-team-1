public class Game{
    private button[] towerSlots;
    private Enemy[][] rounds;
    private Turn[] path;

    public Game(){
        towerSlots = new button[12];
        towerSlots[0] = new button(145, 215, 20, 20);
        towerSlots[1] = new button(145, 284, 20, 20);
        towerSlots[2] = new button(145, 350, 20, 20);
        towerSlots[3] = new button(245, 440, 20, 20);
        towerSlots[4] = new button(380, 487, 20, 20);
        towerSlots[5] = new button(380, 387, 20, 20);
        towerSlots[6] = new button(380, 270, 20, 20);
        towerSlots[7] = new button(457, 388, 20, 20);
        towerSlots[8] = new button(568, 115, 20, 20);
        towerSlots[9] = new button(638, 265, 20, 20);
        towerSlots[10] = new button(829, 282, 20, 20);
        towerSlots[11] = new button(829, 451, 20, 20);
    }


}