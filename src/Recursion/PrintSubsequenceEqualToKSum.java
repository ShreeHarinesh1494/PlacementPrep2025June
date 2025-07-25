package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

// It Gives Duplicate Values I mean Repetion of values
public class PrintSubsequenceEqualToKSum
{
    public static void subsequence(int ind, int n, int arr[], ArrayList<Integer> ls, int k)
    {
        if(ind>=n)
        {
            int sum = 0;
            for(int i=0;i<ls.size();i++)
            {
                sum+=ls.get(i);
            }
            if(sum==k)
            {
                System.out.println(ls);
            }
            return;
        }
        ls.add(arr[ind]);
        subsequence(ind+1,n,arr,ls,k);
        ls.remove(ls.size()-1);
        subsequence(ind+1,n,arr,ls,k);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        ArrayList<Integer> ls = new  ArrayList<>();
        subsequence(0,n,arr,ls,k);
    }
}
