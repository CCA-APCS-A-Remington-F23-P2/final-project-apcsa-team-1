// import java.lang.reflect.Constructor;
import Enemies.*;
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
import java.awt.Font;

import java.io.FileWriter;   // Import the FileWriter class


public abstract class Game {

    private FileWriter saver;
    private File save;

    private int mapNumber;
  
    private int time;
    private int counter;
    private int money;
    private int score;
    
    private ArrayList<Enemy>[] rounds;
    private int waveCount;

    private Button[] towerSlots;
    private Tower[] towers;

    private Turn[] path;
    private ArrayList < Tower > selectedTowers;
    private ArrayList<Image> selectedImages;
    private Image map;

  
    private Tower selected;
    private boolean upgrade;
    private Image coin;
    private Font gameFont;

    private ArrayList<Enemy> enemies;
    private ArrayList<Projectile> projectiles;

    private Button[] options;
    private int selectX;
    private int selectY;
  private Button nextWave;

  private int startX;
  private int startY;

  private int waveDelay;


  public Game(ArrayList < String > towerSelection, int x,int y, ArrayList<Image> selectedImages) {
    
    selectedTowers = new ArrayList<Tower>();
    options = new Button[towerSelection.size() + 1];
    nextWave = new Button(930,22,60,60); 
      for (String s: towerSelection) {
          addCorrespondingTower(s);
      }
    try{
    this.selectedImages = selectedImages; // sad ruined my coding expiernece  : (
    selectedImages.add(ImageIO.read(new File("images/Upgrade.png")));
      coin = ImageIO.read(new File("images/Coin.png"));
    } catch (Exception e){

    }
    gameFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
      money = 100000;
      score = 0;
    waveCount = 0;
    startX = x;
    startY = y;
    projectiles = new ArrayList<Projectile>();
    enemies = new ArrayList<Enemy>();
   rounds = new ArrayList[20];
for(int i=0; i<20; i++){
    rounds[i] = new ArrayList<Enemy>();
}
    

    //round 1
    for(int i=0; i<5; i++){
        rounds[0].add(new Rattata(startX, startY));
    }

    //round 2
    for(int i=0; i<10; i++){
        rounds[1].add(new Rattata(startX, startY));
    }
    rounds[1].add(new Geodude(startX, startY));

    //round 3
    for(int i=0; i<5; i++){
        rounds[2].add(new Rattata(startX, startY));
        rounds[2].add(new Pigeot(startX, startY));
    }

    //round 4
    for(int i=0; i<20; i++){
        rounds[3].add(new Pigeot(startX, startY));
    }
    rounds[3].add(new Snorlax(startX, startY));

    //round 5
    for(int i=0; i<10; i++){
        rounds[4].add(new Geodude(startX, startY));
    }
    rounds[4].add(new Gengar(startX, startY));

    //round 6
    rounds[5].add(new Dialga(startX, startY));

    //round 7
    for(int i=0; i<25; i++){
        rounds[6].add(new Rattata(startX, startY));
    }
    for(int i=0; i<5; i++){
        rounds[6].add(new Pigeot(startX, startY));
    }
    rounds[6].add(new Snorlax(startX, startY));
    rounds[6].add(new Snorlax(startX, startY));

    //round 8
    for(int i=0; i<20; i++){
        rounds[7].add(new Geodude(startX, startY));
    }
    rounds[7].add(new Blaziken(startX, startY));
    rounds[7].add(new Blaziken(startX, startY));

    //round 9
    rounds[8].add(new Reuniclus(startX, startY));
    for(int i=0; i<10; i++){
        rounds[8].add(new Gengar(startX, startY));
    }
    for(int i=0; i<5; i++){
        rounds[8].add(new Rattata(startX, startY));
    }

    //round 10
    for(int i=0; i<3; i++){
        rounds[9].add(new Reuniclus(startX, startY));
    }
    for(int i=0; i<15; i++){
        rounds[9].add(new Geodude(startX, startY));
    }
    for(int i=0; i<8; i++){
        rounds[9].add(new Snorlax(startX, startY));
        rounds[9].add(new Pigeot(startX, startY));
    }
    rounds[9].add(new Gengar(startX, startY));

    //round 11
    rounds[10].add(new DeoxysAttack(startX, startY));
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



  public void update(){
    time++;
    

    // Cast towers (attacks)
    for(Tower t: towers){
      if(t != null){
        t.cast(enemies, projectiles);    
      }
    }

    // Move projectiles
    for(int p = 0; p < projectiles.size(); p++){
      Projectile proj = projectiles.get(p);
      proj.moveAndCheck();
      
      for(int e = 0; e < enemies.size(); e++){
        Enemy en = enemies.get(e);
        if(en.didCollide(proj) && !proj.getEnemiesHit().contains(e)){
          en.takeDamage(proj.getAttackDamage());
          proj.hitEnemy(en);
        }
      } 
    }

    // Move/remove enemies
    for(int e = 0; e < enemies.size(); e++){
      Enemy en = enemies.get(e);
      for(Turn t: path){
        t.makeTurn(en);
      }
      if(time % 5==0){
        en.move();
      }
      if(en.isDead()){
        if(en instanceof Duosion){
          enemies.add(new Solosis(en.getX(), en.getY()));
          if(en.getYSpeed() > 0) enemies.add(new Solosis(en.getX(), en.getY()-4));
          else if(en.getYSpeed() < 0) enemies.add(new Solosis(en.getX(), en.getY()+4));
          else if(en.getXSpeed() > 0) enemies.add(new Solosis(en.getX()-4, en.getY()));
          else if(en.getXSpeed() < 0) enemies.add(new Solosis(en.getX()+4, en.getY()));
        enemies.get(enemies.size()-1).setDistTraveled(en.getDistTraveled()+4);
        enemies.get(enemies.size()-2).setDistTraveled(en.getDistTraveled());
        }
        if(en instanceof Reuniclus){
          enemies.add(new Duosion(en.getX(), en.getY()));
          if(en.getYSpeed() > 0) enemies.add(new Duosion(en.getX(), en.getY()-4));
          else if(en.getYSpeed() < 0) enemies.add(new Duosion(en.getX(), en.getY()+4));
          else if(en.getXSpeed() > 0) enemies.add(new Duosion(en.getX()-4, en.getY()));
          else if(en.getXSpeed() < 0) enemies.add(new Duosion(en.getX()+4, en.getY()));
enemies.get(enemies.size()-1).setDistTraveled(en.getDistTraveled()+4);
enemies.get(enemies.size()-2).setDistTraveled(en.getDistTraveled());
}
        money += en.getMoney();
        enemies.remove(e);
        e--;
      }
    }
  


    //Waves 
     if(rounds[waveCount].size()>0){
      if(time % 20  == 0){
        enemies.add(rounds[waveCount].get(0));
        enemies.get(enemies.size()-1).setXPos(startX);
        enemies.get(enemies.size()-1).setYPos(startY);
        rounds[waveCount].remove(0);
      }
     }
    else{
      if(enemies.size() == 0){
        saveGame();
        try{
        nextWave.setImg(ImageIO.read(new File("images/NEXTWAVE.png")));
        } catch (Exception e) {

        }
      }
    }
    
  }

  public void saveGame(){
    try{
      String s = ""+mapNumber+" "+money+" "+score+" "+waveCount+" ";
      for(Tower t: towers){
        s += ;
      }
      saver = new FileWriter("save.txt",false);
      saver.write(s);
    } catch (Exception e) {
    }
  }

    public void setMap(int num){
      mapNumber = num;
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
      nextWave.draw(g);
        drawSelect(g);
      for(Tower t : towers){
        if(t!=null){
          t.draw(g);
        }

      }
      g.drawImage(coin,20,500,null);
      g.setFont(gameFont);
      g.drawString("" + money,80,550);
      g.drawString("Wave: " + waveCount,20,40);
      for(Enemy e : enemies){
        e.draw(g);
      }

      for(Projectile p: projectiles){
        p.draw(g);
      }
    }

    public void setSelectCord(int x, int y){
        selectX = x;
        selectY = y;
      for(int i = 0; i < options.length; i++){
        options[i] = new Button((x+5) + i*55,y+5,50,50,selectedImages.get(i));
        
      }
    }
    public void drawSelect(Graphics g){
      g.setColor(Color.GRAY);
      g.fillRect(selectX, selectY, 400,60);
      for(Button b : options){
        b.draw(g);
      }
    }

    public void dealWithClick(MouseEvent e) {

      //for noel testing
      System.out.println(e.getX() + ", " + e.getY());
      
        if(nextWave.clicked(e) && enemies.size()==0){
          waveCount++;
          nextWave.setImg(null);
          return;
        }
        for(int i = 0; i < options.length; i++){
          if(options[i].clicked(e)){
            if(selected == null && !upgrade){
              if(i == selectedTowers.size()){
                upgrade = true;
                options[i].setColor(Color.GREEN);
                return;
              }
              selected = selectedTowers.get(i);
              options[i].setColor(Color.GREEN);
              return;
            }
          if(upgrade){
              options[6].setColor(null);
              upgrade = false;
              if(i != selectedTowers.size()){
              selected = selectedTowers.get(i);
              options[i].setColor(Color.GREEN);
              return;
            }
          }
          if(i == selectedTowers.size()){
            upgrade = true;
            options[i].setColor(Color.GREEN);
            if(selected!=null){
            options[selectedTowers.indexOf(selected)].setColor(null);
            }
            selected = null;
            return;
          }
            options[selectedTowers.indexOf(selected)].setColor(null);
            selected = selectedTowers.get(i);
            options[i].setColor(Color.GREEN);
            return;
          }
        }
        for (int i = 0; i < towerSlots.length; i++) {
            if(towerSlots[i].clicked(e)){
              if(upgrade && towers[i] != null && towers[i].getTier() != 3){
                money = money - towers[i].upgrade(money);
              }
            if (buyTower(towers[i], selected)) {
              if(selected instanceof Charmander){
                towers[i] = new Charmander(towerSlots[i].getX(), towerSlots[i].getY());
              }
              else if (selected instanceof Cleffa){
                towers[i] = new Cleffa(towerSlots[i].getX(), towerSlots[i].getY());
              }
              else if(selected instanceof Dreepy){
                towers[i] = new Dreepy(towerSlots[i].getX(), towerSlots[i].getY());
              }
              else if(selected instanceof Honedge){
                towers[i] = new Honedge(towerSlots[i].getX(), towerSlots[i].getY());
              }
              else if(selected instanceof Magikarp){
                towers[i] = new Magikarp(towerSlots[i].getX(), towerSlots[i].getY());
              }
              else if(selected instanceof Pichu){
                towers[i] = new Pichu(towerSlots[i].getX(), towerSlots[i].getY());
              }
              else if(selected instanceof Snivy){
                towers[i] = new Snivy(towerSlots[i].getX(), towerSlots[i].getY());
              }
              else if(selected instanceof Sobble){
                towers[i] = new Sobble(towerSlots[i].getX(), towerSlots[i].getY());
              }
            }
            }
        }
    }






    public boolean buyTower(Tower t, Tower toBeAdded) {
        if (t != null || toBeAdded == null) {
            return false;
        }
        if (money >= toBeAdded.getPrice()) {
          money -= toBeAdded.getPrice();
            return true;
        }
        return false;
    } 

}