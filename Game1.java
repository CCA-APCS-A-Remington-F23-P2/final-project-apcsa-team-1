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

public class Game1 extends Game {
  public Game1(ArrayList<String> selectedTowers, ArrayList<Image> img,Tower[] gameTowers, int money, int waveCount){
    super(selectedTowers,962,220,img);
    setMoney(money);
    setWaveCount(waveCount);
    setGameTowers(gameTowers);
    setMap(1);
    setSelectCord(520,0);
    try {
      setImg(ImageIO.read(new File("images/map 1.png")));
    } catch (IOException e) {

    }

    Button[] towerSlots = new Button[13];
      towerSlots[0] = new Button(85, 94, 55, 55);
      towerSlots[1] = new Button(137, 94, 55, 55);
      towerSlots[2] = new Button(85, 151, 55, 55);
      towerSlots[3] = new Button(800, 94, 55, 55);
      towerSlots[4] = new Button(858, 94, 55, 55);
      towerSlots[5] = new Button(858, 151, 55, 55);
      towerSlots[6] = new Button(482, 284, 55, 55);
      towerSlots[7] = new Button(158, 477, 55, 55);
      towerSlots[8] = new Button(214, 477, 55, 55);
      towerSlots[9] = new Button(274, 477, 55, 55);
      towerSlots[10] = new Button(860, 469, 55, 55);
      towerSlots[11] = new Button(860, 415, 55, 55);
      towerSlots[12] = new Button(801, 469, 55, 55);
     coolSetTowerSlots(towerSlots);
      Turn[] path = new Turn[10]; 
      path[0] = new Turn(920, 250, "up");
      path[1] = new Turn(945, 61, "left");
      path[2] = new Turn(54, 64, "down");
      path[3] = new Turn(54, 325, "right");
      path[4] = new Turn(426, 315, "up");
      path[5] = new Turn(396, 194, "right");
      path[6] = new Turn(623, 204, "down");
      path[7] = new Turn(588, 333, "right");
      path[8] = new Turn(944, 300, "down");
      path[9] = new Turn(944, 560, "left");
    setPath(path);
  }
  
  public Game1(ArrayList<String> towers, ArrayList<Image> img){
        super(towers, 962, 220,img);
      try {
        setImg(ImageIO.read(new File("images/map 1.png")));
      } catch (IOException e) {

      }
        setSelectCord(520,0);
        setMap(1);
        
        Button[] towerSlots = new Button[13];
        towerSlots[0] = new Button(85, 94, 55, 55);
        towerSlots[1] = new Button(137, 94, 55, 55);
        towerSlots[2] = new Button(85, 151, 55, 55);
        towerSlots[3] = new Button(800, 94, 55, 55);
        towerSlots[4] = new Button(858, 94, 55, 55);
        towerSlots[5] = new Button(858, 151, 55, 55);
        towerSlots[6] = new Button(482, 284, 55, 55);
        towerSlots[7] = new Button(158, 477, 55, 55);
        towerSlots[8] = new Button(214, 477, 55, 55);
        towerSlots[9] = new Button(274, 477, 55, 55);
        towerSlots[10] = new Button(860, 469, 55, 55);
        towerSlots[11] = new Button(860, 415, 55, 55);
        towerSlots[12] = new Button(801, 469, 55, 55);
       setTowerSlots(towerSlots);
        Turn[] path = new Turn[10]; 
        path[0] = new Turn(920, 250, "up");
        path[1] = new Turn(945, 61, "left");
        path[2] = new Turn(54, 64, "down");
        path[3] = new Turn(54, 325, "right");
        path[4] = new Turn(426, 315, "up");
        path[5] = new Turn(396, 194, "right");
        path[6] = new Turn(623, 204, "down");
        path[7] = new Turn(588, 333, "right");
        path[8] = new Turn(944, 300, "down");
        path[9] = new Turn(944, 560, "left");
      setPath(path);
    }

}