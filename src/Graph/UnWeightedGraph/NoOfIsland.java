package Graph.UnWeightedGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NoOfIsland
{
    public static void BFS(char arr[][],boolean visited[][],int n,int m,int i,int j)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;

        int []dx = {-1,0,1,0};
        int []dy = {0,-1,0,1};
        while(!q.isEmpty())
        {
            int a[] = q.poll();
            int x = a[0];
            int y = a[1];

            for(int d=0;d<4;d++)
            {
                int ni = x+dx[d];
                int nj = y+dy[d];

                if(ni>=0 && nj>=0 && ni<n && nj<m && arr[ni][nj]=='L' && !visited[ni][nj])
                {
                    visited[ni][nj]=true;
                    q.add(new int[]{ni,nj});
                }
            }

        }

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char [][] arr = new char[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j] = sc.next().charAt(0);
            }
        }

        int cnt = 0;
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]=='L' && !visited[i][j])
                {
                    cnt++;
                    BFS(arr,visited,n,m,i,j);
                }
            }
        }
        System.out.println("No Of Island : "+cnt);
    }
}
