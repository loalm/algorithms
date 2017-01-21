//Kattis problem id: moneymatters
import java.util.*;

public class Money {

  public static boolean[] hasBeenHandled;

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int numberOfPersons = reader.nextInt();
    int numberOfFriendships = reader.nextInt();

    boolean[][] graph = new boolean[numberOfPersons][numberOfPersons];
    int[] money = new int[numberOfPersons];
    hasBeenHandled = new boolean[numberOfPersons];
    for (int i = 0; i < numberOfPersons; i++) {
      money[i] = reader.nextInt();
    }

    for (int i = 0; i < numberOfFriendships; i++) {
      int friend1 = reader.nextInt();
      int friend2 = reader.nextInt();
      graph[friend1][friend2] = true;
      graph[friend2][friend1] = true;
    }

    Money m = new Money();

    int i = 0;
    for (; i < numberOfPersons; i++) {
      if (hasBeenHandled[i]) {

      } else {
        boolean[] line = m.returnMoney(graph,i,new boolean[numberOfPersons]);
        int balance = 0;
        for (int j = 0; j < numberOfPersons; j++) {
          if (line[j]) {
            balance += money[j];
          }
        }
        if (balance != 0) {
          System.out.print("IMPOSSIBLE");
          break;
        }
      }
    }
    if (i == numberOfPersons) {
      System.out.print("POSSIBLE");
    }

  }

  boolean[] returnMoney(boolean[][] graph,int person, boolean[] line) {
    for (int i = 0; i < graph.length; i++) {
      if (graph[person][i] && !line[i]) {
        line[i] = true;
        hasBeenHandled[i] = true;
        returnMoney(graph,i,line);
      }
    }
    return line;
  }

}
