import java.util.*;

public class Quicksort {

  public static void main(String[] args) {

    int[] A = {2,3,1,9,6};
    Quicksort s = new Quicksort();
    System.out.print(Arrays.toString(s.sort(A,0,A.length-1)));
  }
  
  int[] sort(int[] A, int lo, int hi) {
    if (lo < hi) {
      int p = partition(A,lo,hi);
      sort(A,lo,p-1);
      sort(A,p+1,hi);
    }
    return A;
  }

  int partition(int[] A, int lo, int hi) {
    int pivot = A[hi];
    int i = lo;
    for (int j = lo; j < hi; j++) {
      if (A[j] <= pivot) {
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
        ++i;
      }
    }
    int temp = A[i];
    A[i] = A[hi];
    A[hi] = temp;
    return i;
  }


}
