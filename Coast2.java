import java.util.*;

public class Coast2 {

  static Boolean[][] coast;

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int y = reader.nextInt();
    int x = reader.nextInt();
    coast = new Boolean[y][x];
    wasHere = new boolean[y][x];

    for (int i = 0; i < y; i++) {
      String row = reader.next();
      for(int j = 0; j < x; j++) {
        coast[i][j] = Integer.parseInt(""+row.charAt(j)) != 0;
      }
    }
    Coast c = new Coast();
  }
}
