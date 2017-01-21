import java.util.*;
import java.io.BufferedInputStream;

public class Addingwords {


  public static void main(String[] args) {
    Scanner reader = new Scanner(new BufferedInputStream(System.in));

    List<Variable> variables = new ArrayList<Variable>();

    while (reader.hasNext()) {
      String input = reader.next();

      if (input.equals("clear")) {
        variables.clear();
        //break;
      } else if (input.equals("def")) {
        String varName = reader.next();
        int varValue = reader.nextInt();
        boolean hasUpdated = false;
        for (int j = 0; j < variables.size(); j++) {
          if (variables.get(j).getName().equals(varName)) {
            Variable var = variables.get(j);
            variables.remove(j);
            var.changeValue(varValue);
            variables.add(j,var);
            hasUpdated = true;
            break;
          }
        }
        if (!hasUpdated) {
          Variable var = new Variable(varName, varValue);
          variables.add(var);
        }

        //System.out.println(variables.get(0).getValue());
      } else if (input.equals("calc")) {
        int totalValue = 0;
        boolean variableNotFound = false;
        String firstVar = reader.next();
        System.out.print(firstVar+" ");
        boolean foundOne = false;
        for (int j = 0; j < variables.size(); j++) {
          if (variables.get(j).getName().equals(firstVar)) {
            totalValue += variables.get(j).getValue();
            foundOne = true;
            break;
          }
        }
        if (!foundOne) {
          //System.out.print("hitta ej");
          variableNotFound = true;
        }
        while (true) {
          String next = reader.next();
          System.out.print(next+" ");
          if (next.equals("+")) {
            foundOne = false;
            String addThis = reader.next();
            System.out.print(addThis+ " ");

            for (int i = 0; i < variables.size(); i++) {
              if (variables.get(i).getName().equals(addThis)) {
                totalValue += variables.get(i).getValue();
                foundOne = true;
                break;
              }
            }
            if (!foundOne) {
              variableNotFound = true;
            }
          } else if (next.equals("-")) {
            String subtractThis = reader.next();
            System.out.print(subtractThis+" ");
            foundOne = false;

            for (int i = 0; i < variables.size(); i++) {
              if (variables.get(i).getName().equals(subtractThis)) {
                totalValue -= variables.get(i).getValue();
                foundOne = true;
                break;
              }
            }
            if (!foundOne) {
              variableNotFound = true;
            }
          } else if(next.equals("=")) {
            //System.out.print(" "+totalValue);
            if (variableNotFound) {
              System.out.print("unknown");
            } else {
              foundOne = false;
              for (int i = 0; i < variables.size(); i++) {
                if (variables.get(i).getValue() == totalValue) {
                  System.out.print(variables.get(i).getName());
                  foundOne = true;
                  break;
                }
              }
              if (!foundOne ) {
                System.out.print("unknown");
              }
            }
            System.out.println();

            break;

          }
        }
      }

    }

  }
}
class Variable {

  public String name;
  public int value;

  Variable(String name, int value) {
    this.name = name;
    this.value = value;
  }

  int getValue(){
    return this.value;
  }
  String getName(){
    return this.name;
  }
  void changeValue(int val) {
    this.value = val;
  }

}
