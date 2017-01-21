import java.util.*;

public class Trollhunt {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int numberOfBridges = reader.nextInt();
    int numberOfKnights = reader.nextInt();
    int knightsPerGroup = reader.nextInt();

    System.out.print((int)Math.ceil((numberOfBridges-1) / Math.floor(numberOfKnights/knightsPerGroup)));

  }

}
