import java.util.*;

public class Modulo {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    boolean[] results = new boolean[42];
    int res = 0;
    for (int i = 0; i < 10; i++) {
      int number =  reader.nextInt();

      int newResult = number % 42;

      if (!results[newResult]) {
        results[newResult] = true;
        ++res;
      }
    }
    System.out.println(res);
  }
}
