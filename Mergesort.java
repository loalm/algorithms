import java.util.*;

public class Mergesort {

  public static void main(String[] args) {

    int[] A = {2,9,1,3,7,1};
    Mergesort s = new Mergesort();
    s.topDownMergeSort(A,new int[A.length]);
  }

  void topDownMergeSort(int[] A, int[] B) {
    B = copyArray(A,0,A.length,B);
    topDownSplitMerge(B,0,A.length,A);
  }

  void topDownSplitMerge(int[] B, int iBegin, int iEnd, int[] A) {

    if (iEnd - iBegin < 2) {
      return;
    }
    int iMiddle = (iEnd + iBegin) / 2;

    topDownSplitMerge(A, iBegin, iMiddle, B);
    topDownSplitMerge(A, iMiddle, iEnd, B);
    topDownMerge(B, iBegin, iMiddle, iEnd, A);
  }

  int[] topDownMerge(int[] B, int iBegin, int iMiddle, int iEnd, int[] A) {

    int i = iBegin, j = iMiddle;

    for (int k = iBegin; k < iEnd; k++) {

      if (i < iMiddle && (j >= iEnd || A[i] <= A[j])) {
        B[k] = A[i];
        ++i;
      } else {
        B[k] = A[j];
        ++j;
      }
    }
    System.out.println(Arrays.toString(B));

    return B;
  }

  int[] copyArray(int[] A, int iBegin, int iEnd, int[] B) {
    for(int k = iBegin; k < iEnd; k++) {
      B[k] = A[k];
    }
    return B;
  }

}
