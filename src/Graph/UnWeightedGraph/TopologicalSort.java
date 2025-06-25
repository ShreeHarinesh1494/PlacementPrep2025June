package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort
{
    public static void DFS(ArrayList<ArrayList<Integer>> adj,int start,int v,int visited[],Stack<Integer> st)
    {
        visited[start]=1;

        for(int num:adj.get(start))
        {
            if(visited[num]==-1)
            {
                DFS(adj,num,v,visited,st);
            }
        }
        st.push(start);
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

        int visited[] = new int[v];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(visited,-1);
        for(int i=0;i<v;i++)
        {
            if(visited[i]==-1)
            {
                DFS(adj,i,v,visited,st);
            }
        }

        int ans[] = new int[v];

        int cnt = 0;
        while(!st.isEmpty())
        {
            ans[cnt++] = st.pop();
        }

        for(int num:ans)
            System.out.print(num+" ");
    }
}
