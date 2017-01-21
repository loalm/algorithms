import java.util.*;

public class Cannon {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int numberOfTries = reader.nextInt();
    for (int i = 0; i<numberOfTries; i++) {

      double v0 =  reader.nextDouble();
      double angle =  reader.nextDouble();
      double x1 =  reader.nextDouble();
      double h1 =  reader.nextDouble();
      double h2 =  reader.nextDouble();

      double t = x1/(v0*Math.cos(Math.toRadians(angle)));

      double y = v0*t*Math.sin(Math.toRadians(angle)) - 9.81*t*t/2;

      if(y > h1+1 && y < h2-1) {
        System.out.println("Safe");
      } else {
        System.out.println("Not Safe");
      }
    }
  }
}
