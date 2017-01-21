import java.util.*;

public class Coast {

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

    //Remove all lakes and replace it with land
    for (int i = 0; i < y; i++) {
      for(int j = 0; j < x; j++) {
        if (coast[i][j] != null && coast[i][j] != true) {
          if (c.isNotLake(i,j)) {
            //Not a lake, area is the sea! Mark the whole area as sea
            for (int y1 = 0; y1  < wasHere.length; y1++) {
              for (int x1 = 0; x1  < wasHere[0].length; x1++) {
                if (wasHere[y1][x1]) {
                  coast[y1][x1] = null;
                }
              }
            }
          } else {
            //Area is a lake! Mark the whole area as land
            for (int y1 = 0; y1  < wasHere.length; y1++) {
              for (int x1 = 0; x1  < wasHere[0].length; x1++) {
                if (wasHere[y1][x1]) {
                  coast[y1][x1] = true;
                }
              }
            }
          }
          //Clear found area
          wasHere = new boolean[y][x];
        }
      }
    }

    // for (int i = 0; i< y  ; i++ ) {
    //   System.out.println(Arrays.toString(coast[i]));
    // }

    //  System.out.println(c.isNotLake(1,1));

    int coastLength = 0;
    //Measure Coast Length
    for (int i = 0; i < y; i++) {
      for(int j = 0; j < x; j++) {

        if (coast[i][j] != null && coast[i][j] == true) {
          //down
          if (i == 0 || coast[i-1][j] == null || coast[i-1][j] == false) {
            ++coastLength;
          }
          //up
          if (i+1 == y || coast[i+1][j] == null || coast[i+1][j] == false) {
            ++coastLength;
          }
          //left
          if (j == 0 || coast[i][j-1] == null || coast[i][j-1] == false) {
            ++coastLength;
          }
          //right
          if (j == x-1 || coast[i][j+1] == null || coast[i][j+1] == false) {
            ++coastLength;
          }
        }
      }
    }
    System.out.print(coastLength);
  }

  static boolean[][] wasHere;
  static int tries = 0;
  boolean isNotLake(int y, int x) {
    ++tries;
    //  System.out.println(y+":"+x);
    if (coast[y][x] != null && coast[y][x] == true) return false;
    if (coast[y][x] == null) return true;
    if (wasHere[y][x]) return false;

    wasHere[y][x] = true;

    if (y == coast.length-1) {
      return true;
    } else if (isNotLake(y+1,x)) {
      return true;
    }
    if (x == coast[0].length-1) {
      return true;
    } else if (isNotLake(y,x+1)) {
      return true;
    }
    if (y == 0) {
      return true;
    } else if (isNotLake(y-1,x)) {
      return true;
    }
    if (x == 0) {
      return true;
    } else if (isNotLake(y,x-1)) {
      return true;
    }

    return false;
  }


}
