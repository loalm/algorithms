import java.util.*;
class Vauvau  {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int dogRage1 = reader.nextInt();
    int dogRest1 = reader.nextInt();
    int dogRage2 = reader.nextInt();
    int dogRest2 = reader.nextInt();

    for (int i = 0; i<3; ++i) {

      int person = reader.nextInt();

      int currentMinute = 0;
      int activeDogs = 0;
      while (currentMinute < person) {
        if (person <= currentMinute+dogRage1) {
          ++activeDogs;
        }
        currentMinute += dogRage1+dogRest1;
      }
      currentMinute = 0;
      while (currentMinute < person) {
        if (person <= currentMinute+dogRage2) {
          ++activeDogs;
        }
        currentMinute += dogRage2+dogRest2;
      }
      if(activeDogs == 2) {
        System.out.println("both");
      } else if (activeDogs == 1) {
        System.out.println("one");
      } else {
        System.out.println("none");

      }
    }
  }




}
