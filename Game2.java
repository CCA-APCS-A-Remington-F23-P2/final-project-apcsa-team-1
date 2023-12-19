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

public class Game2 extends Game{

  public Game2(ArrayList<String> towers) {
    super(towers);
    
    try {
      setImg(ImageIO.read(new File("images/map 2.png")));
    } catch (IOException e) {

    }

    
    Button[] towerSlots = new Button[12];
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
     setTowerSlots(towerSlots);

    Turn[] path = new Turn[11];
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
    setPath(path);
    setStartX(880);
    setStartY(225);
  }
  

}