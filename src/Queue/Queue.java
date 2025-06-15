package Queue;

import java.util.Scanner;

public class Queue
{
    private Node first;
    private Node last;
    private int height;

    class Node
    {
        int value;
        Node next;

        Node(int value)
        {
            this.value = value;
        }
    }

    public void printQueue()
    {
        Node temp = first;
        while(temp!=null)
        {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void printFirst()
    {
        System.out.print("First : "+first.value);
    }

    public void printLast()
    {
        System.out.print("Last : "+last.value);
    }

    public void printHeight()
    {
        System.out.println("Height : "+height);
    }

    public void Enqueue(int value)
    {
        Node newNode = new Node(value);
        if(height==0)
        {
            first = newNode;
            last = newNode;
        }
        else
        {
            last.next = newNode;
            last = newNode;
        }
        height++;
    }

    public Node  Dequeue()
    {
        Node temp = first;
        if(height==0)
            return null;
        else if(height==1)
        {
            first = null;
            last = null;
        }
        else
        {
            first = temp.next;
            temp.next = null;
        }
        height--;
        return temp;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Queue q = new Queue();
        Scanner sc = new Scanner(System.in);
        boolean istrue = true;
        while(istrue)
        {
            int a = sc.nextInt();
            if(a==0)
                istrue = false;
            else
                q.Enqueue(a);
        }

        q.printQueue();
        System.out.println();
        q.printFirst();
        System.out.println();
        q.printLast();
        System.out.println();
        q.printHeight();
        System.out.println();

        System.out.println("Dequed Element from the Queue : "+q.Dequeue().value);
        q.printQueue();
        System.out.println();
        q.printFirst();
        System.out.println();
        q.printLast();
        System.out.println();
        q.printHeight();
    }
}
