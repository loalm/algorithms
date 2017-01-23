import java.util.*;

public class Coast {

  static Boolean[][] coast;

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int y = reader.nextInt();
    int x = reader.nextInt();
    coast = new Boolean[y][x];
    wasHere = new boolean[y][x];

    List<Land> lands = new ArrayList<Land>();
    List<Water> waters = new ArrayList<Water>();

    for (int i = 0; i < y; i++) {
      String row = reader.next();
      for(int j = 0; j < x; j++) {
        coast[i][j] = Integer.parseInt(""+row.charAt(j)) != 0;
        if (coast[i][j] == true) {
          lands.add(new Land(i,j));
        } else {
          waters.add(new Water(i,j));
        }
      }
    }
    Coast c = new Coast();

    //Remove all lakes and replace it with land
    for (int u = 0; u<waters.size(); u++) {
      Water water = waters.get(u);
      int i = water.getX();
      int j = water.getY();

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

    int coastLength = 0;

    for(int u = 0; u < lands.size(); u++) {
      Land land = lands.get(u);
      int i = land.getX();
      int j = land.getY();

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

    System.out.print(coastLength);
  }

  static boolean[][] wasHere;
  //static int tries = 0;
  boolean isNotLake(int y, int x) {
    //++tries;
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

class Land {
  int x;
  int y;

  Land(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int getX() {
    return this.x;
  }
  int getY() {
    return this.y;
  }
}

class Water {
  int x;
  int y;

  Water(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int getX() {
    return this.x;
  }
  int getY() {
    return this.y;
  }
}
