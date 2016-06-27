import javax.swing.*;

/**
 * Ulu Tanrýnýn Adi il?
 * Created by IntelliJ IDEA.
 * User: Javad Nouri
 * Date: Jun 12, 2007
 * Time: 12:59:53 AM
 * E-mail: javad.xp@gmail.com
 */
public class ExpressionStack {
    private String stack[];
    public int count;
    ExpressionStack(){
        this(10);
    }
    ExpressionStack(int size){
        stack=new String[size];
        count = 0;
    }
    public void push(String x){
        if (isOperator(x)){
            String v1=pop();
            String v2=pop();
            stack[count++]=Double.toString(calculate(v1,v2,x));
        }
        else {
            stack[count++] = x;
        }
    }
    public String pop(){
        return stack[--count];
    }
    private boolean isOperator(String x){
        return x.length() == 1 && (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("^"));
    }
    private double calculate(String var1, String var2, String op){
        double v1=Double.parseDouble(var1);
        double v2=Double.parseDouble(var2);
        switch(op.charAt(0)){
            case '+':
                return v2+v1;
            case '-':
                return v2-v1;
            case '*':
                return v2*v1;
            case '/':
                return v2/v1;
            case '^':
                return Math.pow(v2,v1);
        }
        return 0;
    }
}
