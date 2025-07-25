package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintSubsequence
{
    public static void subsequence(int ind,int n,int arr[],ArrayList<Integer> ls)
    {
        if(ind>=n)
        {
            System.out.println(ls);
            return;
        }
        ls.add(arr[ind]);
        subsequence(ind+1,n,arr,ls);
        ls.remove(ls.size()-1);
        subsequence(ind+1,n,arr,ls);
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
        ArrayList<Integer> ls = new  ArrayList<>();
        subsequence(0,n,arr,ls);
    }
}
