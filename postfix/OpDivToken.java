package postfix;

public class OpDivToken extends OpToken {
    public OpDivToken(){
        super('/');
    }

    public double eval(double a, double b){
        return a / b;
    }
    
}
