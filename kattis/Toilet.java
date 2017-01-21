import java.util.*;
class Toilet {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    String input = reader.next();
    int adjustments = 0;
    //Policy 1
    char currentPos = input.charAt(0);
    for (int i = 1; i<input.length() ; ++i) {
      char position = input.charAt(i);
      if(position == currentPos) {

      } else {
        ++adjustments;
        currentPos = position;
      }
      if(currentPos == 'D'){
        ++adjustments;
        currentPos = 'U';
      }
    }
    System.out.println(adjustments);
    //Policy 2
    adjustments = 0;
    currentPos = input.charAt(0);
    for (int i = 1; i<input.length() ; ++i) {
      char position = input.charAt(i);
      if(position == currentPos) {

      } else {
        ++adjustments;
        currentPos = position;
      }
      if(currentPos == 'U'){
        ++adjustments;
        currentPos = 'D';
      }
    }
    System.out.println(adjustments);
    // Policy 3
    adjustments = 0;
    currentPos = input.charAt(0);
    for (int i = 1; i<input.length() ; ++i) {
      char position = input.charAt(i);
      if (currentPos != position) {
        currentPos = position;
        ++adjustments;
      }
    }
    System.out.println(adjustments);
  }
}
