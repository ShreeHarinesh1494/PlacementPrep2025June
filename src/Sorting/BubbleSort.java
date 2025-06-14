package Sorting;

import java.util.Scanner;

// Bubble Sort : - Time Complexity - O(N2)
public class BubbleSort
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n-1;i++)
        {
            for(int j=i;j<n-i-1;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for(int num:arr)
        {
            System.out.print(num+" ");
        }
    }
}
