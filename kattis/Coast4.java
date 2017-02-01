//https://tidal.kattis.com/problems/coast
//Idea: start from the edges and work your way in.
import java.util.*;

public class Coast4 {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int y = reader.nextInt();
    int x = reader.nextInt(); reader.nextLine();
    board = new boolean[y][x];
    hasVisited = new boolean[y][x];

    for (int i = 0; i < y; i++) {
      String row = reader.nextLine();
      for (int j = 0; j < x; j++) {
        if (row.charAt(j) == '1') {
          board[i][j] = true;
        }
      }
    }

    for (int i = 0; i < x; i++) {
      coastline(0,i);
      coastline(y-1,i);
    }
    for (int i = 0; i < y; i++) {
      coastline(i,0);
      coastline(i,x-1);
    }
    System.out.println(result);
  }

  static boolean[][] board;
  static boolean[][] hasVisited;
  static int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
  static int result = 0;

  static void coastline(int y, int x) {
    if (board[y][x]) {
      result++;
      return;
    }

    if (hasVisited[y][x]) {
      return;
    } else {

      hasVisited[y][x] = true;

      int moveY = 0;
      int moveX = 0;

      for (int[] move : moves) {
        moveY = move[0];
        moveX = move[1];

        if (x+moveX < 0 || x+moveX >= board[0].length) {
          continue;
        }
        if (y+moveY < 0 || y+moveY >= board.length) {
          continue;
        }
        if (board[y+moveY][x+moveX]) {
          result++;
          continue;
        }

        coastline(y+moveY,x+moveX);
      }


    }
  }

}
