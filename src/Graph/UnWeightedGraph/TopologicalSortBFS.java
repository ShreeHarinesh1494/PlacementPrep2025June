package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// This algorithm is also called as Kahn Algorithm
public class TopologicalSortBFS
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = sc.nextInt();
        int e = sc.nextInt();
        for (int i = 0; i < v; i++) // < v for 0-based Indexing and <=v for 1-based Indexing
        {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj.get(a).add(b);
        }

        int indegree[] = new int[v];
        for(int i=0;i<v;i++)
        {
            for(int num:adj.get(i))
            {
                indegree[num]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        int topo[] = new int[v];
        int i = 0;
        while(!q.isEmpty())
        {
            int poll = q.poll();
            topo[i++] = poll;

            for(int num:adj.get(poll))
            {
                indegree[num]--;

                if(indegree[num]==0)
                {
                    q.add(num);
                }
            }
        }

        for(int num:topo)
            System.out.print(num+" ");

    }
}
