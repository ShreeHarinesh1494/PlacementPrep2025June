package SingleLinkedList;

import org.w3c.dom.Node;

import java.util.Scanner;

public class SingleLinkedList
{
    private Node head;
    private Node tail;
    private int size;

    class Node
    {
        int value;
        Node next;

        Node(int value)
        {
            this.value = value;
        }
    }

    public void printList()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printHead()
    {
        System.out.println("Head : "+head.value);
    }

    public void printTail()
    {
        System.out.println("Tail : "+tail.value);
    }

    public void printSize()
    {
        System.out.println("Size : "+size);
    }
    public void append(int value)
    {
        Node newNode = new Node(value);
        if(size==0)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void prepend(int value)
    {
        Node  newNode = new Node(value);
        if(size==0)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public Node removeLast()
    {
        Node temp = head;
        Node pre = head;

        if(head==null)
            return null;

        while(temp.next!=null)
        {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        size--;

        if(size==0)
        {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node removeFirst()
    {
        Node temp = head;
        if(size==0)
        {
            return null;
        }

        head = temp.next;
        temp.next = null;
        size--;
        if(size==0)
        {
            tail = null;
        }
        return temp;
    }

    public Node getValue(int index)
    {
        Node temp = head;
        if(index<0 || index>=size)
            return null;
        for(int i=0;i<index;i++)
        {
            temp = temp.next;
        }

        return temp;
    }

    public boolean setValue(int index, int value)
    {
        Node temp = getValue(index);
        if(temp!=null)
        {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value)
    {
        if(index<0 || index>=size)
            return false;

        if(index==0)
        {
            prepend(value);
            return true;
        }
        if(index==size)
        {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = getValue(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        return true;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        SingleLinkedList list = new SingleLinkedList();
        boolean istrue = true;
        while(istrue)
        {
            int a = sc.nextInt();
            if(a==0)
                istrue = false;
            else
                list.append(a);
        }
        list.printList();
        list.printHead();
        list.printTail();
        list.printSize();

        int b = sc.nextInt();
        list.prepend(b);
        list.printList();
        list.printHead();
        list.printTail();
        list.printSize();

        System.out.println("Removed Last Element : "+list.removeLast().value);
        list.printList();
        list.printHead();
        list.printTail();
        list.printSize();

        System.out.println("Removed First Element : "+list.removeFirst().value);
        list.printList();
        list.printHead();
        list.printTail();
        list.printSize();

        int c = sc.nextInt();
        System.out.println("Value of the index : "+list.getValue(c).value);

        int d = sc.nextInt();
        System.out.println("Setting the Value : "+list.setValue(c,d));
        list.printList();
        list.printHead();
        list.printTail();
        list.printSize();

        int e = sc.nextInt();
        int f = sc.nextInt();
        list.insert(e,f);
        list.printList();
        list.printHead();
        list.printTail();
        list.printSize();
    }
}
