package Graph.WeightedGraph;

import java.util.Arrays;
import java.util.Scanner;

public class FloyWarshallAlgo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int arr[][] = new int[v][v];
        for (int i = 0; i < v; i++)
        {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            arr[a][b] = w;
        }

        int dist[][] = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                dist[i][j] = arr[i][j];
            }
        }


        for(int k=0;k<v;k++)
        {
            for(int i=0;i<v;i++)
            {
                for(int j=0;j<v;j++)
                {
                    if(dist[i][k]!= Integer.MAX_VALUE && dist[k][j]!= Integer.MAX_VALUE)
                    {
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        System.out.println("Distance Matrix : ");
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

        boolean hasnegativeCycle = false;
        for(int i=0;i<v;i++)
        {
            if(dist[i][i]<0)
            {
                hasnegativeCycle = true;
                break;
            }
        }

        System.out.println("Has Negative Cycle : "+hasnegativeCycle);
    }
}
