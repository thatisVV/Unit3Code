package ParenCheckLab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Lab3_1_ParenChecker {

  public static void main(String[] args) {
    String[] files = {"ParenCheckLab/data/lab3_1/invalid1.in","ParenCheckLab/data/lab3_1/invalid2.in","ParenCheckLab/data/lab3_1/invalid3.in",
            "ParenCheckLab/data/lab3_1/invalid4.in","ParenCheckLab/data/lab3_1/invalid5.in",
            "ParenCheckLab/data/lab3_1/valid1.in","ParenCheckLab/data/lab3_1/valid2.in"};

    for (String filename: files) {
      System.out.println("\nTesting file: " + filename);
      try {
          checkParens(filename);
        }
      catch (FileNotFoundException ex) {
        System.err.println("File not found");
      }
      catch (Exception ex) {
        System.out.println(ex);
      }
    }
  }

  public static char getOppChar(Character a) throws InputMismatchException{
    if(a == '('){
      return ')';
    }
    else if(a == '{'){
      return '}';
    }
    else if(a == '['){
      return ']';
    }
    else{
      throw new InputMismatchException();
    }
  }
	
  public static void checkParens(String fileName) throws FileNotFoundException {
    Scanner in = new Scanner(new FileReader(fileName));
    ArrayList<Character> openSymbols = new ArrayList<>(Arrays.asList('[', '{', '('));
    ArrayList<Character> closeSymbols = new ArrayList<>(Arrays.asList(']', '}', ')'));

    //
    // Declare any other variables you need here.
    //
    Character c;
    Character c2;
    int lineCount = 0;
    int charPos = 0;

    Stack<Character> stck = new Stack<Character>();

    // Read through the file one line at a time.
    while (in.hasNextLine()) {
      String line = in.nextLine();
      lineCount++;
      charPos = 0;
      // most of your code is here.
      for (int i = 0; i < line.length(); i++){
        charPos++;
        if (openSymbols.contains(line.charAt(i))){
          stck.push(line.charAt(i)); 
        }
        if (closeSymbols.contains(line.charAt(i))){
          if (stck.size() == 0){
            throw new InputMismatchException("On line " + lineCount + " at pos " + charPos + " found " + "\'" + line.charAt(i) + "\'" + ", there is no matching opening symbol.");
          }
          c = stck.pop();
          try{
            c2 = getOppChar(c);
            if (line.charAt(i) != c2){
              throw new InputMismatchException("On line " + lineCount + " at pos " + charPos + " found " + "\'" + line.charAt(i) + "\'" + " expected " + "\'" + getOppChar(c) + "\'.");
            }
          }
          catch (InputMismatchException ex){
              throw new InputMismatchException("On line " + lineCount + " at pos " + charPos + " found " + "\'" + line.charAt(i) + "\'" + " expected " + "\'" + getOppChar(c) + "\'.");
          }
          
        }
      }
    }

    if(stck.size() > 0){
      throw new InputMismatchException("At end of input  -- expecting " + "\'" + getOppChar(stck.pop()) + "\'.");
    }
    System.out.println("The parentheses in the file are valid!");
  }
}