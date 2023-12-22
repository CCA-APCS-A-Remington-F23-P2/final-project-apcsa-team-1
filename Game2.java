import Enemies.Enemy;
import Turn.Turn;
import java.util.ArrayList;
import towers.*;
import java.awt.Color;
  import java.awt.Graphics;
  import java.awt.Graphics2D;
  import java.awt.event.ActionEvent;
  import java.awt.event.KeyListener;
  import java.awt.event.KeyEvent;
  import java.awt.image.BufferedImage;
  import java.awt.event.ActionListener;
  import java.awt.event.MouseListener;
  import java.util.ArrayList;
  import javax.swing.Timer;
  import java.awt.event.MouseEvent;
  import javax.swing.JPanel;
  import java.io.File;
  import java.net.URL;
  import java.awt.Color;
  import java.awt.Graphics;
  import java.awt.Image;
  import javax.imageio.ImageIO;
  import java.io.IOException;

public class Game2 extends Game{


  public Game2(ArrayList<String> selectedTowers, ArrayList<Image> img,Tower[] gameTowers, int money, int waveCount){
     super(selectedTowers, 880, 225,img);
    setMoney(money);
    setWaveCount(waveCount);
    setGameTowers(gameTowers);
    setSelectCord(310,0);
    setMap(2);
    try {
      setImg(ImageIO.read(new File("images/map 2.png")));
    } catch (IOException e) {

    }
   

    Button[] towerSlots = new Button[12];
    towerSlots[0] = new Button(133, 204, 47, 47); //ordered from end to start
    towerSlots[1] = new Button(133, 276, 55, 55);
    towerSlots[2] = new Button(133, 347, 55, 55);
    towerSlots[3] = new Button(235, 430, 55, 55);
    towerSlots[4] = new Button(370, 479, 55, 55);
    towerSlots[5] = new Button(370, 379, 55, 55);
    towerSlots[6] = new Button(370, 266, 55, 55);
    towerSlots[7] = new Button(452, 378, 55, 55);
    towerSlots[8] = new Button(558, 105, 55, 55);
    towerSlots[9] = new Button(630, 275, 55, 55);
    towerSlots[10] = new Button(824, 270, 55, 55);
    towerSlots[11] = new Button(824, 438, 55, 55);
     setTowerSlots(towerSlots);

    Turn[] path = new Turn[11];
    path[0] = new Turn(782, 220, "down"); //ordered from start to finish
    path[1] = new Turn(808, 478, "left");
    path[2] = new Turn(633, 472, "up");
    path[3] = new Turn(654, 338, "left");
    path[4] = new Turn(469, 364, "up");
    path[5] = new Turn(497, 69, "left");
    path[6] = new Turn(378, 75, "down");
    path[7] = new Turn(419, 229, "left");
    path[8] = new Turn(335, 191, "down");
    path[9] = new Turn(369, 518, "left");
    path[10] = new Turn(185, 518, "up");
    setPath(path);
  }

  
  public Game2(ArrayList<String> towers,ArrayList<Image> img) {
    super(towers, 880, 225,img);
    
    try {
      setImg(ImageIO.read(new File("images/map 2.png")));
    } catch (IOException e) {

    }
       setSelectCord(310,0);
        setMap(2);
    
    Button[] towerSlots = new Button[12];
    towerSlots[0] = new Button(133, 204, 47, 47); //ordered from end to start
    towerSlots[1] = new Button(133, 276, 55, 55);
    towerSlots[2] = new Button(133, 347, 55, 55);
    towerSlots[3] = new Button(235, 430, 55, 55);
    towerSlots[4] = new Button(370, 479, 55, 55);
    towerSlots[5] = new Button(370, 379, 55, 55);
    towerSlots[6] = new Button(370, 266, 55, 55);
    towerSlots[7] = new Button(452, 378, 55, 55);
    towerSlots[8] = new Button(558, 105, 55, 55);
    towerSlots[9] = new Button(630, 275, 55, 55);
    towerSlots[10] = new Button(824, 270, 55, 55);
    towerSlots[11] = new Button(824, 438, 55, 55);
     setTowerSlots(towerSlots);

    Turn[] path = new Turn[11];
    path[0] = new Turn(782, 220, "down"); //ordered from start to finish
    path[1] = new Turn(808, 478, "left");
    path[2] = new Turn(633, 472, "up");
    path[3] = new Turn(654, 338, "left");
    path[4] = new Turn(469, 364, "up");
    path[5] = new Turn(497, 69, "left");
    path[6] = new Turn(378, 75, "down");
    path[7] = new Turn(419, 229, "left");
    path[8] = new Turn(335, 191, "down");
    path[9] = new Turn(369, 518, "left");
    path[10] = new Turn(185, 518, "up");
    setPath(path);
  }
  

}