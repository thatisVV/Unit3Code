package postfix;

public class OpSubToken extends OpToken {
    public OpSubToken(){
        super('-');
    }

    public double eval(double a, double b){
        return a - b;
    }
    
}
