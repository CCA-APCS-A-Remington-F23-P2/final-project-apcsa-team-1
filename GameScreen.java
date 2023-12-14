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

public class GameScreen extends JPanel implements ActionListener, MouseListener {
  private int state;
  private Timer timer;
  private int selectedMap;
  private Image title;
  // 0 is menu
  private Button newGameButton;
  private Button loadButton;
  private Button map1;
  private Button map2;
  private Image background;
  private Image map1Img;
  private Image map2Img;
  boolean gameToLoad;
  // 1 is tower selection
  Image select;
  Button startGame;
  Button back;
  // 2 is game screen
  public GameScreen(){

    //CHECK IF THE GAME INFO FILE IS EMPTY OR NOT!

    gameToLoad = false;
    try
    {
      URL url = getClass().getResource("Title.png");
      title = ImageIO.read(url);
      background = ImageIO.read(getClass().getResource("background.png"));
      map1Img = ImageIO.read(getClass().getResource("map 1.png"));
        map2Img = ImageIO.read(getClass().getResource("map 2.png"));
      select = ImageIO.read(getClass().getResource("Select.png"));
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
    state = 0;
    selectedMap = 0;
    timer = new Timer(60, this);
    timer.start();
    addMouseListener(this);
    newGameButton = new Button(150,200,300,80,"New Game", Color.YELLOW);
      loadButton = new Button(550,200,300,80,"Load Game",gameToLoad ? Color.YELLOW : Color.GRAY);
      map1 = new Button(100,350,300,180,map1Img);
      map2 = new Button(600,350,300,180,map2Img);

    startGame = new Button(375,200,200,80,"Start",Color.YELLOW);
    back = new Button(375,400,200,80,"Back",Color.RED);
  }
  
  public void actionPerformed(ActionEvent evt) {
    repaint();
  }
  public void paintComponent(Graphics g){
   if(state == 0){
     drawMenu(g);
   } else if(state == 1){
      drawSelection(g);
    } else if (state == 2){
     drawGame(g);
    }
    
  }

  public void drawMenu (Graphics g){
    g.drawImage(background,0,-10,null);
      g.drawImage(title, getWidth()/2 - title.getWidth(this)/2, 50, null);
      g.setColor(Color.YELLOW);
    if(selectedMap == 0){
      newGameButton.setColor(Color.GRAY);
    } else {
      newGameButton.setColor(Color.YELLOW);
    }
    newGameButton.draw(g);
    //Start new game button
    loadButton.draw(g);
    // load latest button
    if(selectedMap == 1){
      g.setColor(Color.RED);
      g.fillRect(90,340,320,200);
      g.setColor(Color.YELLOW);
      g.fillRect(590,340,320,200);
    } else if(selectedMap == 2){
      g.setColor(Color.YELLOW);
      g.fillRect(90,340,320,200);
      g.setColor(Color.RED);
      g.fillRect(590,340,320,200);
    } else {
      g.setColor(Color.YELLOW);
      g.fillRect(90,340,320,200);
      g.fillRect(590,340,320,200);
    }
    map1.draw(g);
    map2.draw(g);

    }
  
  public void drawSelection (Graphics g){
    g.drawImage(select,0,0,null);

    startGame.draw(g);
    back.draw(g);
  }
  public void drawGame (Graphics g){
    g.setColor(Color.ORANGE);
    g.fillRect(0,0,getWidth(),getHeight());
  }
  
  public void mouseClicked(MouseEvent e){
    if(state==0){
      if(newGameButton.clicked(e) && selectedMap !=0){
      state++;
      } else if (map1.clicked(e)){
      selectedMap = (selectedMap==1) ? 0 : 1;
      } else if (map2.clicked(e)){
    selectedMap = (selectedMap==2) ? 0 : 2;
    } else if(loadButton.clicked(e)){
        System.out.println("Yay loading game..");
    }
    } else if(state == 1){
      if(startGame.clicked(e)){
        state++;
      } else if (back.clicked(e)){
        state--;
      }
    }
    }
 public void	mouseEntered(MouseEvent e){
    
  }
  public void	mouseExited(MouseEvent e){
    
  }
  public void	mousePressed(MouseEvent e){
    
  }
  public void mouseReleased(MouseEvent e){
    
  }
}


