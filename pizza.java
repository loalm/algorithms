import java.util.*;

class pizza  {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int r = reader.nextInt();
    int c = reader.nextInt();

    double area = r*r*Math.PI;
    double cheeseArea = (r-c)*(r-c)*Math.PI;
    System.out.println(100*(cheeseArea/area));
  }
}
