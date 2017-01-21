//Kattis problem id: polymul1
import java.util.*;

public class Poly {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int cases = reader.nextInt();

    for (int x = 0; x < cases; x++) {



      int degree1 = reader.nextInt();
      int[] poly1 = new int[degree1+1];
      for (int i = 0; i < degree1+1; i++) {
        poly1[degree1-i] = reader.nextInt();
      }

      int degree2 = reader.nextInt();
      int[] poly2 = new int[degree2+1];
      for (int i = 0; i < degree2+1; i++) {
        poly2[degree2-i] = reader.nextInt();
      }
      int[] res = new int[degree1+degree2+1];


      for (int i = 0; i < poly1.length; i++) {
        for (int j = 0; j < poly2.length; j++) {
          res[degree1+degree2-i-j] += poly1[i]*poly2[j];
        }
      }
      System.out.println();
      System.out.println(res.length-1);
      for (int u = 0; u < res.length; u++) {
        System.out.print(res[u]+" ");
      }

    }
  }


}
