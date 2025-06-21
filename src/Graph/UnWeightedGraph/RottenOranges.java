package Graph.UnWeightedGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges
{
    public static void BFS(int arr[][],int n,int m)
    {
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fresh = 0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==2 &&!visited[i][j])
                {
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                }
                else if(arr[i][j]==1)
                {
                    fresh++;
                }
            }
        }

        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        while(!q.isEmpty() && fresh>0)
        {
            time++;
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                int curr[] = q.poll();
                int x = curr[0];
                int y = curr[1];

                for(int k=0;k<4;k++)
                {
                    int ni = x+dx[k];
                    int nj = y+dy[k];

                    if(ni>=0 && nj>=0 && ni<n && nj<m && arr[ni][nj]==1 && !visited[ni][nj])
                    {
                        visited[ni][nj]=true;
                        arr[ni][nj]=2;
                        fresh--;
                        q.add(new int[]{ni,nj});
                    }
                }
            }

        }

        if(fresh==0)
        {
            System.out.println("Time taken to rot all the Oranges : "+time);
        }
        else
            System.out.println("Not all the Oranges are Rotten");
    }
    public static void main(String[] args)
    {
        Scanner sc = new  Scanner(System.in);
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

        BFS(arr,n,m);


    }
}
