package postfix;

import java.util.NoSuchElementException;

public class Tokenizer {
    int pos;
    private char[] tokenStr;

    public Tokenizer (String s){
        tokenStr = s.toCharArray();
        pos = 0;
    }

    public boolean hasMoreTokens(){
        skipSpaces();
        return (pos < tokenStr.length);
    }

    private void skipSpaces() {
        while ((pos < tokenStr.length) && Character.isSpaceChar(tokenStr[pos])){
            pos++;
        }
    }

    public Token nextToken() throws InvalidExpressionException{
        skipSpaces();

        if (pos >= tokenStr.length){
            throw new NoSuchElementException("No more elements remaining.");
        }

        if (Character.isDigit(tokenStr[pos])){
            return readNumberToken();
        }
        else{
            return readOperatorToken();
        }
    }

    private OpToken readOperatorToken() throws InvalidExpressionException{
        Character op = tokenStr[pos];
        pos++;

        if (op == '+'){
            return new OpAddToken();
        }
        else if (op == '-'){
            return new OpSubToken();
        }
        else if (op == '*'){
            return new OpMultToken();
        }
        else if (op == '/'){
            return new OpDivToken();
        }
        else{
            throw new InvalidExpressionException("Found " + op + ", expecting an operator at position " + pos + ".");
        }
    }

    private NumberToken readNumberToken() {
        int val = 0;
        while ((pos < tokenStr.length) && Character.isDigit(tokenStr[pos])){
            val = (val*10) + (tokenStr[pos] - '0');
            pos++;
        }

        return new NumberToken(val);
    }
}


