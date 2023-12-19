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

public abstract class Game {
    private int money;
    private int score;

    private Enemy[][] rounds;
    private int waveCount;

    private Button[] towerSlots;
    private Tower[] towers;

    private Turn[] path;
    private ArrayList < Tower > selectedTowers;
    private Image map;
    private Tower selected;

  private int startX;
  private int startY;




  public void setStartX(int a){
    startX = a;
  }
  public void setStartY(int a){
    startY = a;
  }
    public int getMoney() {
        return money;
    }
    public int getScore() {
        return score;
    }
    public void setMoney(int m) {
        money = m;
    }
    public void setScore(int s) {
        score = s;
    }

    public void setTowerSlots(Button[] towerSlots) {
        this.towerSlots = towerSlots;
        towers = new Tower[towerSlots.length];
    }

    public void setPath(Turn[] path) {
        this.path = path;
    }

    public void setImg(Image map) {
        this.map = map;
    }
    public Game(ArrayList < String > towerSelection) {
      selectedTowers = new ArrayList<Tower>();
        for (String s: towerSelection) {
            addCorrespondingTower(s);
        }
        money = 100;
        score = 0;

    }

  public void setTowerSelects(int x, int y){
    return;
  }




    private void addCorrespondingTower(String s) {
        if (s.equals("Snivy")) {
            selectedTowers.add(new Snivy(0, 0));
        } else if (s.equals("Dreepy")) {
            selectedTowers.add(new Dreepy(0, 0));
        } else if (s.equals("Pichu")) {
            selectedTowers.add(new Pichu(0, 0));
        } else if (s.equals("Charmander")) {
            selectedTowers.add(new Charmander(0, 0));
        } else if (s.equals("Sobble")) {
            selectedTowers.add(new Sobble(0, 0));
        } else if (s.equals("Magicarp")) {
            selectedTowers.add(new Magikarp(0, 0));
        } else if (s.equals("Cleffa")) {
            selectedTowers.add(new Cleffa(0, 0));
        } else if (s.equals("Honedge")) {
            selectedTowers.add(new Honedge(0, 0));
        }
    }


    public void draw(Graphics g) {
        g.drawImage(map, 0, 0, null);
    }

    public void dealWithClick(MouseEvent e) {
        System.out.println(e.getX() + ", " + e.getY());
        for (int i = 0; i < towerSlots.length; i++) {
            if (towerSlots[i].clicked(e) && buyTower(towers[i], selected)) {
                System.out.println("placed a tower!");
            }
        }
    }






    public boolean buyTower(Tower t, Tower toBeAdded) {
        if (t != null || toBeAdded == null) {
            return false;
        }
        if (money >= toBeAdded.PRICE) {
            money -= toBeAdded.PRICE;
            return true;
        }
        return false;
    }

}