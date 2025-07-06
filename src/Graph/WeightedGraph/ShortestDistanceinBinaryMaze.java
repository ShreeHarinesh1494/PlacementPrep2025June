package Graph.WeightedGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestDistanceinBinaryMaze
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
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        int si = sc.nextInt();
        int sj = sc.nextInt();
        int di  =sc.nextInt();
        int dj = sc.nextInt();
        q.add(new int[] {si,sj});
        dist[si][sj]=0;

        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i=0;i<4;i++)
            {
                int ni = x + dx[i];
                int nj = y + dy[i];

                if(ni>=0 && nj>=0 && ni<n && nj<m && arr[ni][nj]==1)
                {
                    if(dist[ni][nj]>dist[x][y]+1)
                    {
                        dist[ni][nj] = dist[x][y]+1;
                        q.add(new int[] {ni,nj});
                    }
                }
            }
        }

        int result = dist[di][dj] == Integer.MAX_VALUE ? -1 : dist[di][dj];
        System.out.println(result);
    }
}
