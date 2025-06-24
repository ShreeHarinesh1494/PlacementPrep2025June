package Graph.UnWeightedGraph;

import java.util.*;

public class NoOfDistinctIsland
{
    public static void BFS(int arr[][],int r,int c,int br,int bc,List<String> shape,boolean visited[][],int n,int m)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r,c});
        visited[r][c]=true;

        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            int row = curr[0];
            int col = curr[1];

            shape.add((row - br) + "," + (col - bc));
            visited[row][col]=true;

            for(int i=0;i<4;i++)
            {
                int ni = row+dx[i];
                int nj = col+dy[i];

                if(ni>=0 && nj>=0 && ni<n && nj<m && arr[ni][nj]==1 && !visited[ni][nj])
                {
                    q.add(new int[] {ni,nj});
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

        Set<List<String>> set = new HashSet<>();
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==1 && !visited[i][j])
                {
                    List<String> shape = new ArrayList<>();
                    BFS(arr,i,j,i,j,shape,visited,n,m);
                    set.add(shape);
                }
            }
        }

        System.out.println("No of Distinct Island : "+set.size());
    }
}
