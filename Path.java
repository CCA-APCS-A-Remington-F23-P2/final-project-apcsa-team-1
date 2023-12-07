import java.util.ArrayList;

public class Path {
  private ArrayList<Point> route;
  private int currentPositionIndex;


  public Path(ArrayList<Point> route) {
    this.route = route;
    this.currentPositionIndex = 0;
  }


  public Point currentPointIndex() {
    return route.get(currentPositionIndex);
  }

  public void move() {
    if(currentPositionIndex < route.size() - 1) {
      currentPositionIndex++;
    }
    else {
      System.out.println("end");
    }
  }
}