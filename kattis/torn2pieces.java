//https://open.kattis.com/problems/torn2pieces
import java.util.*;

public class torn2pieces {

  static HashMap<String, HashSet<String>> set;

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int N = Integer.parseInt(reader.nextLine());

    set = new HashMap<String, HashSet<String>>();

    while (N-- > 0) {
      String line = reader.nextLine();
      String[] stations = line.split(" ");

      for (String s : stations) {
        if (!set.containsKey(s)) {
          set.put(s, new HashSet<String>());
        }
      }
      String station = stations[0];

      for (int i = 1; i<stations.length; i++) {
        set.get(station).add(stations[i]);
        set.get(stations[i]).add(station);
      }
    }

    start = reader.next();
    end = reader.next();

    torn2pieces t = new torn2pieces();
    t.findWay(start,""+start);
    if (!foundWay) {
      System.out.println("no route found");
    }
  }
  static String start, end;
  HashSet<String> hasVisited = new HashSet<String>();
  static boolean foundWay = false;

  void findWay(String currentStation, String str) {
    if (currentStation.equals(end)) {
      //Found way
      System.out.println(str);
      foundWay = true;
      return;
    }
    hasVisited.add(currentStation);
    try {
      for (String entry : set.get(currentStation)) {
        if (!hasVisited.contains(entry) ) {
          findWay(entry,str+" "+entry);
        }
      }
    } catch (Exception e) {
      foundWay = false;
    }
  }


}
