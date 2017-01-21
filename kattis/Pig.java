import java.util.*;

public class Pig {
  public static void main(String[] args) {

    Scanner reader = new Scanner(System.in);
    String word = reader.next();
    while (word != null && word != "") {


      String firstChar = ""+word.charAt(0);
      String firstVowel = "";
      if(isVowel(firstChar)){
        word += "yay";
      } else {
        for (int i = 0; i < word.length(); i++) {
          firstVowel = ""+word.charAt(i);
          if(isVowel(firstVowel)){
            //Found first vowel
            String temp = word.substring(0,i);
            word = word.substring(i);
            word += temp;
            word += "ay";
            break;
          }
        }
      }
      System.out.print(word+ " ");
      word = reader.next();

    }
  }

  public static boolean isVowel(String c){
    String vowels = "aeiou";
    return vowels.contains(c);
  }
}
