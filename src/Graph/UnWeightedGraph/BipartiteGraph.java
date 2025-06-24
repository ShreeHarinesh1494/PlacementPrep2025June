package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BipartiteGraph
{
    public static boolean Bipartite(ArrayList<ArrayList<Integer>> adj,int start,int v,int color[],boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]=true;

        while(!q.isEmpty())
        {
            int poll =  q.poll();
            visited[poll]=true;

            for(int num:adj.get(poll))
            {
                if(color[num]==-1)
                {
                    color[num] = 1 - color[poll];
                    q.add(num);
                }
                else if(color[num]==color[poll])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
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

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int color[] = new int[v];
        boolean visited[] = new boolean[v];
        for(int i=0;i<v;i++)
        {
            color[i]=-1;
        }

        boolean istrue = true;
        for(int i=0;i<v;i++)
        {
            if(color[i]==-1)
            {
                if(!Bipartite(adj,i,v,color,visited))
                {
                    istrue = false;
                    break;
                }
            }
        }

        if(istrue)
        {
            System.out.println("Bipartite Graph");
        }
        else
        {
            System.out.println("Not Bipartite Graph");
        }

    }
}
