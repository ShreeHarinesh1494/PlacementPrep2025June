package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.Scanner;

public class DirectedCyclicDetection
{
    public static boolean DFS(ArrayList<ArrayList<Integer>> adj,int v,int start,boolean visited[],boolean path[])
    {
        visited[start]=true;
        path[start]=true;

        for(int num:adj.get(start))
        {
            if(!visited[num])
            {
                if(DFS(adj,v,num,visited,path))
                return true;
            }
            else if(path[num])
            {
                return true;
            }
        }
        path[start]=false;
        return false;
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
        }

        boolean [] visited = new boolean[v];
        boolean [] path = new boolean[v];
        boolean istrue = false;
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                if(DFS(adj,v,i,visited,path))
                {
                    istrue = true;
                    break;
                }
            }
        }

        if(istrue)
        {
            System.out.println("Directed Cyclic Graph");
        }
        else
        {
            System.out.println("UnDirected Cyclic Graph");
        }
    }
}
