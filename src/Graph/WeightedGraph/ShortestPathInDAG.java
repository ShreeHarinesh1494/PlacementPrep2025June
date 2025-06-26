package Graph.WeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ShortestPathInDAG
{
    public static void DFS(ArrayList<ArrayList<int[]>> adj,int v,int start,int visited[],Stack<Integer> st)
    {
        visited[start]=1;

        for(int []num:adj.get(start))
        {
            if(visited[num[0]]==-1)
            {
                DFS(adj,v,num[0],visited,st);
            }
        }
        st.push(start);
    }
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
        }

        int visited[] = new int[v];
        Arrays.fill(visited,-1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<v;i++)
        {
            if(visited[i]==-1)
            {
                DFS(adj,v,i,visited,st);
            }
        }

        int dist[] = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src]=0;

        while(!st.isEmpty())
        {
            int poll =  st.pop();

            for(int[] num:adj.get(poll))
            {
                int distance = dist[poll] + num[1];
                if(distance<dist[num[0]])
                {
                    dist[num[0]] = distance;
                }
            }
        }

        System.out.println("Shortest distance in DAG");
        for(int num:dist)
            System.out.print(num+" ");
    }
}
