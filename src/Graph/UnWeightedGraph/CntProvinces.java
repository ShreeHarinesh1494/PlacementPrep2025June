package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CntProvinces
{
    public static void Cnt(ArrayList<ArrayList<Integer>> adj,int v)
    {
        int cnt = 0;
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                cnt++;
                q.add(i);
                visited[i]=true;

                while(!q.isEmpty())
                {
                    int poll = q.poll();

                    for(int num:adj.get(poll))
                    {
                        if(!visited[num])
                        {
                            visited[num]=true;
                            q.add(num);
                        }
                    }
                }
            }
        }

        System.out.println("No Of Provinces : "+cnt);
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

        Cnt(adj,v);
    }
}
