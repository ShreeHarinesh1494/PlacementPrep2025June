package Graph.WeightedGraph;

import java.lang.reflect.Array;
import java.util.*;

public class DijikstraAlgowithHashSet
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
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
            adj.get(b).add(new  int[]{a,w});
        }
        int src = sc.nextInt();
        int dist[] = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src,0});
        dist[src]=0;

        HashSet<Integer> visited = new HashSet<>();

        while(!pq.isEmpty())
        {
            int curr[] = pq.poll();
            int node = curr[0];
            int weight = curr[1];

            if(visited.contains(node))
            {
                continue;
            }

            visited.add(node);

            for(int num[]:adj.get(node))
            {
                int distance = dist[node] + num[1];
                if(dist[num[0]]>distance)
                {
                    dist[num[0]] = distance;
                    pq.add(new int[]{num[0], distance});
                }
            }
        }

        System.out.println("Shortest Distance : ");
        for(int num:dist)
        {
            System.out.print(num+" ");
        }



    }
}
