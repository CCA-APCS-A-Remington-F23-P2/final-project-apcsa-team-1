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
  // 1 is tower selection
  // 2 is game screen
  public GameScreen(){
    try
    {
      URL url = getClass().getResource("Title.png");
      title = ImageIO.read(url);
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

  }
  void draw(Graphics g){
    if(state == 0){
      // draw menu
    }
    else if(state == 1){
      // draw tower selection
    }
    else if(state == 2){
      // draw game screen
    }
  }
  public void actionPerformed(ActionEvent evt) {
    repaint();
  }
  public void paintComponent(Graphics g){
   if(state == 0){
     drawMenu(g);
   }
    if(state == 1){
      drawSelection(g);
    }
  }

  public void drawMenu (Graphics g){
      g.drawImage(title, 0, 0, null);
      g.setColor(Color.YELLOW);
      g.fillRect(100, 100, 200, 50);
      //Start new game button
      g.fillRect(400, 100, 200, 50);
      // load latest button

    if(selectedMap == 1){
      g.setColor(Color.ORANGE);
    }
    g.fillRect(100,400, 100,100);
    //map 1
    g.setColor(Color.YELLOW);
    if(selectedMap == 2){
      g.setColor(Color.BLUE);
    }
    g.fillRect(300,400,100,100);
    // Add like a map selection feature rn
    }
  
  public void drawSelection (Graphics g){
    g.setColor(Color.RED);
    g.fillRect(100, 100, 200, 50);
    //Start new game button
    g.fillRect(400, 100, 200, 50);
    // load latest button
  }
  
  public void mouseClicked(MouseEvent e){
     System.out.println(e.getX() + " " + e.getY());
      if(e.getX() > 100 && e.getX() < 300 && e.getY() > 100 && e.getY() < 150){
      state++;
      } else if (e.getX() > 100 && e.getX() < 200 && e.getY() > 400 && e.getY() < 500){
      selectedMap = (selectedMap==1) ? 0 : 1;
      } else if (e.getX() > 300 && e.getX() < 400 && e.getY() > 400 && e.getY() < 500){
    selectedMap = (selectedMap==2) ? 0 : 2;
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