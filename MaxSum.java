import java.util.*;

public class MaxSum {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    MaxSum m = new MaxSum();

    int maximum = 0;

    for (int i = 0; i < 7; i++) {
      maximum = Math.max(maximum, m.max_sum(i));
    }
    System.out.print(maximum);

  }
  int[] arr = {2,3,-6,8,7,-6,1};
  int[] mem = new int[1000];
  boolean[] comp = new boolean[1000];

  int max_sum(int i) {
    if (i == 0) {
      return arr[i];
    }
    if (comp[i]) {
      System.out.print("h");
      return mem[i];
    }

    int res = Math.max(arr[i], arr[i]+max_sum(i-1));

    mem[i] = res;
    comp[i] = true;
    return res;
  }
}
