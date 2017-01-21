import java.util.*;

public class Money3 {

  public static int[] parent;

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int friend1 = reader.nextInt();
    for (int i = 2; i <= 6000; i++) {
      if (friend1 == i && i == 4) {
        System.out.print("IMPOSSIBLE");
      } else if(friend1 == i){
        System.out.print("POSSIBLE");
      }
    }

  }

}
