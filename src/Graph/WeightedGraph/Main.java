package Graph.WeightedGraph;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void PrintAdjList(ArrayList<ArrayList<int[]>> adj,int v)
    {
        System.out.println("Adjacency List : ");
        for(int i =0;i<v;i++)
        {
            System.out.println("Node "+i+" :");
            for(int []num:adj.get(i))
            {
                System.out.print("["+num[0]+" , w = "+num[1]+"]");
            }
            System.out.println();
        }
    }

    public static void PrintAdjMatrix(ArrayList<ArrayList<int[]>> adj,int v)
    {
        int ans[][] = new int[v][v];
        for(int i=0;i<v;i++)
        {
            for(int num[]:adj.get(i))
            {
                ans[i][num[0]] = num[1];
            }
        }

        System.out.println("Adjacency Matrix : ");
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
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

        for(int i=0;i<e;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            adj.get(a).add(new int[]{b,w});
            adj.get(b).add(new int[]{a,w}); // for undirected graph
        }

        PrintAdjList(adj,v);
        PrintAdjMatrix(adj,v);
    }
}
