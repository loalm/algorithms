//id:threepowers
import java.util.*;
import java.math.*;
public class Three {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    BigInteger num = reader.nextBigInteger();

    while (num.compareTo(new BigInteger("0")) > 0) {
      num = num.subtract(new BigInteger("1"));
      List<BigInteger> list = new ArrayList<BigInteger>();
      String binary = num.toString(2);
    //  System.out.println(binary);

      for (int i = 0; i < binary.length(); i++) {
        if (binary.charAt(binary.length()-i-1) == '1') {
          BigInteger n = new BigInteger("3");
          list.add(n.pow(i));
        }
      }
      System.out.println();
      System.out.print("{ ");
      for (int j = 0; j < list.size(); j++) {
        System.out.print(list.get(j));
        if (j != list.size()-1) {
          System.out.print(", ");
        }
      }
      System.out.print(" }");
      num = reader.nextBigInteger();
    }
  }

}
