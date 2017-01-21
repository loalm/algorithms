import java.util.*;
public class Combinations {
  public static int res = 0;
  public static List<Integer> numbers;

  private StringBuilder output = new StringBuilder();
  private final String inputstring;
  public Combinations( final String str ){
    inputstring = str;

  }


  public static void main (String args[])
  {
    Scanner reader = new Scanner(System.in);

    String input = reader.nextLine();

    numbers = new ArrayList<>();
    Combinations combobj= new Combinations(input);

    combobj.combine();
    System.out.print(res+""+numbers);
  }

  public void combine() {
    combine(0);
  }
  private void combine(int start ){
    for( int i = start; i < inputstring.length(); ++i ){
      output.append( inputstring.charAt(i) );
      System.out.println( output );
      String myString = output.toString();
      int num = Integer.parseInt(myString);
      if (isPrime(num) && !numbers.contains(num)) {
        numbers.add(num);
        ++res;
      }
      if ( i < inputstring.length() )
      combine( i + 1);
      output.setLength( output.length() - 1 );
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
