import java.util.*;

public class Pot {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int numberOfInputs = reader.nextInt();
    int total = 0;
    for (int i = 0; i < numberOfInputs; i++) {
      int num = reader.nextInt();
      int pow = num % 10;
      double base = Math.floor(num / 10);
      total += Math.pow(base,pow);
    }

    System.out.println(total);
  }
}
