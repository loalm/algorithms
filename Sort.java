import java.util.*;

class Sort  {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int theEnd = reader.nextInt();
    List<String> total = new ArrayList<String>();
    while (theEnd != 0) {
      int numberOfStrings = theEnd;
      int stringLength = reader.nextInt();
      String[] words = new String[numberOfStrings];

      for (int i = 0; i<numberOfStrings; i++) {
        String newWord = reader.next();
        words[i] = newWord;
      }
      Sort s = new Sort();
      s.sort(words,0);
      for (int i = 0; i<words.length; i++) {
        total.add(words[i]);
      }
      theEnd = reader.nextInt();
      if(theEnd != 0) {
        total.add(" ");
      }
    }
    for (int i = 0; i<total.size(); i++) {
      System.out.println(total.get(i));
    }
  }

  void sort(String[] words, int column) {
    boolean isCapital = false;
    outerloop:
    for (int index = 0; index<words[column].length(); index++) {
      int theFirstest = index;
      int currentAscii = (int)words[column].charAt(theFirstest);
      if (currentAscii <= 90) {
        currentAscii += 31.5;
      }
      for (int i = index+1; i<words[column].length(); i++) {
        int ascii = (int)words[column].charAt(i);
        isCapital = false;
        if (ascii <= 90) {
          ascii += 31.5;
        }
        if (currentAscii == ascii) {
          int tempCol = column;
          while (currentAscii == ascii && tempCol+1 < words.length) {
            ++tempCol;
            currentAscii = (int)words[tempCol].charAt(theFirstest);
            ascii = (int)words[tempCol].charAt(i);
          }
          if(currentAscii > ascii) {
            theFirstest = i;
            currentAscii = (int)words[column].charAt(theFirstest);
            break;
            
          }
        } else if (currentAscii > ascii) {
          theFirstest = i;
          currentAscii = (int)words[column].charAt(theFirstest);
        }

      }
      if(theFirstest != index ){
        for (int j = 0; j<words.length; j++) {
          StringBuilder myName = new StringBuilder(words[j]);
          char temp = words[j].charAt(index);
          myName.setCharAt(index, words[j].charAt(theFirstest));
          myName.setCharAt(theFirstest, temp);
          words[j] = myName.toString();
        }
      }
    }
  }
}
