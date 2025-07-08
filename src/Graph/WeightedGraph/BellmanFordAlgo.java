package Graph.WeightedGraph;

import java.util.*;

public class BellmanFordAlgo // Applicable only with DirectedCycle and Negative Cycle
{
    public static void main(String[] args)
    {
        Scanner sc =  new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<int[]> adj = new  ArrayList<>();
        for(int i=0;i<e;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            adj.add(new int[]{a,b,w});
        }

        int src = sc.nextInt();
        int dist[] = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=0;i<v-1;i++)
        {
           for(int num[]:adj)
           {
               int a = num[0];
               int b = num[1];
               int w = num[2];

               if(dist[a]!=Integer.MAX_VALUE && dist[a] + w < dist[b])
               {
                  dist[b] = dist[a] + w;
               }
           }
        }

        System.out.println("Shortest Distance : ");
        for(int num:dist)
        {
            if(num == Integer.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(num + " ");
        }

        boolean hasnegativeCycle = false; // Even after V-1 Relaxation if we find shortest path then we have Negative cycle
        for(int num[]:adj)
        {
            int a = num[0];
            int b = num[1];
            int w = num[2];

            if(dist[a]!=Integer.MAX_VALUE && dist[a] + w < dist[b])
            {
                hasnegativeCycle = true;
                break;
            }
        }
        if(hasnegativeCycle)
            System.out.println("Has Negative Cycle");
        else
            System.out.println("No Negative Cycle");
    }
}
