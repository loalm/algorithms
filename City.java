import java.util.*;

public class City {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int num = reader.nextInt();;
    int[] res = new int[num];
    for (int x = 0; x<num; x++) {

      int number = reader.nextInt();

      List<String> results = new ArrayList<String>();
      for (int i = 0; i<=number; i++) {
        boolean notFound = true;
        String city = reader.nextLine();
        for (int j = 0; j < results.size(); j++) {
          if (results.get(j).equals(city)) {
            notFound = false;
            break;
          }
        }
        if (notFound) {
          results.add(city);
        }
      }
      res[x] = results.size()-1;
    }
    for (int y = 0; y<res.length; y++) {
      System.out.println(res[y]);
    }
  }
}
