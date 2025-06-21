package Graph.UnWeightedGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FloodFillAlgorithm
{
    public static void BFS(int arr[][],int n,int m,int newcolor,int sr,int scc)
    {
        int startcolor = arr[sr][scc];
        if(startcolor == newcolor)
            return;

        Queue<int []> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];
        q.add(new int[]{sr,scc});
        visited[sr][scc]=true;
        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            int x = curr[0];
            int y = curr[1];
            arr[x][y]=newcolor;

            for(int i=0;i<4;i++)
            {
                int ni = x+dx[i];
                int nj = y+dy[i];

                if(ni>=0 && nj>=0 && ni<n && nj<m && arr[ni][nj]==startcolor && !visited[ni][nj])
                {
                    q.add(new int[]{ni,nj});
                    visited[ni][nj]=true;
                }
            }
        }

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

        int newcolor =  sc.nextInt();
        int sr = sc.nextInt();
        int scc = sc.nextInt();

        BFS(arr,n,m,newcolor,sr,scc);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
