import java.util.*;
public class Soylent {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int num = reader.nextInt();

    for (int i = 0; i < num; i++) {
      double calories = reader.nextInt();
      System.out.println((int)Math.ceil(calories/400));
    }
  }
}
