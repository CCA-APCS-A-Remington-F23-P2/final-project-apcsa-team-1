import Enemies.Enemy;
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

  public Game1(ArrayList<String> towers, ArrayList<Image> img){
        super(towers, 962, 232,img);
      try {
        setImg(ImageIO.read(new File("images/map 1.png")));
      } catch (IOException e) {

      }
        setSelectCord(520,0);
        
        Button[] towerSlots = new Button[13];
        towerSlots[0] = new Button(95, 104, 20, 20);
        towerSlots[1] = new Button(147, 104, 20, 20);
        towerSlots[2] = new Button(95, 161, 20, 20);
        towerSlots[3] = new Button(810, 104, 20, 20);
        towerSlots[4] = new Button(868, 104, 20, 20);
        towerSlots[5] = new Button(868, 161, 20, 20);
        towerSlots[6] = new Button(492, 294, 20, 20);
        towerSlots[7] = new Button(168, 279, 20, 20);
        towerSlots[8] = new Button(224, 279, 20, 20);
        towerSlots[9] = new Button(284, 279, 20, 20);
        towerSlots[10] = new Button(870, 479, 20, 20);
        towerSlots[11] = new Button(870, 425, 20, 20);
        towerSlots[12] = new Button(811, 479, 20, 20);
       setTowerSlots(towerSlots);
        Turn[] path = new Turn[10]; 
        path[0] = new Turn(920, 227, "up");
        path[1] = new Turn(920, 63, "left");
        path[2] = new Turn(54, 64, "down");
        path[3] = new Turn(54, 300, "right");
        path[4] = new Turn(396, 300, "up");
        path[5] = new Turn(396, 204, "right");
        path[6] = new Turn(588, 204, "down");
        path[7] = new Turn(588, 300, "left");
        path[8] = new Turn(915, 300, "up");
        path[9] = new Turn(915, 540, "left");
      setPath(path);
    }

}