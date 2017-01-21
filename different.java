import java.util.*;
import java.io.BufferedInputStream;

public class different {


  public static void main(String[] args) {
    Scanner reader = new Scanner(new BufferedInputStream(System.in));

    while (reader.hasNext())
    {
      double input1 = reader.nextDouble();
      double input2 = reader.nextDouble();

      System.out.printf("%.0f",Math.abs(input1-input2));
      System.out.println();
    }
  }
}
