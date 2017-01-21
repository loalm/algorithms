import java.util.*;

public class Money2 {

  public static int[] parent;

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int numberOfPersons = reader.nextInt();
    int numberOfFriendships = reader.nextInt();

    int[] money = new int[numberOfPersons];
    parent = new int[numberOfPersons];

    for (int i = 0; i < numberOfPersons; i++) {
      money[i] = reader.nextInt();
      parent[i] = i;
    }

    Money2 m = new Money2();

    for (int i = 0; i < numberOfFriendships; i++) {
      int friend1 = reader.nextInt();
      int friend2 = reader.nextInt();
      parent[m.find(friend2)] = m.find(friend1);
    }

    //System.out.print(Arrays.toString(parent));
    int[] total = new int[numberOfPersons];
    for (int i = 0; i < numberOfPersons; i++) {
      total[find(i)] += money[i];
    }

    //System.out.print(Arrays.toString(total));
    int i = 0;
    for (; i < numberOfPersons; i++) {
      if (total[i] != 0) {
        System.out.print("IMPOSSIBLE");
        break;
      }
    }

    if (i == numberOfPersons) {
      System.out.print("POSSIBLE");
    }

  }

  public static int find(int x) {
    if (parent[x] == x) {
      return x;
    } else {
      parent[x] = find(parent[x]);
      return parent[x];
    }
  }

}
