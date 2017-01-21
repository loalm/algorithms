import java.util.*;
class Radio  {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int totalCommercials = reader.nextInt();
    int price = reader.nextInt();

    int[] listeners = new int[totalCommercials];

    for (int i = 0; i<totalCommercials; ++i) {
      listeners[i] = reader.nextInt();
    }

    int max_so_far = 0;
    int max_ending_here = 0;
    for (int i = 0; i < listeners.length;i++){
      max_ending_here += listeners[i] - price;
      if (max_ending_here < 0){
        max_ending_here = 0;
      }
      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
      }
    }
    System.out.println(max_so_far);
  }
}
