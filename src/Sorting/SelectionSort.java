package Sorting;
import java.util.*;

// Selection Sort : - Time Complexity = O(N2) NSqaure
public class SelectionSort
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++)
        {
            int minid = i;
            for(int j=i;j<n;j++)
            {
                if(arr[minid]>arr[j])
                {
                    minid = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minid];
            arr[minid] = temp;
        }

        for(int num:arr)
        {
            System.out.print(num+" ");
        }
    }
}
