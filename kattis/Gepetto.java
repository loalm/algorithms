import java.util.*;

public class Gepetto {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int numberOfIngredients = reader.nextInt();
    int numberOfBadpairs = reader.nextInt();

    //Array with length numberOfIngredients
    long[] E = new long[numberOfIngredients];

    //Reads in bad pairs and puts them in the array i.e E[0] = 0000011 --> 1 and 2 is bad pair
    while (numberOfBadpairs>0) {
      int u = reader.nextInt(), v = reader.nextInt();
      --u; --v;
      E[u] = E[u] | ((long)1 << v);
      E[v] = E[v] | ((long)1 << u);
      --numberOfBadpairs;
    }

    //Array with length 2^numberOfIngredients, i.e the subsets / combinations
    int dp[] = new int[1<<numberOfIngredients];
    dp[0] = (int)1;

    //u loops from 0 to numberOfIngredients, i.e the ingredients
    for (int u = 0; u < numberOfIngredients; u++) {
      int b = (int)1<<u;

      //m loops from 2^numberOfIngredients - 1 to 0, i.e the subsets
      for (int m = (1<<numberOfIngredients) - 1; m >= 0; --m) {
        if ((m & E[u]) != 0) continue;
        //  System.out.println("u:"+u+"m:"+m+"dp[m]:"+dp[m]+"m|b:"+(m|b));
        //The subset
        dp[m|b] += dp[m];
      }
    }

    for (int i = 0; i < dp.length ; i++) {
      //System.out.println(dp[i]);
    }

    long ans = 0;

    for (int m = 0; m < (1<<numberOfIngredients); ++m) {
      ans += dp[m];
    }
    System.out.print(ans);
  }


}
