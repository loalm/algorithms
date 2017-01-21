import java.util.*;
class Vertex  {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int input = reader.nextInt();
    Vertex v = new Vertex();
    if (input == 3) {
      System.out.println(0);
    } else {
      System.out.println(v.choose(input,4));
    }
  }

  int choose(int n, int k) {
    if (k == 0) {
      return 1;
    }
    return (n * choose(n-1,k-1)) / k;
  }
}
