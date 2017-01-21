import java.util.*;
import java.math.*;
import java.io.*;

public class MountainScenes {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    int length = input.nextInt();
    int width = input.nextInt();
    int height = input.nextInt();
    long[][] dp = new long[width+1][length + 1];
    dp[0][length] = 1;
    for (int w2 = 1; w2 <= width; w2++) {
      for (int len = 0; len <= length; len++) {
        for (int h2 = 0; h2 <= height; h2++) {
          try {
            System.out.print("hej");
            dp[w2][len - h2] += dp[w2 - 1][len];
          } catch (Exception e) {

          }
        }
      }
    }
    long sum = 0;
    for(int b = 0; b <= length; b++){
      System.out.println(Arrays.toString(dp[width]));
      sum += dp[width][b];
    }

    sum = (sum - Math.min(width*height, length)/width - 1)%1000000007;
    System.out.println(sum);
  }
}
