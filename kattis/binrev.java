import java.util.*;

public class binrev {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int input = reader.nextInt();
    String binary = Integer.toBinaryString(input);

    String reversedBinary = "";

    for (int i = 0; i<binary.length(); i++) {
      reversedBinary += binary.charAt(binary.length()-i-1);
    }
    System.out.println(Integer.parseInt(reversedBinary,2));
  }
}
