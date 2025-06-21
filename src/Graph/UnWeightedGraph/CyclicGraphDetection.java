package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CyclicGraphDetection
{
    public static void cyclicDetection(ArrayList<ArrayList<Integer>> adj,int v)
    {
        boolean[] visited = new boolean[v];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,-1});
        visited[0]=true;

        while(!q.isEmpty())
        {
            int [] curr = q.poll();
            int node = curr[0];
            int parent  = curr[1];

            for(int num:adj.get(node))
            {
                if(!visited[num])
                {
                    visited[num]=true;
                    q.add(new int[] {num,node});
                }
                else if(num!=parent)
                {
                    System.out.println("Cycle Found");
                    return;
                }
            }
        }
        System.out.println("No Cycle Detected");

    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = sc.nextInt();
        int e = sc.nextInt();
        for(int i=0;i<v;i++) // < v for 0-based Indexing and <=v for 1-based Indexing
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        cyclicDetection(adj,v);
    }
}
