package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Solution2
{
    ArrayList<Integer> rank =  new ArrayList<>();
    ArrayList<Integer> ultiparent =  new ArrayList<>();
    Solution2(int v)
    {
        for(int i=0;i<v;i++)
        {
            rank.add(0);
            ultiparent.add(i);
        }
    }

    public int getparent(int a)
    {
        if(a == ultiparent.get(a))
        {
            return a;
        }

        int parent = getparent(ultiparent.get(a));
        ultiparent.set(a, parent);
        return parent;

    }
    public void union(int u,int v)
    {
        int pu = getparent(u);
        int pv = getparent(v);

        if(pu == pv)
        {
            return;
        }
        if(rank.get(pu) < rank.get(pv))
        {
            ultiparent.set(pu, pv);
        }
        else if(rank.get(pu) > rank.get(pv))
        {
            ultiparent.set(pv, pu);
        }
        else
        {
            ultiparent.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
        }
    }
}
public class KruskalAlgo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> adj = new ArrayList<>();
        int v = sc.nextInt();
        int e = sc.nextInt();
        Solution2 s = new Solution2(v);

        for(int i=0;i<e;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            adj.add(new int[]{a,b,w});
        }

        adj.sort(Comparator.comparingInt(a->a[2]));
        ArrayList<int[]> mst= new  ArrayList<>();
        int sum = 0;
        for(int num[]:adj)
        {
            int u = num[0];
            int va = num[1];
            int wt = num[2];

            if(s.getparent(u) != s.getparent(va))
            {
                s.union(u,va);
                sum+=wt;
                mst.add(new int[]{u,va,wt});
            }
        }

        System.out.println("Mst Sum : "+sum);
        for(int num[]:mst)
        {
            System.out.println("Edge: " + num[0] + " - " + num[1] + ", Weight: " + num[2]);

        }

    }
}
