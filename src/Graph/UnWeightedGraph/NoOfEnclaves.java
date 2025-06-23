package Graph.UnWeightedGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NoOfEnclaves
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // Top and Bottom rows
        for (int j = 0; j < m; j++) {
            if (arr[0][j] == 1 && !visited[0][j]) {
                q.add(new int[]{0, j});
                visited[0][j] = true;
            }
            if (arr[n - 1][j] == 1 && !visited[n - 1][j]) {
                q.add(new int[]{n - 1, j});
                visited[n - 1][j] = true;
            }
        }

        // Left and Right columns
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 1 && !visited[i][0]) {
                q.add(new int[]{i, 0});
                visited[i][0] = true;
            }
            if (arr[i][m - 1] == 1 && !visited[i][m - 1]) {
                q.add(new int[]{i, m - 1});
                visited[i][m - 1] = true;
            }
        }

        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        while(!q.isEmpty())
        {
            int[] current=q.poll();
            visited[current[0]][current[1]]=true;

            for(int i=0;i<4;i++)
            {
                int ni =  current[0]+dx[i];
                int nj = current[1]+dy[i];

                if(ni>=0 && nj>=0 && ni<n && nj<m && arr[ni][nj]==1 && !visited[ni][nj])
                {
                    q.add(new int[] {ni,nj});
                    visited[ni][nj]=true;
                }
            }

        }

        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==1 && !visited[i][j])
                {
                    cnt++;
                }
            }
        }
        System.out.println("No Of Enclaves : "+cnt);
    }
}
