package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// It Gives Without Duplicate Values as we are using HashSet
public class PrintSubsequenceEqualToKSumWithoutDuplicate
{
    public static void subsequence(int ind, int n, int arr[], ArrayList<Integer> ls, int k,HashSet<ArrayList<Integer>> set)
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
                set.add(new ArrayList<>(ls));
            }
            return;
        }
        ls.add(arr[ind]);
        subsequence(ind+1,n,arr,ls,k,set);
        ls.remove(ls.size()-1);
        subsequence(ind+1,n,arr,ls,k,set);
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
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        subsequence(0,n,arr,ls,k,set);

        for(ArrayList<Integer> l:set)
        {
            System.out.println(l);
        }
    }
}
