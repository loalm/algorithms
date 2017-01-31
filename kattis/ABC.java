import java.util.*;

public class ABC {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int[] A = new int[3];


    for (int i = 0;i<3 ; i++ ) {
      A[i] = reader.nextInt();
    }
    reader.nextLine();

    Arrays.sort(A);

    String a = reader.nextLine();

    for (int i = 0;i<3 ; i++) {
      if (a.charAt(i) == 'A') {
        System.out.print(A[0]);
      } else if(a.charAt(i) == 'B') {
        System.out.print(A[1]);
      } else {
        System.out.print(A[2]);
      }
      System.out.print(" ");
    }


  }
}
