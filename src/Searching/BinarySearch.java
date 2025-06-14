package Searching;
import java.util.*;
public class BinarySearch
{
    public static int binarysearch(int[] arr, int s)
    {
        int n = arr.length;
        int low =0,high =n-1;

        while(low<=high)
        {
            int mid = (low+high)/2;

            if(arr[mid]==s)
            {
                return mid;
            }
            else if(arr[mid]>s)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int s = sc.nextInt();

        int ans = binarysearch(arr,s);
        System.out.print(ans);
    }

}
