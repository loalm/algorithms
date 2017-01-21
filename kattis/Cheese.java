import java.util.*;

public class Cheese {
  public static double totalCheeseWeight;
  public static int numberOfHoles;
  public static int numberOfSlices;
  // List to store hole positions
  public static List<int[]> holes = new ArrayList<int[]>();

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    totalCheeseWeight = 100*100*100;
    numberOfHoles = reader.nextInt();
    numberOfSlices = reader.nextInt();
    //Ordered list with z index of all slices
    List<Double> slices = new ArrayList<Double>();

    //Get the position and size of each hole and put them in the list
    //Also remove hole weight from total weight.
    for (int i = 0; i < numberOfHoles; i++) {
      int radius = reader.nextInt()/1000;
      int x = reader.nextInt()/1000;
      int y = reader.nextInt()/1000;
      int z = reader.nextInt()/1000;

      int[] hole = {radius,x,y,z};
      holes.add(hole);
      totalCheeseWeight -= 4*Math.PI*radius*radius*radius/3;
    }

    System.out.println("totalCheeseWeight: "+totalCheeseWeight);
    Cheese s = new Cheese();

    s.findThickness(slices);
  }

  void findThickness(List slices) {
    double startingIndex = 0;
    if(slices.size() != 0) {
      startingIndex = (double)slices.get(slices.size()-1);
    }

    double z = totalCheeseWeight/(numberOfSlices*100*100) + startingIndex;
    double sliceWeight = 100*100*z;
    //Is there a hole in the slice?
    for (int i = 0; i < numberOfHoles; i++) {
      double radius = holes.get(i)[0];
      double zHole = holes.get(i)[3];
      if (startingIndex < zHole && zHole < z) {
        System.out.println("Found hole");
        //Hole found in slice index
        sliceWeight -= 4*Math.PI*radius*radius*radius/3;
      } else if (startingIndex < zHole + radius && zHole - radius < z) {
        //Part of hole found in slice index
        System.out.println("Found part of hole");
        sliceWeight -= 4*Math.PI*radius*radius*(z-zHole+radius)/3;
      }
    }
    System.out.println("sliceWeight: "+sliceWeight);
    System.out.println("z: "+z);
    slices.add(z);
  }

}
