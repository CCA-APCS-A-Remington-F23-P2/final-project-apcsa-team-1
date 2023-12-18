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
  Button snivy;
  Button pichu;
  Button charmander;
  Button honedge;
  Button magicarp;
  Button dreepy;
  Button sobble;
  Button cleffa;
  Image snivyImg;
  Image pichuImg;
  Image charmanderImg;
  Image honedgeImg;
  Image magicarpImg;
  Image dreepyImg;
  Image sobbleImg;
  Image cleffaImg;
  ArrayList<String> selection;
  ArrayList<Image> selectionImg;

  Button[] selectionButtons;
  // 2 is game screen
  public GameScreen(){
    selection = new ArrayList<String>();
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

      snivyImg = ImageIO.read(getClass().getResource("Snivy.png"));
        pichuImg = ImageIO.read(getClass().getResource("Pichu.png"));
      charmanderImg = ImageIO.read(getClass().getResource("Charmander.png"));
      honedgeImg = ImageIO.read(getClass().getResource("Honedge.png"));
      magicarpImg = ImageIO.read(getClass().getResource("Magicarp.png"));
      dreepyImg = ImageIO.read(getClass().getResource("Dreepy.png"));
      sobbleImg = ImageIO.read(getClass().getResource("Sobble.png"));
      cleffaImg = ImageIO.read(getClass().getResource("Cleffa.png"));
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

    startGame = new Button(375,200,200,80,"Start",Color.GRAY);
    back = new Button(375,400,200,80,"Back",Color.RED);



    snivy = new Button(635,175,100,100,snivyImg);
    pichu = new Button(750,175,100,100,pichuImg);
    charmander = new Button(865,175,100,100,charmanderImg);

    honedge = new Button(635,290,100,100,honedgeImg);
    magicarp = new Button(750,290,100,100,magicarpImg);
    dreepy = new Button(865,290,100,100,dreepyImg);

    sobble = new Button(635,400,100,100,sobbleImg);
    cleffa = new Button(750,400,100,100,cleffaImg);

    selectionImg = new ArrayList<Image>();
    selectionButtons = new Button[6];
    for(int i = 0; i < 6;i++){
      selectionButtons[i] = new Button(35 + 145*(i%2),140*(1+i/2),125,125);
    }
   // sel1 = new Button(35,140,125,125);

    // Can add one more
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
    snivy.draw(g);
    pichu.draw(g);
    charmander.draw(g);
    honedge.draw(g);
    magicarp.draw(g);
    dreepy.draw(g);
    sobble.draw(g);
    cleffa.draw(g);

    for(Button b: selectionButtons){
      b.draw(g);
    }

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
      if(startGame.clicked(e) && selection.size() == 6){
        state++;
        return;
      } else if (back.clicked(e)){
        state--;
        selection = new ArrayList<String>();
        selectionImg = new ArrayList<Image>();
        startGame.setColor(Color.GRAY);
        for(int i = 0; i < selectionButtons.length;i++){
          selectionButtons[i].setImg(null);
        } 
        return;
      }  
      if(snivy.clicked(e)){
        if(!selection.remove("Snivy")){
        selection.add("Snivy");
        selectionImg.add(snivyImg);
        } else {
          selectionImg.remove(snivyImg);
        }
      } else if(pichu.clicked(e)){
        if(!selection.remove("Pichu")){
        selection.add("Pichu");
        selectionImg.add(pichuImg);
        } else {
          selectionImg.remove(pichuImg);
        }
    } else if(charmander.clicked(e)){
        if(!selection.remove("Charmander")){
        selection.add("Charmander");
          selectionImg.add(charmanderImg);

        } else {
          selectionImg.remove(charmanderImg);
        }
    } else if(honedge.clicked(e)){
        if(!selection.remove("Honedge")){
        selection.add("Honedge");
          selectionImg.add(honedgeImg);

        }else {
          selectionImg.remove(honedgeImg);
        }
      } else if(magicarp.clicked(e)){
        if(!selection.remove("Magicarp")){
        selection.add("Magicarp");
          selectionImg.add(magicarpImg);

        }else {
          selectionImg.remove(magicarpImg);
        }
      } else if(dreepy.clicked(e)){
        if(!selection.remove("Dreepy")){
        selection.add("Dreepy");
          selectionImg.add(dreepyImg);

        } else {
          selectionImg.remove(dreepyImg);
        }
      } else if(sobble.clicked(e)){
        if(!selection.remove("Sobble")){
        selection.add("Sobble");
          selectionImg.add(sobbleImg);

        } else {
          selectionImg.remove(sobbleImg);
        }
      } else if(cleffa.clicked(e)){
        if(!selection.remove("Cleffa")){
        selection.add("Cleffa");
        selectionImg.add(cleffaImg);

        } else {
          selectionImg.remove(cleffaImg);
        }
      } else {
        return;
      }
      if(selection.size() == 7){
        selection.remove(6);
        selectionImg.remove(6);
      } // WORKING ON HERE
      if(selection.size()==6){
        startGame.setColor(Color.YELLOW);
      } else {
        startGame.setColor(Color.GRAY);
      }
      for(int i = 0; i < selectionButtons.length;i++){
        selectionButtons[i].setImg(i < selectionImg.size() ? selectionImg.get(i) : null);
      } 

      System.out.println(selection);
    }
  }



 public void	mouseEntered(MouseEvent e){

  } 
  public void	mouseExited(MouseEvent e){

  }
  public void	mousePressed(MouseEvent e){
    System.out.println(e.getX() + " " + e.getY());
  }
  public void mouseReleased(MouseEvent e){

  }
}


