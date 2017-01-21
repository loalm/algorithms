import java.util.*;

class Ceiling  {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int numberOfStrings = reader.nextInt();
    int stringLength = reader.nextInt();
    int[][] tree = new int[stringLength][(int)Math.pow(2,stringLength-1)];
    for (int i = 0; i < stringLength; i++) {

      int num = reader.nextInt();
      if (i == 0) {
        tree[0][0] = num;
      } else {
        int column = i-1;
        int row = i;
        while ((num < tree[column][row] || tree[column][row] == 0) && column > 0) {
          --row;
          if(row == 0) {
            --column;
            row = stringLength-1;
          }
          System.out.println(column+":"+row);

        }
        tree[column+1][row] = num ;
      }
      for (int o = 0; o<stringLength ; o++) {
          System.out.println(Arrays.toString(tree[o]));
      }
      System.out.println("");
    }

  }
}
