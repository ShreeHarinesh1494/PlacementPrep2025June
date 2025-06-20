package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{

    public static void PrintAdjList(ArrayList<ArrayList<Integer>> adj,int v)
    {
        System.out.println("Adjacency List : ");
        for(int i=0;i<v;i++)
        {
            System.out.print("Node "+i+" : ");
            for(int num:adj.get(i))
                System.out.print(num+" ");
            System.out.println();
        }
    }

    public static void PrintAdjMatrix(ArrayList<ArrayList<Integer>> adj,int v)
    {
        int arr[][] = new int[v][v];
        for(int i=0;i<v;i++)
        {
            for(int num:adj.get(i))
                arr[i][num] = 1;
        }

        System.out.println("Adjacency Matrix : ");
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void BFS(ArrayList<ArrayList<Integer>> adj,int v)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[v];
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty())
        {
            int poll = q.poll();
            ans.add(poll);

            for(int num:adj.get(poll))
                if(!visited[num])
                {
                    visited[num] = true;
                    q.add(num);
                }
        }

        System.out.println("BFS : ");
        for(int num:ans)
            System.out.print(num+" ");
        System.out.println();
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adj,int v,int currentNode,ArrayList<Integer> ans,boolean visited[])
    {
        ans.add(currentNode);
        visited[currentNode] = true;


        for(int num: adj.get(currentNode))
            if(!visited[num])
                DFS(adj,v,num,ans,visited);
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

        PrintAdjList(adj,v);
        PrintAdjMatrix(adj,v);
        BFS(adj,v);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
        DFS(adj,v,0,ans,visited);
        System.out.println("DFS : ");
        for(int num:ans)
            System.out.print(num+" ");
    }
}
