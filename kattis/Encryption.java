import java.util.*;
import java.io.BufferedInputStream;

public class Encryption {

  public static void main(String[] args) {
    Scanner reader = new Scanner(new BufferedInputStream(System.in));

    while (true) {
      int steps = Integer.parseInt(reader.nextLine());
      if (steps == 0) {
        break;
      }
      String input = reader.nextLine();
      input = input.replaceAll("\\s+","");

      char[] encryptedMessage = new char[input.length()];
      int j = 0;
      int index = 0;
      for (int i = 0; i < input.length(); i++) {
        encryptedMessage[j] = input.charAt(i);
        j += steps;
        if (j >= input.length()) {
          ++index;
          j = index;
        }
      }

      for (int i = 0; i< encryptedMessage.length ; i++) {
        System.out.print(Character.toUpperCase(encryptedMessage[i]));
      }
      System.out.println();
    }
  }

}
