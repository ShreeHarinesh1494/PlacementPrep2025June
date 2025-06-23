package Graph.UnWeightedGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Matrix01
{
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

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==1)
                {
                    q.add(new int[] {i,j,0});
                    visited[i][j]=true;
                }
            }
        }

        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            int x = curr[0];
            int y = curr[1];
            int step = curr[2];

            dist[x][y] = step;
            for(int i=0;i<4;i++)
            {
                int ni = x+dx[i];
                int nj = y+dy[i];

                if(ni>=0 && nj>=0 && ni<n && nj<m && !visited[ni][nj])
                {
                    q.add(new int[] {ni,nj,step+1});
                    visited[ni][nj]=true;
                }
            }

        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }
}
