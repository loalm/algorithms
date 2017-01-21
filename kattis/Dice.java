import java.util.*;

public class Dice {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    double averageNum = 0;
    double averageNum1 = 0;

    for (int i = 0; i<2; i++) {
      double a = reader.nextInt();
      double b = reader.nextInt();

      averageNum += (b+a)/(2);
    }
    for (int i = 0; i<2; i++) {
      double a1 = reader.nextInt();
      double b1 = reader.nextInt();

      averageNum1 += (b1+a1)/(2);
    }
    if (averageNum == averageNum1) {
      System.out.println("Tie");
    } else if(averageNum > averageNum1) {
      System.out.println("Gunnar");
    } else {
      System.out.println("Emma");
    }
  }
}
