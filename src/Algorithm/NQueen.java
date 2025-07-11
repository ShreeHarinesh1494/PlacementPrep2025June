package Algorithm;

import java.util.Scanner;

public class NQueen
{
    static int n;


    public static void printboard(int board[][],int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean issafe(int board[][],int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            if(board[i][col]==1)
            {
                return false;
            }


        }
        for(int i=row,j=col;i>=0 && j>=0 ;i--,j--)
        {
            if(board[i][j]==1)
            {
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j<n ;i--,j++)
        {
            if(board[i][j]==1)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean solve(int board[][],int row)
    {
        if(row>=n)
        {
            return true;
        }

        for(int col=0;col<n;col++)
        {
            if(issafe(board,row,col))
            {
                board[row][col]=1;

                if(solve(board,row+1))
                {
                    return true;
                }
                board[row][col]=0;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int board[][] = new int[n][n];

        if(solve(board,0))
        {
            printboard(board,n);
        }
        else
        {
            System.out.println("No Solution Exists");
        }
    }
}
