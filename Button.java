import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;

public class Button{
  private int x;
  private int y;
  private int width;
  private int height;
  private String text;
  private Image img;
  Color c;
  Font f;
  public Button(int x, int y, int width, int height){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.text = text;
  }
  public Button(int x, int y, int width, int height, String text, Color c){
    this(x,y,width,height);
    this.text = text;
    this.c = c;
    f = new Font("Arial", Font.BOLD, 34);
  }
  public Button(int x, int y, int width, int height, Color c){
    this(x,y,width,height);
    this.c =  c;
  }
  public Button(int x, int y, int width, int height, Image img){
    this(x,y,width,height);
    this.img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
  }
  
 public boolean clicked(MouseEvent e){
    return e.getX() > x && e.getX() < x+width && e.getY() > y && e.getY() < y+height;
  }
  public void draw(Graphics g){
    if(img == null){
    g.setColor(c);
    g.fillRect(x, y, width, height);
    g.setColor(Color.black);
      if(text!=null){
    g.setFont(f);
    g.drawString(text, x+width/2-g.getFontMetrics().stringWidth(text)/2, y+height/2 + f.getSize()/2);
      }
    } else {
      g.drawImage(img,x,y,null);
    }
  }
  public void setColor(Color c){
    this.c = c;
  } 
}
