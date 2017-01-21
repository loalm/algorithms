import java.util.*;

class Sidesort  {
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

      String[] columns = new String[stringLength];
      //columns
      for (int i = 0 ; i<stringLength; i++) {
        columns[i] = "";
        for (int j = 0; j<numberOfStrings; j++) {
          columns[i] += words[j].charAt(i);
        }
      }

      Sidesort s = new Sidesort();

      //Insertion sort the columns
      for( int p = 1; p < columns.length; p++ )
      {
        String tmp = columns[ p ];
        int j = p;

        for( ; j > 0 && s.compare(tmp,columns[ j - 1 ]) > 0; j-- )
        columns[ j ] = columns[ j - 1 ];
        columns[ j ] = tmp;
      }

      //back to words
      for (int i = 0 ; i<numberOfStrings; i++) {
        words[i] = "";
        for (int j = 0; j<stringLength; j++) {
          words[i] += columns[j].charAt(i);
        }
      }

      for (int i = 0; i<words.length; i++) {
        total.add(words[i]);
      }

      theEnd = reader.nextInt();
      if(theEnd != 0) {
        total.add("");
      }
    }
    for (int i = 0; i<total.size(); i++) {
      System.out.println(total.get(i));
    }

  }

  public int compare(String one, String two) {
    int i;
    for (i = 0; i < one.length(); i++) {
      double ascii1 = (double)one.charAt(i);
      double ascii2 = (double)two.charAt(i);
      if (ascii1 <= 90 ) {
        ascii1 += 31.5;
      }
      if (ascii2 <= 90 ) {
        ascii2 += 31.5;
      }

      if(ascii1 < ascii2) {
        return 1;
      } else if (ascii1 > ascii2) {
        return -1;
      }
    }
    return 0;
  }

}
