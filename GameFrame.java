import javax.swing.JFrame;
import javax.swing.JPanel;
public class GameFrame extends JFrame{
  
  private static final int WIDTH = 1000;
  private static final int HEIGHT = 600;
  
  public GameFrame(){
    super("Poke-Defense");

    setSize(WIDTH,HEIGHT);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

  
  }
  
}