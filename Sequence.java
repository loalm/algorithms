import java.util.*;

class Sequence {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int numberOfSequences = reader.nextInt();
    String[] answers = new String[numberOfSequences];
    for (int u = 0; u<numberOfSequences; ++u) {

      int sequenceLength = reader.nextInt();
      int[] sequence = new int[sequenceLength];
      boolean isArithmetic = true;
      boolean isPermutableArithmetic = true;

      for (int i = 0; i < sequenceLength; ++i) {
        sequence[i] = reader.nextInt();
      }
      int difference = sequence[0]-sequence[1];
      for (int i = 0; i < sequenceLength-1; ++i) {
        if (sequence[i]-sequence[i+1] != difference) {
          Arrays.sort(sequence);
          difference = sequence[0]-sequence[1];
          isArithmetic = false;
          break;
        }
      }
      if (!isArithmetic) {
        for (int i = 0; i < sequenceLength-1; ++i) {
          if (sequence[i]-sequence[i+1] != difference) {
            isPermutableArithmetic = false;
            break;
          }
        }
      }
      if (isArithmetic) {
        answers[u] = "arithmetic";
      } else if (isPermutableArithmetic) {
        answers[u] = "permuted arithmetic";
      } else {
        answers[u] = "non-arithmetic";
      }
    }
    for (int u = 0; u<numberOfSequences; ++u) {
      System.out.println(answers[u]);
    }
  }
}
