package Stack;
import java.util.*;

public class Stack
{
    private Node top;
    private int height;

    class Node
    {
        int value;
        Node next;

        public Node(int value)
        {
            this.value=value;
        }
    }

    public Stack()
    {

    }
    public Stack(int value)
    {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack()
    {
        Node temp = top;
        while(temp!=null)
        {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printTop()
    {
        System.out.println("Top of Stack "+top.value);
    }

    public void printHeight()
    {
        System.out.println("Height of Stack "+height);
    }

    public void push(int value)
    {
        Node newNode = new Node(value);
        if(height==0)
        {
            top = newNode;
        }
        else
        {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public int pop()
    {
        if(height==0)
            return -1;
        else
        {
            Node temp = top;
            top = temp.next;
            temp.next = null;
            height--;
            return temp.value;
        }
    }
}

class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Stack st = new Stack();
        boolean istrue = true;

        while(istrue)
        {
            int a  =sc.nextInt();
            if(a==0)
            {
                istrue = false;
            }
            else
            {
                st.push(a);
            }
        }

        st.printStack();
        st.printHeight();
        st.printTop();

        System.out.println();
        System.out.println(st.pop());
        st.printTop();
        st.printStack();
        st.printHeight();

    }
}
