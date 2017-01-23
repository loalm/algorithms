import java.util.*;

public class Collatz {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);


    while (true) {
      a = reader.nextLong();
      b = reader.nextLong();
      if (a == 0 && b == 0) {
        break;
      }
      list = new ArrayList<Long>();

      Collatz c = new Collatz();
      c.calcSteps(a);
      c.calcSteps(b);
    }

  }
  static Long a,b;
  static List<Long> list;

  void calcSteps(Long x) {
    int xsteps = 0;

    while (true) {

      if (list.contains(x)) {
        //System.out.print("Hej"+x);
        System.out.println(a+" needs "+list.indexOf(x)+" steps, "+b+" needs "+xsteps+" steps, they meet at "+x);
        break;
      }
      list.add(x);
      ++xsteps;
      if (x == 1) {
        break;
      }
      if (x % 2 == 0) {
        x = x/2;
      } else {
        x = 3*x+1;
      }


    }
  }
}
