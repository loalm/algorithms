import java.util.*;

public class Average {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int cases = reader.nextInt();
    for (int j = 0; j < cases; j++) {


      int nrOfCs = reader.nextInt();
      int nrOfEc = reader.nextInt();

      double csAvarageIq = 0.0;
      double ecAvarageIq = 0.0;

      int[] csIq = new int[nrOfCs];
      for (int i = 0; i<nrOfCs; i++) {
        int num = reader.nextInt();
        csIq[i] = num;
        csAvarageIq += num;
      }
      csAvarageIq /= nrOfCs;

      for (int i = 0; i<nrOfEc; i++) {
        ecAvarageIq += reader.nextInt();
      }
      ecAvarageIq /= nrOfEc;

      int res = 0;
      for (int i = 0; i<nrOfCs; i++) {
        if (csIq[i] < csAvarageIq && csIq[i] > ecAvarageIq) {
          //System.out.println(csIq[i]);
          ++res;
        }
      }
      System.out.println(res);
    }
  }


}
