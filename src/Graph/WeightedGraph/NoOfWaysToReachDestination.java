package Graph.WeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NoOfWaysToReachDestination
{
    public static void main(String[] args)
    {
        Scanner sc =  new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<int[]>> adj = new  ArrayList<>();
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            adj.get(a).add(new int[]{b,w});
            adj.get(b).add(new int[]{a,w});
        }

        int src = sc.nextInt();
        int dst = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->a[1]-b[1]);
        int dist[] = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int ways[] = new int[v];
        Arrays.fill(ways,0);

        dist[src]=0;
        ways[src]=1;
        pq.add(new int[]{src,0});

        while(!pq.isEmpty())
        {
            int curr[] = pq.poll();
            int node = curr[0];
            int weight = curr[1];

            for(int num[]:adj.get(node))
            {
                int next = num[0];
                int cost = num[1];

                int distance = cost  + weight;
                if(dist[next]>distance)
                {
                    dist[next] = distance;
                    pq.add(new int[]{next,distance});
                    ways[next] = ways[node];
                }
                else if(dist[next]==distance)
                {
                    ways[next] += ways[node];
                }
            }
        }

        System.out.println(ways[dst]);
    }
}
