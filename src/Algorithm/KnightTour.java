package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class KnightTour
{
    static int n;
    static int chess[][];
    static int dx[] = {2,1,-1,-2,-2,-1,1,2};
    static int dy[] = {1,2,2,1,-1,-2,-2,-1};


    public static boolean issafe(int x,int y)
    {
        return x>=0 && y>=0 && x<n && y<n && chess[x][y]==-1;
    }
    public static boolean solve(int x,int y,int cnt)
    {
        if(cnt == n*n)
        {
            return true;
        }

        for(int i=0;i<8;i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(issafe(nx,ny))
            {
                chess[nx][ny] = cnt;

                if(solve(nx,ny,cnt+1))
                {
                    return true;
                }
                else
                {
                    chess[nx][ny] = -1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        chess = new int[n][n];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(chess[i],-1);
        }

        chess[0][0] = 0;

        if(solve(0,0,1))
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(chess[i][j]+" ");
                }
                System.out.println();
            }
        }
        else
        {
            System.out.println("No Solution Exists");
        }
    }
}
