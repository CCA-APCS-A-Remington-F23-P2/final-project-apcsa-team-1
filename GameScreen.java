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

import towers.Charmander;
import towers.Cleffa;
import towers.Dreepy;
import towers.Honedge;
import towers.Magikarp;
import towers.Pichu;
import towers.Snivy;
import towers.Sobble;
import towers.Tower;

import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.util.Scanner;

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
    ArrayList < String > selection;
    ArrayList < Image > selectionImg;

    Button[] selectionButtons;
    // 2 is game screen
    Game game;

    public GameScreen() {
      // “Hello! Welcome to our awesome Pokemon tower defense game! Team the bad guys have begun their invasion into our town, and we must defend it. How to play: At the beginning of each round enemies will start spawning. If they reach the end of the path, you lose, but if you manage to survive all 12 rounds, you win! To stop the enemies from reaching the end of the path, you must place towers on the tower slots shown on the map. To place a tower, first select a tower from the menu on the top of the screen, and it should highlight the tower slot in green. Then, click one of the tower slots and it should place a tower there. You can also upgrade your towers by clicking on them after selecting the upgrade tool (green arrow button). Of course, all of this costs money, but killing enemies will give you money back. Each tower has its own attacks and attack speed, but all of them except Cleffa will attack the enemies directly. Cleffa doesn’t attack anything, but she uses her moon powers to print extra money. If you can’t place a tower or upgrade, you either don’t have enough money or it is the final upgrade in the line. There are also different types of enemies, each with their own strengths and weaknesses, but some you should look out for are Gengar, which turns invisible and intangible for a moment whenever it is hit, and Deoxys, which has 3 forms before it dies.”
    	gameToLoad = false;
        selection = new ArrayList < String > ();
        //CHECK IF THE GAME INFO FILE IS EMPTY OR NOT!
        System.out.println(new File("save.txt").length());
        if(new File("save.txt").length() > 5) {
        	gameToLoad = true;
        }

        try {
            title = ImageIO.read(new File("images/Title.png"));
            background = ImageIO.read(new File("images/Background.png"));
            map1Img = ImageIO.read(new File("images/map 1.png"));
            map2Img = ImageIO.read(new File("images/map 2.png"));
            select = ImageIO.read(new File("images/Select.png"));

            snivyImg = ImageIO.read(new File("images/Snivy.png"));
            pichuImg = ImageIO.read(new File("images/Pichu.png"));
            charmanderImg = ImageIO.read(new File("images/Charmander.png"));
            honedgeImg = ImageIO.read(new File("images/Honedge.png"));
            magicarpImg = ImageIO.read(new File("images/Magicarp.png"));
            dreepyImg = ImageIO.read(new File("images/Dreepy.png"));
            sobbleImg = ImageIO.read(new File("images/Sobble.png"));
            cleffaImg = ImageIO.read(new File("images/Cleffa.png"));
        } catch (Exception e) {
            //feel free to do something here
        }
        state = 0;
        selectedMap = 0;
        timer = new Timer(1000 / 30, this);
        timer.start();
        addMouseListener(this);
        newGameButton = new Button(150, 200, 300, 80, "New Game", Color.YELLOW);
        loadButton = new Button(550, 200, 300, 80, "Load Game", gameToLoad ? Color.YELLOW : Color.GRAY);
        map1 = new Button(100, 350, 300, 180, map1Img);
        map2 = new Button(600, 350, 300, 180, map2Img);

        startGame = new Button(375, 200, 200, 80, "Start", Color.GRAY);
        back = new Button(375, 400, 200, 80, "Back", Color.RED);



        snivy = new Button(635, 175, 100, 100, snivyImg);
        pichu = new Button(750, 175, 100, 100, pichuImg);
        charmander = new Button(865, 175, 100, 100, charmanderImg);

        honedge = new Button(635, 290, 100, 100, honedgeImg);
        magicarp = new Button(750, 290, 100, 100, magicarpImg);
        dreepy = new Button(865, 290, 100, 100, dreepyImg);

        sobble = new Button(635, 400, 100, 100, sobbleImg);
        cleffa = new Button(750, 400, 100, 100, cleffaImg);

        selectionImg = new ArrayList < Image > ();
        selectionButtons = new Button[6];
        for (int i = 0; i < 6; i++) {
            selectionButtons[i] = new Button(35 + 145 * (i % 2), 140 * (1 + i / 2), 125, 125);
        }
        // sel1 = new Button(35,140,125,125);

        // Can add one more
    }

    public void actionPerformed(ActionEvent evt) {
        repaint();
      if(game != null){
        game.update();
      }
    }
    public void paintComponent(Graphics g) {
        if (state == 0) {
            drawMenu(g);
        } else if (state == 1) {
            drawSelection(g);
        } else if (state == 2 && game != null) {
            drawGame(g);
        }

    }

    public void drawMenu(Graphics g) {
        g.drawImage(background, 0, -10, null);
        g.drawImage(title, getWidth() / 2 - title.getWidth(this) / 2, 50, null);
        g.setColor(Color.YELLOW);
        if (selectedMap == 0) {
            newGameButton.setColor(Color.GRAY);
        } else {
            newGameButton.setColor(Color.YELLOW);
        }
        newGameButton.draw(g);
        //Start new game button
        
        loadButton.draw(g);
        // load latest button
        if (selectedMap == 1) {
            g.setColor(Color.RED);
            g.fillRect(90, 340, 320, 200);
            g.setColor(Color.YELLOW);
            g.fillRect(590, 340, 320, 200);
        } else if (selectedMap == 2) {
            g.setColor(Color.YELLOW);
            g.fillRect(90, 340, 320, 200);
            g.setColor(Color.RED);
            g.fillRect(590, 340, 320, 200);
        } else {
            g.setColor(Color.YELLOW);
            g.fillRect(90, 340, 320, 200);
            g.fillRect(590, 340, 320, 200);
        }
        map1.draw(g);
        map2.draw(g);

    }

    public void drawSelection(Graphics g) {
        g.drawImage(select, 0, 0, null);

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

        for (Button b: selectionButtons) {
            b.draw(g);
        }

    }
    public void drawGame(Graphics g) {
        game.draw(g);
    }

    public void mouseClicked(MouseEvent e) {
        if (state == 0) {
            if (newGameButton.clicked(e) && selectedMap != 0) {
                state++;
            } else if (map1.clicked(e)) {
                selectedMap = (selectedMap == 1) ? 0 : 1;
            } else if (map2.clicked(e)) {
                selectedMap = (selectedMap == 2) ? 0 : 2;
            } else if (loadButton.clicked(e)) {
                System.out.println("Yay loading game..");
                try {
					Scanner s = new Scanner(new File("save.txt"));
					String line = s.nextLine();
					Scanner forALine = new Scanner(line);
					int map = forALine.nextInt();
					int money  = forALine.nextInt();
					int wave = forALine.nextInt();
                   ArrayList<Image> selectedImages = new ArrayList<Image>();
                  ArrayList<String> selected = new ArrayList<String>();
					for(int i = 0; i < 6;i++) {
						selected.add(getName(s.nextLine()));
            selectedImages.add(imageFromName(selected.get(i)));
					}
					ArrayList<Tower> towers = new ArrayList<Tower>(); 
          while(s.hasNextLine()){
            towers.add(getTowerFromString(s.nextLine()));
          }
         
          Tower[] gameTowers = new Tower[towers.size()];
          System.out.println(towers);
          for(int i = 0; i < towers.size(); i++) {
        	  gameTowers[i] = towers.get(i);
          }
    	  
          if(map == 1){
            game = new Game1(selected,selectedImages,gameTowers,money,wave);
          } else {
            game = new Game2(selected,selectedImages,gameTowers,money,wave);
          }
          
          state+=2;
                  
                  
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                
                //Code this
                
                
                
                
                
                
            }
        } else if (state == 1) {
            if (startGame.clicked(e) && selection.size() == 6) {
                state++;
                if (selectedMap == 1) {
                    game = new Game1(selection, selectionImg);
                    System.out.println("game1");
                  return;
                } else {
                    game = new Game2(selection,selectionImg);
                  System.out.println("game1");
                }
                return;
            } else if (back.clicked(e)) {
                state--;
                selection = new ArrayList < String > ();
                selectionImg = new ArrayList < Image > ();
                startGame.setColor(Color.GRAY);
                for (int i = 0; i < selectionButtons.length; i++) {
                    selectionButtons[i].setImg(null);
                }
                return;
            }
            if (snivy.clicked(e)) {
                if (!selection.remove("Snivy")) {
                    selection.add("Snivy");
                    selectionImg.add(snivyImg);
                } else {
                    selectionImg.remove(snivyImg);
                }
            } else if (pichu.clicked(e)) {
                if (!selection.remove("Pichu")) {
                    selection.add("Pichu");
                    selectionImg.add(pichuImg);
                } else {
                    selectionImg.remove(pichuImg);
                }
            } else if (charmander.clicked(e)) {
                if (!selection.remove("Charmander")) {
                    selection.add("Charmander");
                    selectionImg.add(charmanderImg);

                } else {
                    selectionImg.remove(charmanderImg);
                }
            } else if (honedge.clicked(e)) {
                if (!selection.remove("Honedge")) {
                    selection.add("Honedge");
                    selectionImg.add(honedgeImg);

                } else {
                    selectionImg.remove(honedgeImg);
                }
            } else if (magicarp.clicked(e)) {
                if (!selection.remove("Magikarp")) {
                    selection.add("Magikarp");
                    selectionImg.add(magicarpImg);

                } else {
                    selectionImg.remove(magicarpImg);
                }
            } else if (dreepy.clicked(e)) {
                if (!selection.remove("Dreepy")) {
                    selection.add("Dreepy");
                    selectionImg.add(dreepyImg);

                } else {
                    selectionImg.remove(dreepyImg);
                }
            } else if (sobble.clicked(e)) {
                if (!selection.remove("Sobble")) {
                    selection.add("Sobble");
                    selectionImg.add(sobbleImg);

                } else {
                    selectionImg.remove(sobbleImg);
                }
            } else if (cleffa.clicked(e)) {
                if (!selection.remove("Cleffa")) {
                    selection.add("Cleffa");
                    selectionImg.add(cleffaImg);

                } else {
                    selectionImg.remove(cleffaImg);
                }
            } else {
                return;
            }
            if (selection.size() == 7) {
                selection.remove(6);
                selectionImg.remove(6);
            } // WORKING ON HERE
            if (selection.size() == 6) {
                startGame.setColor(Color.YELLOW);
            } else {
                startGame.setColor(Color.GRAY);
            }
            for (int i = 0; i < selectionButtons.length; i++) {
                selectionButtons[i].setImg(i < selectionImg.size() ? selectionImg.get(i) : null);
            }

            System.out.println(selection);
        } else if (state == 2) {
            game.dealWithClick(e);
        }
    }
    public String getName(String s){
      if (s.contains("Snivy")) {
        return "Snivy";
      } else if (s.contains("Dreepy")) {
        return "Snivy";
      } else if (s.contains("Pichu")) {
        return "Snivy";
      } else if (s.contains("Charmander")) {
        return "Charmander";   
      } else if (s.contains("Sobble")) {
        return "Sobble";
      } else if (s.contains("Magikarp")) {
        return "Magikarp";
      } else if (s.contains("Cleffa")) {
        return "Cleffa";
      } else if (s.contains("Honedge")) {
        return "Honedge";
      } else {
        System.out.println("Invalid tower class");
        return null;
      }
    }
    
    // Return image given string
    public Image imageFromName(String s){
      switch (s){
        case "Snivy":
          return snivyImg;
	case "Dreepy":
          return dreepyImg;
        case "Pichu":
          return pichuImg;
        case "Charmander":
          return charmanderImg;
        case "Sobble":
          return sobbleImg;
        case "Magikarp":
          return magicarpImg;
        case "Cleffa":
          return cleffaImg;
        case "Honedge":
          return honedgeImg;
        default:
          return null;
      }
    }

    
    public Tower getTowerFromString(String s) {
    	if(s.equals("null")) {
    		return null;
    	}
    	Scanner scan = new Scanner(s);
    	System.out.println("S:" + s);
    	String dummy = scan.next();
    	int tier = scan.nextInt();
    	int x = scan.nextInt();
    	int y = scan.nextInt();
    	if (s.contains("Snivy")) {
    		return new Snivy(x, y, tier);
        } else if (s.contains("Dreepy")) {
            return new Dreepy(x, y, tier);
        } else if (s.contains("Pichu")) {
        	return new Pichu(x, y, tier);
        } else if (s.contains("Charmander")) {
            return new Charmander(x, y, tier);
        } else if (s.contains("Sobble")) {
            return new Sobble(x, y, tier);
        } else if (s.contains("Magikarp")) {
            return new Magikarp(x, y, tier);
        } else if (s.contains("Cleffa")) {
            return new Cleffa(x, y, tier);
        } else if (s.contains("Honedge")) {
            return new Honedge(x, y, tier);
        } else {
        	System.out.println("Invalid tower class");
        	return null;
        }
    }


    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {

    }
}