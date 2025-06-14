package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST
{
    private Node root;
    class Node
    {
        int value;
        Node left;
        Node right;

        public Node(int value)
        {
            this.value=value;
        }
    }

    public boolean insert(int value)
    {
        Node newNode = new Node(value);
        if(root==null)
        {
            root=newNode;
            return true;
        }

        Node temp = root;
        while(true)
        {
            if(temp.value == newNode.value)
            {
                return false;
            }

            if(temp.value>newNode.value)
            {
                if(temp.left==null)
                {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            else
            {
                if(temp.right==null)
                {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public ArrayList<Integer> BFS()
    {
        Queue<Node> queue=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        Node temp=root;
        queue.add(temp);

        while(!queue.isEmpty())
        {
            Node currentNode = queue.remove();
            ans.add(currentNode.value);

            if(currentNode.left!=null)
            {
                queue.add(currentNode.left);
            }

            if(currentNode.right!=null)
            {
                queue.add(currentNode.right);
            }
        }

        return ans;
    }

    public ArrayList<Integer> PreOrder()
    {
        ArrayList<Integer> ans=new ArrayList<>();
        class Traverse
        {
            Traverse(Node currentNode)
            {
                ans.add(currentNode.value);

                if(currentNode.left!=null)
                {
                    new Traverse(currentNode.left);
                }

                if(currentNode.right!=null)
                {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return ans;
    }
    public ArrayList<Integer> InOrder()
    {
        ArrayList<Integer> ans=new ArrayList<>();
        class Traverse
        {
            Traverse(Node currentNode)
            {

                if(currentNode.left!=null)
                {
                    new Traverse(currentNode.left);
                }
                ans.add(currentNode.value);

                if(currentNode.right!=null)
                {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return ans;
    }
    public ArrayList<Integer> PostOrder()
    {
        ArrayList<Integer> ans=new ArrayList<>();
        class Traverse
        {
            Traverse(Node currentNode)
            {

                if(currentNode.left!=null)
                {
                    new Traverse(currentNode.left);
                }

                if(currentNode.right!=null)
                {
                    new Traverse(currentNode.right);
                }
                ans.add(currentNode.value);
            }
        }

        new Traverse(root);
        return ans;
    }

    public int height()
    {
        return height(root);
    }
    private int height(Node root)
    {
       if(root==null)
           return -1;

       int lh = height(root.left);
       int rh = height(root.right);

       return Math.max(lh,rh)+1;
    }

    public int sumofleaf()
    {
        return sumofleaf(root);
    }
    private int sumofleaf(Node root)
    {
        if(root==null)
            return -1;

        if(root.left==null && root.right==null)
            return root.value;

        return sumofleaf(root.left)+sumofleaf(root.right);
    }

    public boolean isbst()
    {
        return isbst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isbst(Node root,int min,int max)
    {
        if(root==null)
            return true;
        if(root.value<=min || root.value>=max)
            return false;

        return isbst(root.left,min, root.value) && isbst(root.right,root.value, max);
    }

    public boolean issym()
    {
        return issym(root.left,root.right);
    }
    private boolean issym(Node left,Node right)
    {
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;

        if(left.value!=right.value)
            return false;

        return issym(left.left,right.right) && issym(left.right,right.left);
    }
    public boolean balanced()
    {
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.abs(lh-rh)<=1;
    }

    public int diameter()
    {
        int d[] = new int[1];
        diameter(root,d);
        return d[0];
    }
    private int diameter(Node root,int d[])
    {
      if(root==null)
          return 0;
      int lh =  diameter(root.left,d);
      int rh = diameter(root.right,d);
      d[0] = Math.max(d[0],lh+rh);
      return Math.max(lh,rh)+1;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        BST bst=new BST();
        boolean istrue = true;
        while(istrue)
        {
            int a = sc.nextInt();
            if(a==0)
                istrue = false;
            else
                bst.insert(a);
        }

        System.out.println("BFS :- ");
        ArrayList<Integer> ans=bst.BFS();
        for(int num:ans)
            System.out.print(num+" ");

        System.out.println();
        System.out.println("PreOrder :- ");
        ArrayList<Integer> ans2=bst.PreOrder();
        for(int num:ans2)
            System.out.print(num+" ");
        System.out.println();
        System.out.println("InOrder :- ");
        ArrayList<Integer> ans3=bst.InOrder();
        for(int num:ans3)
            System.out.print(num+" ");
        System.out.println();
        System.out.println("PostOrder :- ");
        ArrayList<Integer> ans4=bst.PostOrder();
        for(int num:ans4)
            System.out.print(num+" ");

        System.out.println();
        System.out.println("Height Of The Tree :- "+bst.height());
        System.out.println("Sum Of The Leaf Node :- "+bst.sumofleaf());
        System.out.println("The Tree is Binary :- "+bst.isbst());
        System.out.println("The Tree is Symmetric :- "+bst.issym());
        System.out.println("The Tree is Balanced :- "+bst.balanced());
        System.out.println("The Diameter of the Tree :- "+bst.diameter());


    }
}
