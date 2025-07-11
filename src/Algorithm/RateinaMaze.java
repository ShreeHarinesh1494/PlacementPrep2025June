package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RateinaMaze
{
    static ArrayList<String> path = new ArrayList<>();

    public static void rec(int x,int y,int n,int m,int arr[][],boolean visited[][],String dir,String ans,int dx[],int dy[])
    {
        if(x==n-1 && y==m-1)
        {
            path.add(ans);
            return;
        }

        for(int i=0;i<4;i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && arr[nx][ny]==1)
            {
                visited[nx][ny]=true;
                rec(nx,ny,n,m,arr,visited,dir,ans+dir.charAt(i),dx,dy);
                visited[nx][ny]=false;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean visited[][] = new boolean[n][m];
        int dx[] = {1, 0, 0, -1};
        int dy[] = {0, -1, 1, 0};
        String ans="";
        String dir = "DLRU";

        if(arr[0][0]==1)
        {
            visited[0][0]=true;
            rec(0,0,n,m,arr,visited,dir,ans,dx,dy);
        }

        if(path.isEmpty())
        {
            System.out.println("No path exists");
        }
        else
        {
            for(String s:path)
            {
                System.out.print(s+" ");
            }
        }
    }
}
