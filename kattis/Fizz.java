import java.util.*;

public class Fizz {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int X = reader.nextInt();
    int Y = reader.nextInt();
    int number = reader.nextInt();

    for (int i = 1; i <= number; i++) {
      if(i % X == 0 && i % Y == 0) System.out.println("FizzBuzz");
      else if(i % X == 0) System.out.println("Fizz");
      else if(i % Y == 0) System.out.println("Buzz");
      else System.out.println(i);
    }
  }
}
