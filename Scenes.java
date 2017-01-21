import java.util.*;

public class Scenes {
  static int ribbonLength, width;
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    ribbonLength = reader.nextInt();
    width = reader.nextInt();
    int height = reader.nextInt();
    Scenes sc = new Scenes();
    System.out.println(sc.numOfCases(ribbonLength,width,height));
    // if (Math.floor(ribbonLength/width) > height) {
    //   System.out.print(sc.numOfCases(ribbonLength,width,height)-height);
    // } else {
    //   System.out.print(sc.numOfCases(ribbonLength,width,height)-(int)Math.floor(ribbonLength/width));
    // }
  }

  static int cases = 0;

  static int[][] mem = new int[ribbonLength][width];

  int numOfCases(int ribbonLength, int width, int height) {
    if (ribbonLength >= width*height) return (int)Math.pow(height+1,width);
    if (ribbonLength == 0) return 1;
    if (width == 1) return 1;

    int res = 0;

    for (int i = 0; i <= ribbonLength/2; i++) {
      res += numOfCases(i,width/2,height) + numOfCases(ribbonLength-i,width/2,height);
      System.out.println(i+":"+(ribbonLength-i));
    }

    return res;
  }
}
