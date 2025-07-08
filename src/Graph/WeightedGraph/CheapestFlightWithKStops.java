package Graph.WeightedGraph;

import java.util.*;

public class CheapestFlightWithKStops
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
        }
        int src = sc.nextInt();
        int dst = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int minstop[] = new int[v];
        Arrays.fill(minstop,Integer.MAX_VALUE);
        pq.add(new int[]{src,0,0});

        while(!pq.isEmpty())
        {
            int curr[] = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            int stop = curr[2];

            if(node == dst && stop <= k)
            {
                System.out.println(cost);
                return;
            }

            if(stop>k || stop>=minstop[node])
                continue;

            minstop[node] = stop;

            for(int num[]:adj.get(node))
            {
                int next = num[0];
                int price = num[1];
                pq.add(new int[]{next,cost+price,stop+1});
            }

        }
        System.out.println(-1);
    }
}
