package postfix;

import java.util.Scanner;

public class TokenizerDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string of number and operator tokens");
        String line = input.nextLine();

        Tokenizer tk = new Tokenizer(line);

        int sum = 0;
        try{
            while (tk.hasMoreTokens()){
                Token t = tk.nextToken();
                System.out.println("\n\nTOKEN " + t);

                if (t instanceof NumberToken){
                    NumberToken nt = (NumberToken) t;
                    sum += nt.value;
                }            
                else{
                    OpToken ot = (OpToken) t;
                    double result = ot.eval(5, 15);

                    System.out.println("5 " + ot + " 15 = " + result);
                }
            }

            System.out.println("Sum is " + sum);
        }
        catch (InvalidExpressionException ex){
            System.out.println("\nInvalid format: " + ex.getMessage());
        }
    }
}
