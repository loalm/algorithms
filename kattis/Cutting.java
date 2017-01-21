//Kattis problem ID: cuttingcorners
import java.util.*;

public class Cutting {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int numberOfCorners = reader.nextInt();
    while (numberOfCorners != 0) {


      List<int[]> corners = new ArrayList<int[]>();

      for (int i = 0; i<numberOfCorners; i++) {
        int x = reader.nextInt();
        int y = reader.nextInt();
        int[] point = {x,y};
        corners.add(point);
      }
      Cutting c = new Cutting();

      c.removeSharpestCorner(corners);


      numberOfCorners = reader.nextInt();
    }
  }

  void removeSharpestCorner(List<int[]> corners) {

    double sharpestAngle = 180;
    double sharpestCorner = 0;

    int[] v1 = new int[2];
    int[] v2 = new int[2];
    for (int i = 0; i < corners.size(); i++) {

      if (corners.size()-1 >= i+1 && i-1 >= 0) {
        v1[0] = corners.get(i)[0]-corners.get(i+1)[0];
        v1[1] = corners.get(i)[1]-corners.get(i+1)[1];
        v2[0] = corners.get(i)[0]-corners.get(i-1)[0];
        v2[1] = corners.get(i)[1]-corners.get(i-1)[1];
      } else if(i-1 >= 0){
        v1[0] = corners.get(i)[0]-corners.get(0)[0];
        v1[1] = corners.get(i)[1]-corners.get(0)[1];
        v2[0] = corners.get(i)[0]-corners.get(i-1)[0];
        v2[1] = corners.get(i)[1]-corners.get(i-1)[1];
      } else {
        v1[0] = corners.get(i)[0]-corners.get(i+1)[0];
        v1[1] = corners.get(i)[1]-corners.get(i+1)[1];
        v2[0] = corners.get(i)[0]-corners.get(corners.size()-1)[0];
        v2[1] = corners.get(i)[1]-corners.get(corners.size()-1)[1];
      }

      double angle = Math.toDegrees(Math.acos((v1[0]*v2[0]+v1[1]*v2[1]) /
      (Math.sqrt(v1[0]*v1[0]+v1[1]*v1[1])*Math.sqrt(v2[0]*v2[0]+v2[1]*v2[1]))));

      if(angle < sharpestAngle) {
        sharpestAngle = angle;
        sharpestCorner = i;
      }
    }

    double sharpestAngle2 = 180;
    List<int[]> corners2 = new ArrayList<int[]>();
    for (int j = 0; j < corners.size(); j++) {
      corners2.add(corners.get(j));
    }
    //System.out.println(corners.size());
    corners2.remove((int)sharpestCorner);
    //System.out.println(corners2.size()+":"+corners.size());
    for (int i = 0; i < corners2.size(); i++) {

      if (corners2.size()-1 >= i+1 && i-1 >= 0) {
        v1[0] = corners2.get(i)[0]-corners2.get(i+1)[0];
        v1[1] = corners2.get(i)[1]-corners2.get(i+1)[1];
        v2[0] = corners2.get(i)[0]-corners2.get(i-1)[0];
        v2[1] = corners2.get(i)[1]-corners2.get(i-1)[1];
      } else if(i-1 >= 0){
        v1[0] = corners2.get(i)[0]-corners2.get(0)[0];
        v1[1] = corners2.get(i)[1]-corners2.get(0)[1];
        v2[0] = corners2.get(i)[0]-corners2.get(i-1)[0];
        v2[1] = corners2.get(i)[1]-corners2.get(i-1)[1];
      } else {
        v1[0] = corners2.get(i)[0]-corners2.get(i+1)[0];
        v1[1] = corners2.get(i)[1]-corners2.get(i+1)[1];
        v2[0] = corners2.get(i)[0]-corners2.get(corners2.size()-1)[0];
        v2[1] = corners2.get(i)[1]-corners2.get(corners2.size()-1)[1];
      }

      double angle = Math.toDegrees(Math.acos((v1[0]*v2[0]+v1[1]*v2[1]) /
      (Math.sqrt(v1[0]*v1[0]+v1[1]*v1[1])*Math.sqrt(v2[0]*v2[0]+v2[1]*v2[1]))));

      if(angle < sharpestAngle2) {
        sharpestAngle2 = angle;
      }
    }
    //System.out.println(sharpestAngle2+":"+sharpestAngle);
    if (sharpestAngle2 > sharpestAngle && corners.size() > 3) {
      //System.out.println("hej");
      corners.remove(sharpestCorner);
      removeSharpestCorner(corners2);
    } else {
      System.out.println();
      System.out.print(corners.size()+" ");
      for (int i = 0; i<corners.size(); i++) {
        int xfinal = corners.get(i)[0];
        int yfinal = corners.get(i)[1];
        System.out.print(xfinal + " " + yfinal + " ");
      }
    }
  }

}
