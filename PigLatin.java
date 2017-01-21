import java.util.*;
import java.io.BufferedInputStream;

public class PigLatin {
  public static void main(String[] args) {
    Scanner reader = new Scanner(new BufferedInputStream(System.in));

    while(reader.hasNext()) {
      String nextLine = reader.nextLine();
      String[] words = nextLine.split(" ");
      nextLine =
      
      for (int j = 0; j < words.length ; j++) {
        String firstChar = ""+words[j].charAt(0);
        String firstVowel = "";
        if(isVowel(firstChar)){
          words[j] += "yay";
        } else {
          for (int i = 0; i < words[j].length(); i++) {
            firstVowel = ""+words[j].charAt(i);
            if(isVowel(firstVowel)){
              //Found first vowel
              String temp = words[j].substring(0,i);
              words[j] = words[j].substring(i);
              words[j] += temp;
              words[j] += "ay";
              break;
            }
          }

        }
        System.out.print(words[j]);
        if(j+1 < words.length) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }

  }

  public static boolean isVowel(String c){
    String vowels = "aeiou";
    return vowels.contains(c);
  }
}
