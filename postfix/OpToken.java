package postfix;

public abstract class OpToken extends Token{
    public final char operator;

    public OpToken(char op){
        operator = op;
    }

    public abstract double eval(double a, double b);

    public String toString(){
        return "" + operator;
    }
}
