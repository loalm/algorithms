import java.util.*;

public class Spel {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int[][] rows = new int[4][4];
    for (int i = 0; i < 4; i++) {
      int[] row = new int[4];
      for (int j = 0; j < 4; j++) {
        int num = reader.nextInt();
        row[j] = num;
      }
      rows[i] = row;

    }
    Spel spel = new Spel();

    int direction = reader.nextInt();
    if (direction == 0) {
      for (int i = 0; i < 4; i++) {
        spel.shiftRow(rows[i]);
      }
    } else if(direction == 1) {
      rows = spel.rotateBoard(rows);
      rows = spel.rotateBoard(rows);
      rows = spel.rotateBoard(rows);

      for (int u = 0; u < 4; u++) {
        spel.shiftRow(rows[u]);
      }
      rows = spel.rotateBoard(rows);

    } else if (direction == 2) {
      rows = spel.rotateBoard(rows);
      rows = spel.rotateBoard(rows);

      for (int u = 0; u < 4; u++) {
        spel.shiftRow(rows[u]);
      }
      rows = spel.rotateBoard(rows);
      rows = spel.rotateBoard(rows);
    } else {
      rows = spel.rotateBoard(rows);

      for (int u = 0; u < 4; u++) {
        spel.shiftRow(rows[u]);
      }
      rows = spel.rotateBoard(rows);
      rows = spel.rotateBoard(rows);
      rows = spel.rotateBoard(rows);
    }
    spel.printBoard(rows);
  }
  void printBoard(int[][] rows) {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print(rows[i][j]+" ");
      }
      System.out.println();
    }
  }

  void shiftRow(int[] row) {
    for (int i = 0; i < 3; i++) {

      jloop:
      for (int j = i+1; j <= 3; j++) {

        if (row[j] == 0) {

        } else if (row[i] == 0) {
          row[i] = row[j];
          row[j] = 0;
          i--;
          break jloop;

        } else if (row[i] != row[j]) {
          break jloop;
        } else {
          row[i] *= 2;
          row[j] = 0;
          break jloop;
        }
      }

    }
  }

  int[][] rotateBoard(int[][] rows) {
    int[][] newBoard = new int[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        newBoard[i][j] = rows[4 - j - 1][i];
      }
    }
    return newBoard;
  }
}
