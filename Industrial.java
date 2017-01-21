//Kattis problem id:industrialspy
import java.util.*;

public class Industrial {
  public static List<Integer> numbers;
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int cases = Integer.parseInt(reader.nextLine());

    for (int k = 0; k < cases; k++) {

      String input = reader.nextLine();

      List<Character> availableLetters = new ArrayList<Character>();
      for (int i = 0; i < input.length(); i++) {
        availableLetters.add(input.charAt(i));
      }

      Industrial id = new Industrial();
      numbers = new ArrayList<>();

      for (int i = 1; i <= input.length(); i++) {
        id.permutation(availableLetters, new Character[i], 0);
      }
      //System.out.print(id.isPrime(9));

      System.out.println(numbers.size());
    }
  }

  static void permutation(List<Character> availableLetters, Character[] res, int index) {

    for (int i = 0; i < availableLetters.size(); i++) {
      res[index] = availableLetters.get(i);
      if (index == res.length-1) {
        String number = "";
        for (int j = 0; j < res.length; j++) {
          number += res[j];
        }
        int num = Integer.parseInt(number);
        if (isPrime(num) && !numbers.contains(num)) {
          numbers.add(num);
        }
      } else {
        char ch = availableLetters.get(i);
        availableLetters.remove(i);
        List<Character> list = availableLetters;
        permutation(list, res, index+1);
        availableLetters.add(i,ch);
      }
    }
  }

  static boolean isPrime(int n) {
    int divisor = 2;
    if (n < 2) {
      return false;
    }
    while (divisor <= Math.sqrt(n)) {
      if (n % divisor == 0) {
        return false;
      }
      divisor++;
    }
    return true;
  }

}
