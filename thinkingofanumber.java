import java.util.*;
public class thinkingofanumber {

  public static boolean div(int i , ArrayList<Integer> div) {

    for (int x : div)
    if (i % x != 0)
    return false;

    return true;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    while (true)
    {
      int clues = scan.nextInt();

      if (clues == 0)
      break;

      boolean infinite = true;
      boolean printed = false;

      int min = 0;
      int max = Integer.MAX_VALUE;
      ArrayList<Integer> divs = new ArrayList<>();

      while (clues --> 0)
      {
        String str = scan.next();
        scan.next();

        int x = scan.nextInt();

        if (str.equals("greater"))
        min = Math.max(min, x);
        else if (str.equals("less"))
        {
          infinite = false;
          max = Math.min(max, x);
        }
        else
        divs.add(x);
      }

      if (infinite)
      {
        printed = true;
        System.out.println("infinite");
      }
      else
      {
        for (int i = min + 1; i < max; i++)
        if (div(i , divs))
        {

          System.out.println(i + " ");
          printed = true;
        }

        if (printed)
        System.out.println();
      }

      if (!printed)

      System.out.println("none");
    }

    scan.close();
  }
}
