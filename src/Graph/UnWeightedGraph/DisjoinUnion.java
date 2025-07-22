package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
    ArrayList<Integer> rank =  new ArrayList<>();
    ArrayList<Integer> ultiparent =  new ArrayList<>();
    Solution(int v)
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
public class DisjoinUnion
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        Solution s = new Solution(v);
        int e = sc.nextInt();
        for(int i=0;i<e;i++)
        {
            int a  =sc.nextInt();
            int b = sc.nextInt();
            s.union(a,b);
        }

        int a  = sc.nextInt();
        int b = sc.nextInt();
        if(s.getparent(a) == s.getparent(b))
        {
            System.out.println("Same");
        }
        else
        {
            System.out.println("Different");
        }
    }
}
