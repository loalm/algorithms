import java.util.*;

public class Fib {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);


    System.out.print("Hej");
    Fib f = new Fib();
    System.out.print(f.fibonacci(75));
  }

  public static Map<Integer, Integer> mem = new HashMap<Integer, Integer>();

  int fibonacci(int n) {
    if (n <= 2) {
      return 1;
    }
    if (mem.containsKey(n)) {
      System.out.println("in"+n);
      return mem.get(n);
    }
    int res = fibonacci(n-2) + fibonacci(n-1);
    mem.put(n,res);
    return res;
  }
}
