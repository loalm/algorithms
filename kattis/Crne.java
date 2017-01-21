import java.util.*;

public class Crne {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int input = reader.nextInt();
    long res = 0;
    long i = 1;
    long j = 0;
    while (input >= 0) {
      res += i;
      j++;
      if (j == 2) {
        j =0;
        i++;
      }
      //System.out.println("hej");
      --input;
    }
    System.out.print(res);
  }


}
