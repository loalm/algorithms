import java.util.*;

public class zanzibar {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int cases = reader.nextInt();
    for (int i = 0; i < cases; i++) {
      int previousPopulation = reader.nextInt();
      int notBornHere = 0;
      int nextPop = reader.nextInt();
      while (nextPop != 0) {
        if (nextPop > 2*previousPopulation) {
          notBornHere += nextPop-2*previousPopulation;
        }
        previousPopulation = nextPop;
        nextPop = reader.nextInt();
      }
      System.out.println(notBornHere);
    }
  }
}
