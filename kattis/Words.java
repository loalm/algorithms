import java.util.*;
class Words {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int columns = reader.nextInt();
    int stringLength = reader.nextInt();
    String[] words = new String[columns];

    for (int i = 0; i<columns; i++) {
      String newWord = reader.next();
      words[i] = newWord;
    }

    //insertion sort
    for (int i = 0; i<words[0].length(); i++) {
      int j = i;

      while (j > 0) {
        int ascii1 = (int)words[0].charAt(j-1);
        int ascii2 = (int)words[0].charAt(j-1);
        if (ascii1 <= 90) {
          ascii1 += 32;
        }
        if (ascii2 <= 90) {
          ascii2 += 32;
        }
        //swap
        while (ascii1 > ascii2) {
          words[0] = words[0].substring(0,j);
          System.out.println(words[0]);
          break;
        }
      }
    }
  }
}
