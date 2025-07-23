package Recursion;

import java.util.Scanner;

public class SumofNNumber
{
    public static int fun(int n)
    {
        if(n==0)
        {
            return 0;
        }

        return n + fun(n-1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fun(n));
    }
}
