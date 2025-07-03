package Graph.WeightedGraph;
import java.util.*;

public class DijikstraAlgo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int v = sc.nextInt();
        int e = sc.nextInt();
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

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int src = sc.nextInt();
        int dist[] = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new int[]{src,0});

        while(!pq.isEmpty())
        {
            int curr[] = pq.poll();
            int node = curr[0];
            int weight = curr[1];

            for(int num[]:adj.get(node))
            {
                int distance = dist[node] + num[1];
                if(distance < dist[num[0]])
                {
                    dist[num[0]] = distance;
                    pq.add(new int[]{num[0],distance});
                }
            }
        }

        System.out.println("Shortest Path : ");
        for(int num:dist)
        {
            System.out.print(num+" ");
        }



    }
}
