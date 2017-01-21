//https://open.kattis.com/problems/scenes

import java.util.*;

public class Scenes2 {

  static int n, w, h;
  static long[][] mem;
  static long mod = (long)(1e9+7);

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    n = reader.nextInt();
    w = reader.nextInt();
    h = reader.nextInt();

    mem = new long[w][n+1];

    Scenes2 s = new Scenes2();
    for (int i = 0; i < mem.length; i++) {
      Arrays.fill(mem[i],-1);
    }

    long all = s.calc(0,0);
    int plain_scenes = Math.min(n/w+1,h+1);

    System.out.print((all-plain_scenes+mod)%mod);
  }


  long calc(int pos, int ribbon) {

    if (ribbon > n) return 0;
    if (pos == w) return 1;
    if (n >= (w)*h) return (long)Math.pow((h+1),(w));


    if (mem[pos][ribbon] != -1) return mem[pos][ribbon];

    long ans = 0;

    for (int i = 0; i <= h; i++) {
      ans += calc(pos+1,ribbon+i);
    }

    mem[pos][ribbon] = (long)(ans % mod);

    return ans;
  }

}
