import java.util.*;

public class Coast3 {

  public static void main(String[] args) {

    Scanner reader = new Scanner(System.in);

    int N = reader.nextInt();
    int M = reader.nextInt(); reader.nextLine();

    Pair[] moves = {new Pair(0,1),new Pair(1,0),new Pair(0,-1),new Pair(-1,0)};

    boolean[][] board = new boolean[N][M];
    boolean[][] hasVisited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String word = reader.nextLine();
      for (int j = 0; j < M; j++) {
        if (word.charAt(j) == '1') {
          board[i][j] = true;
        }
      }
    }

    List<Pair> borderList = borderPairs(N,M);
    Queue<Pair> q = new ArrayDeque<Pair>();

    int result = 0;

    for (Pair p : borderList) {

      if (!hasVisited[p.x][p.y] && board[p.x][p.y]) {
        q.add(p);
        hasVisited[p.x][p.y] = true;
      }

      while(q.size() != 0) {
        Pair pair = q.poll();

        if (board[pair.x][pair.y] && !hasVisited[pair.x][pair.y]) {
          result++;
          continue;
        }

        assert (!board[pair.x][pair.y]);

        for (Pair move : moves) {

          int currentX = pair.x+move.x;
          int currentY = pair.y+move.y;

          if (currentX < 0 || currentX >= N) {
            continue;
          }

          if (currentY < 0 || currentY >= M) {
            continue;
          }

          if (board[currentX][currentY]) {
            result++;
            continue;
          }

          if (!hasVisited[currentX][currentY]) {
            q.add(new Pair(currentX,currentY));
            hasVisited[currentX][currentY] = true;
          }
        }
      }
    }

    System.out.println(result);
  }

  static List<Pair> borderPairs(int n, int m) {

    List<Pair> borderList = new ArrayList<Pair>();

    for (int i = 0; i<n; i++) {

      borderList.add(new Pair(0,i));
      borderList.add(new Pair(n-1,i));
    }

    for (int i = 1; i<m-1; i++) {

      borderList.add(new Pair(i,0));
      borderList.add(new Pair(i,m-1));
    }

    return borderList;
  }

}

class Pair {
  int x;
  int y;

  Pair(int x, int y){
    this.x = x;
    this.y = y;
  }

}
