import java.util.*;

public class Soda {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int e = reader.nextInt();
    int f = reader.nextInt();
    int c = reader.nextInt();
    e += f;
    int drank = 0;

    while (e >= c) {
      drank += Math.floor((e)/c);
      e = (int)(e % c + Math.floor((e)/c));
    }

    System.out.println(drank);



  }


}
