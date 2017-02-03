//https://open.kattis.com/problems/reversingroads
import java.util.*;
import java.io.BufferedInputStream;

public class reversingroads3 {

  public static void main(String[] args) {
    Scanner reader = new Scanner(new BufferedInputStream(System.in));

    int g = 1;

    while (reader.hasNext()) {

      n = reader.nextInt();
      m = reader.nextInt();

      graph = new boolean[n][n];

      Road[] roads = new Road[m];
      for (int i = 0; i<m; i++) {
        int x = reader.nextInt();
        int y = reader.nextInt();

        graph[x][y] = true;
        roads[i] = new Road(x,y);
      }
      System.out.print("Case "+g+": ");


      boolean foundSolution = false;

      if ( findAll() ) {
        foundSolution = true;
        System.out.println("valid");
      } else {
        outer:
        for (Road r : roads) {
          int i = r.x;
          int j = r.y;

          if (graph[i][j] && i != j) {
            changeDirection(i,j);
            if (findAll()) {
              System.out.println(i+" "+j);
              foundSolution = true;
              break outer;
            }
            changeDirection(j,i);
          }


        }
      }

      if (!foundSolution) {
        System.out.println("invalid");
      }
      ++g;
    }

  }
  static boolean[][] graph;
  static int m,n;
  static HashSet<Integer> hasVisited;

  static void changeDirection(int i, int j) {
    graph[i][j] = false;
    graph[j][i] = true;
  }


  static boolean findAll() {
    for (int i = 0; i<n ;i++) {
      hasVisited = new HashSet<Integer>();
      find(i);
      if (hasVisited.size() != n) {
        return false;
      }
    }
    return true;
  }


  static void find(int i) {
    hasVisited.add(i);
    for (int j = 0; j<n; j++) {
      if (graph[i][j] && !hasVisited.contains(j)) {
        find(j);
      }
    }
  }
}

class Road {
  public int x, y;

  public Road(int x, int y) {
    this.x = x;
    this.y = y;
  }

}
