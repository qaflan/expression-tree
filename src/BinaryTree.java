import java.awt.*;

/**
 * Ulu Tanrýnýn Adi il?
 * Created by IntelliJ IDEA.
 * User: Javad Nouri
 * Date: Jun 11, 2007
 * Time: 12:51:28 AM
 * E-mail: javad.xp@gmail.com
 */
public class BinaryTree {
    protected BinaryNode root;       //The root node of the tree
    public int size(){          //returns the number of nodes in the tree
        return sizeOfSubTree(root); //uses the private recursive function sizeOfSubTree
    }
    private int sizeOfSubTree(BinaryNode node){
        //Recursion is very helpful here, in most methods for binary trees I have used a recursive solution
        if(node==null)  return 0;       //Base Case: an empty tree has size 0
        return sizeOfSubTree(node.left)+1+sizeOfSubTree(node.right);    //otherwise calculate the size of its childs and                                                                     //return the result+1 (1 for thr current node to be counted;
    }
    public int maxDepth(){          //Returns the number of nodes along the longest path from the root to the leaves
        return depthOfSubTree(root);    //This also uses a recursive helper method
    }
    private int depthOfSubTree(BinaryNode Node){
        //yenid?n Recursion
        if(Node==null)  return 0;       //Base case: the depth of anempty tree is 0
        else{
            int lDepth,rDepth;
            lDepth=depthOfSubTree(Node.left);   //the maximum depth along the left child
            rDepth=depthOfSubTree(Node.right);  //the maximum depth along the right child
            return (rDepth>lDepth ? rDepth+1 : lDepth+1);   //return the maximum of lDepth and rDepth +1 (again 1 for the sake of current node
        }
    }
    public String[] InOrderTrace(){        //Trace the tree using Inorder trace method(Depth First Search, Left , Self , Right)
        String temp[]=new String[this.size()];    //create a new int array of size this.size();
        intHolder count=new intHolder();    //Create a counter of type intHolder, this reference is used in the next method
                                            //  to locate where the visited node is going to be saved in the array
        LSR(root, temp, count);             //Use the recursive function LSR to trace the tree starting rom node LSR: Left Self Right
        return temp;                        //Return a reference to the array of results
    }
    private void LSR(BinaryNode Node, String theArray[],intHolder count){
        if(Node==null)  return;             //if the node is null then the Tracing is over
        LSR(Node.left, theArray, count);    //else trace the left subtree
        theArray[count.Addpp()]=Node.data;  //visit the current node and increase count one unit
        LSR(Node.right, theArray, count);   //Trace the right subtree
    }
    public String[] PreOrderTrace(){        //Trace the tree using Preorder trace method(Depth First Search, Left , Self , Right)
        String temp[]=new String[this.size()];    //create a new int array of size this.size();
        intHolder count=new intHolder();    //Create a counter of type intHolder, this reference is used in the next method
                                            //  to locate where the visited node is going to be saved in the array
        SLR(root, temp, count);             //Use the recursive function LSR to trace the tree starting rom node LSR: Left Self Right
        return temp;                        //Return a reference to the array of results
    }
    private void SLR(BinaryNode Node, String theArray[],intHolder count){
        if(Node==null)  return;             //if the node is null then the Tracing is over
        theArray[count.Addpp()]=Node.data;  //visit the current node and increase count one unit
        SLR(Node.left, theArray, count);    //else trace the left subtree
        SLR(Node.right, theArray, count);   //Trace the right subtree
    }


    public String[] PostOrderTrace(){        //Trace the tree using Preorder trace method(Depth First Search, Left , Self , Right)
        String temp[]=new String[this.size()];    //create a new int array of size this.size();
        intHolder count=new intHolder();    //Create a counter of type intHolder, this reference is used in the next method
                                            //  to locate where the visited node is going to be saved in the array
        LRS(root, temp, count);             //Use the recursive function LSR to trace the tree starting rom node LSR: Left Self Right
        return temp;                        //Return a reference to the array of results
    }
    private void LRS(BinaryNode Node, String theArray[],intHolder count){
        if(Node==null)  return;             //if the node is null then the Tracing is over
        LRS(Node.left, theArray, count);    //else trace the left subtree
        LRS(Node.right, theArray, count);   //Trace the right subtree
        theArray[count.Addpp()]=Node.data;  //visit the current node and increase count one unit
    }



    public void drawTree(Graphics g, int x1, int y1, int x2, int y2 )
    {
        //This method also uses a recursive helper method
        draw(g, root,x1,y1,x2, y2);
    }
    public void drawTree(Graphics g)        //Ovwerloaded method
    {
        drawTree(g ,0,40,800, 20);
    }
    private void draw(Graphics g,BinaryNode Node,int x1,int y1,int x2,int y2){
        //This function draws each node recursively, I'll fully explain it in the pdf file
        //and I'll also tell you about the way I calculate the location for the nodes
        if(Node==null) return;  //Base case: if Node is null, the drawing process is over

        //These parts will be explained later
        int c=700/this.maxDepth();
        g.setColor(new Color(0,0,0));
        if(Node.left!=null) g.drawLine((x1+x2)/2,(root==Node ?  50 : y2),(x2+3*x1)/4, y2+c);
        if(Node.right!=null) g.drawLine((x1+x2)/2,(root==Node ?  50 : y2),(3*x2+x1)/4, y2+c);
        g.setColor(new Color(0,0,255));
        g.drawString(Node.data, (x1+x2)/2,(root==Node ?  50 : y2));
        draw(g,Node.left,x1,y1, (x2+x1)/2,y2+c);
        draw(g, Node.right, (x2+x1)/2, y1, x2, y2+c);

    }

}
