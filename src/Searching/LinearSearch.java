package Searching;
import java.util.*;
public class LinearSearch
{
    public static int linearsearch(int arr[],int s)
    {
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==s)
            {
                return i;
            }
        }
        return -1;
    }



    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int s = sc.nextInt();
        int ans = linearsearch(arr,s);
        System.out.print(ans);
    }


}
