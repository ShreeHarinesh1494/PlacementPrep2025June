package Graph.WeightedGraph;

import java.util.*;

public class ShortestPathInUndirectedGraph
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e =  sc.nextInt();
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }

        int src = sc.nextInt();
        for(int i=0;i<e;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            adj.get(a).add(new int[]{b,w});
            adj.get(b).add(new int[]{a, w});
        }


        int dist[] = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src]=0;
        while(!q.isEmpty())
        {
            int poll  =q.poll();

            for(int []num:adj.get(poll))
            {
                int distance = dist[poll] + num[1];

                if(distance<dist[num[0]])
                {
                    dist[num[0]] = distance;
                    q.add(num[0]);
                }
            }
        }

        for(int num:dist)
            System.out.print(num+" ");
    }
}
