import java.util.*;

public class Kinarow {

  static int M, N, K;
  static char[][] board;
  static boolean hWon = false, gWon = false;
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int L = reader.nextInt();
    int hPoints = 0;
    int gPoints = 0;
    while (L > 0) {
      M = reader.nextInt();
      N = reader.nextInt();
      K = reader.nextInt();
      board = new char[N][M];
      for (int i = 0; i<N ; i++) {
        String row = reader.next();
        for (int j = 0; j<M ; j++) {
          board[i][j] = row.charAt(j);
        }
      }
      Kinarow k = new Kinarow();
      for (int i = 0;i<N && !hWon && !gWon; i++) {
        for (int j = 0;j<M && !hWon && !gWon; j++) {
          if (board[i][j] != '.') {
            char player = board[i][j];
            //System.out.println(i+":"+j);
            k.findRoute(i,j,i+1,j,1);
            k.findRoute(i,j,i,j+1,1);
            k.findRoute(i,j,i+1,j+1,1);
            k.findRoute(i,j,i+1,j-1,1);
          }
        }
      }
      --L;
      hPoints += hWon == true ? 1 : 0;
      gPoints += gWon == true ? 1 : 0;
      hWon = false;
      gWon = false;
    }
    //System.out.print("kina");
    System.out.println(hPoints+":"+gPoints);
  }


  static boolean findRoute(int x1, int y1, int x2, int y2, int len) {
    if (len == K) {
      if (board[x1][y1] == 'x') {
        hWon = true;
      } else {
        gWon = true;
      }
      return true;
    }

    if ((0 <= x1 && x1 < N && 0 <= y1 && y1 < M)) {
    } else {
      return false;
    }

    if (0 <= x2 && x2 < N && 0 <= y2 && y2 < M) {
      //System.out.print("igen"+x2+":"+y2);
      if (board[x1][y1] == board[x2][y2]) {
        findRoute(x2,y2,x2+(x2-x1),y2+(y2-y1),len+1);
      }
    }

    return false;
  }

}
