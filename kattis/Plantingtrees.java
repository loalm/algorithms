import java.util.*;

public class Plantingtrees {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int days = reader.nextInt();
    Integer[] arr = new Integer[days];
    int max = -1;

    for (int i = 0; i< days; i++) {
      arr[i] = reader.nextInt();
    }

    Arrays.sort(arr, Collections.reverseOrder());

    // System.out.print(Arrays.toString(arr));

    for (int i = 1; i<= days; i++) {
      max = arr[i-1] +i < max ? max : arr[i-1]+i;
    }

    System.out.print(max+1);
  }


}
