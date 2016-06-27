/**
 * Ulu Tanrýnýn Adi il?
 * Created by IntelliJ IDEA.
 * User: Javad Nouri
 * Date: Jun 11, 2007
 * Time: 12:32:07 AM
 * E-mail: javad.xp@gmail.com
 */

//import commands:

//This is the heart of our application:
public class ExpressionTree extends BinaryTree{
    private String expression;
    ExpressionTree(){}        //Default constructor
    ExpressionTree(String expr){
        setExpression(expr);
    }
    public void setExpression(String expr){
        expression=expr;

        root=createExpressionTree(root, expression);
    }
    public String getExpression(){
        return expression;
    }

    private BinaryNode createExpressionTree(BinaryNode node, String exp){
        String expr=noParanth(exp);
        int gp=givePoint(expr);
        if(gp<0){
            node=new BinaryNode(expr);
            return node;
        }
        node=new BinaryNode(Character.toString(expr.charAt(gp)));
        node.left = createExpressionTree(node.left, expr.substring(0,gp));
        node.right = createExpressionTree(node.right, expr.substring(gp+1));
        return node;
    }
    private String noParanth(String exp){
        String expr=exp;
        while(expr.charAt(0)=='(' && expr.charAt(expr.length()-1)==')'){
            int ParCon=0;
            for(int i=1; i<expr.length()-1 ; i++){
                char chrAt=expr.charAt(i);
                if(chrAt=='(')  ParCon++;
                if(chrAt==')')  ParCon--;
                if(ParCon<0)   return expr;
            }
            expr=expr.substring(1,expr.length()-1);
        }
        return expr;
    }
    private int givePoint(String expr){
        int ParanthCount=0;
        int MDLoc=-1,PwLoc=-1;
        for(int i=expr.length()-1 ; i>=0 ; i--){
            char chrAt=expr.charAt(i);
            if(chrAt==')') ParanthCount++;
            if(chrAt=='(') ParanthCount--;
            if(ParanthCount==0){
                if(chrAt=='+' || chrAt=='-')   return i;
                if(MDLoc<0 && (chrAt=='*' || chrAt=='/'))   MDLoc=i;
                if(chrAt=='^')   PwLoc=i;
            }
        }
        return (MDLoc<0 ? PwLoc : MDLoc);
    }
}

