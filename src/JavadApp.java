import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 * Ulu Tanrýnýn Adi il?
 * Created by IntelliJ IDEA.
 * User: Javad Nouri
 * Date: Jun 11, 2007
 * Time: 12:36:43 AM
 * E-mail: javad.xp@gmail.com
 */

public class JavadApp extends JApplet{
    public void paint(Graphics g){
        super.paint(g);
        ExpressionTree et=new ExpressionTree(JOptionPane.showInputDialog(":"));
        et.drawTree(g,0,0,800,20);
        String x[]=et.PostOrderTrace();
        String y="";
        for(String aX : x)  y+=aX+" ";
        JOptionPane.showMessageDialog(null,y);
        ExpressionStack es=new ExpressionStack(x.length);
        for(String aX:x)    es.push(aX);
        JOptionPane.showMessageDialog(null, es.pop());
    }
}
/*
public class JavadApp extends JFrame{   //This is the test class for the application
    JButton btnClear;           //The button which removes all the items in the list
    JButton btnDraw;            //The button which will draw the Tree on the Frame and will get the sorted sequence
    JTextField txtExpression;       //Input point for the numbers
    JPanel pnl;                 //a Panel
    JTextArea txtSorted;        //Text Area which will present the sorted integers

    Vector<intHolder> x;        //This Vector object holds the data for the nodes

    //Default Constructor:
    JavadApp(){
        super("Binary Search Tree");        //Set the title of the window

        x=new Vector<intHolder>();          //initialize x
        pnl=new JPanel();                   //initialize pnl


        txtSorted=new JTextArea();
        txtSorted.setLocation(0,180);
        txtSorted.setSize(220, 200);
        txtSorted.setText("Click On Draw to draw the Tree\nand see the sorted sequence...");

        txtExpression=new JTextField(5);
        txtExpression.setLocation(120,0);
        txtExpression.setSize(100, 30);

        btnClear = new JButton("Clear");
        btnClear.setLocation(120, 105);
        btnClear.setSize(100, 30);
        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                x.clear();                  //Empty the data list
                lstNumbers.setListData(x);  //update the lstNumbers
                txtExpression.grabFocus();      //Focus on txtExpression
            }
        }
        );

        btnDraw=new JButton("Draw");
        btnDraw.setLocation(120,140);
        btnDraw.setSize(100,30);

        btnDraw.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                Font a=new Font("Tahoma",Font.BOLD,25);
                getGraphics().clearRect(0,0,1024,768);
                getGraphics().setFont(a);
                String expr=JOptionPane.showInputDialog(":");
                ExpressionTree et=new ExpressionTree(expr);
                et.drawTree(getGraphics());
                String x[]=et.PostOrderTrace();
                String y="";
                for (String aX : x) y += aX+ " ";
                JOptionPane.showMessageDialog(null, y);
                ExpressionStack s=new ExpressionStack(x.length);
                for(String aX : x)  s.push(aX);
                JOptionPane.showMessageDialog(null,s.pop());
                //JOptionPane.showMessageDialog(null, s.count);
            }
        }
        );
        //Add the GUI elements
        add(txtExpression);
        add(btnAdd);
        add(btnRemove);
        add(btnClear);
        add(btnDraw);
        add(txtSorted);
        add(pnl);
        pnl.setVisible(false);
        //Maximize the window
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        //Show the window
        setVisible(true);
    }

    //This is the starting point for the application
    public static void main(String[] args) {
        JavadApp app=new JavadApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

*/