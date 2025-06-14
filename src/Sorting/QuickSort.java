package Sorting;

import java.util.Scanner;

//Quick Sort : - Time Complexity : - O(NLogN)
public class QuickSort
{

    public static void quicksort(int arr[],int l,int r)
    {
        if(l<r)
        {
            int pivot = arr[l];
            int i = l;
            int j = r;

            while(i<j)
            {
                i+=1;
                while(i<=r && arr[i]<pivot)
                    i++;
                while(j>=l && arr[j]>pivot)
                    j--;

                if(i<j && i<=r)
                swap(arr,i,j);
            }
            swap(arr,l,j);
            quicksort(arr,l,j-1);
            quicksort(arr,j+1,r);

        }
    }

    public static void swap(int arr[],int l,int r)
    {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
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

        quicksort(arr,0,arr.length-1);

        for(int num:arr)
        {
            System.out.print(num+" ");
        }
    }
}
