import java.util.*;
import java.io.BufferedInputStream;

public class wordsfornumbers {


  public static void main(String[] args) {

    String[] numbersto20 = {"zero","one","two","three","four","five",
    "six","seven","eight","nine","ten","eleven","twelve","thirteen",
    "fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

    String[] deci = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy",
    "Eighty","Ninety"};
    Scanner reader = new Scanner(new BufferedInputStream(System.in));
    while (reader.hasNext())
    {
      String line = reader.nextLine();
      StringTokenizer tokenizer = new StringTokenizer(line, " ");
      while (tokenizer.hasMoreTokens()) {
        String word = tokenizer.nextToken();
        if (word.matches("\\d+")) {
          int num = Integer.parseInt(word);
          if (num < 20) {
            System.out.print(numbersto20[Integer.parseInt(word)]);
          } else {
            double dig1 = num % 10;
            double dig2 = Math.floor(num / 10);
            System.out.print(deci[(int)dig2-2]);
            if (dig1 != 0) {
              System.out.print("-"+numbersto20[(int)dig1]);
            }
          }
        } else {
          System.out.print(word);
        }
        System.out.print(' ');
      }
      System.out.println();
    }
  }
}
