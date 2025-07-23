package Recursion;

import java.util.Scanner;

public class PrintNto1
{
    public static void fun(int i,int n)
    {
        if(i<1)
        {
            return;
        }
        System.out.println(i);
        fun(i-1,n);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fun(n,n);
    }
}
