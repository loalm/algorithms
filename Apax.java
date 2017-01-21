import java.util.*;

public class Apax {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    String input = reader.nextLine();

    String answer = ""+input.charAt(0);

    for (int i = 1; i < input.length(); i++) {
      if ( input.charAt(i-1) != input.charAt(i) ) {
        answer += input.charAt(i);
      }
    }
    System.out.println(answer);
  }
}
