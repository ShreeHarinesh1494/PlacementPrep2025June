package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAlgoMST
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
            adj.get(b).add(new int[]{a,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2] - b[2]);
        int sum = 0;
        ArrayList<int[]> mst = new ArrayList<>();
        boolean visited[] = new boolean[v];
        int src = sc.nextInt();
        pq.add(new int[]{-1,src,0});

        while(!pq.isEmpty())
        {
            int curr[] = pq.poll();
            int parent = curr[0];
            int node = curr[1];
            int wt = curr[2];

            if(visited[node])
            {
                continue;
            }
            visited[node] = true;
            if(parent!=-1)
            {
                sum+=wt;
                mst.add(new int[]{node,wt});
            }

            for(int num[]:adj.get(node))
            {
                pq.add(new int[]{node,num[0],num[1]});
            }
        }

        System.out.println("MST Sum : "+sum);
        System.out.println("MST Edges:");
        for(int[] edge : mst)
        {
            System.out.println("Node: " + edge[0] + ", Weight: " + edge[1]);
        }

    }
}
