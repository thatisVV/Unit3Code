package postfix;

public class OpAddToken extends OpToken {
    public OpAddToken(){
        super('+');
    }

    public double eval(double a, double b){
        return a + b;
    }
}
