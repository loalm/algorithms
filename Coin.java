import java.util.*;

public class Coin {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    //String input = reader.nextLine();
    Coin c = new Coin();

    for (int i = 0; i < mem.length; i++) {
      for (int j = 0; j < mem[i].length ; j++) {
        mem[i][j] = -1;
      }
    }
    System.out.print(c.opt(3,49));
    System.out.println("tries: "+tries);
  }
  static int tries = 0;
  int[] coins = {25,10,5,1};
  static int[][] mem = new int[4][1000];

  int opt(int i, int x) {
    ++tries;


    if(x < 0) return 1000;
    if(x == 0) return 0;
    if(i == -1) return 1000;
    if (mem[i][x] != -1) return mem[i][x];

    int res = 1000;
    res = Math.min(res, 1+opt(i,x-coins[i]));
    res = Math.min(res, opt(i-1,x));

    mem[i][x] = res;
    return res;
  }

}
