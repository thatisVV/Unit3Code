package postfix;

public class OpMultToken extends OpToken {
    public OpMultToken(){
        super('*');
    }

    public double eval(double a, double b){
        return a * b;
    }
    
}
