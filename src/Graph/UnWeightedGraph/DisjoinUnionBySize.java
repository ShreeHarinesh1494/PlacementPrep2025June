package Graph.UnWeightedGraph;

import java.util.ArrayList;
import java.util.Scanner;

class Solution1
{
    ArrayList<Integer> size =  new ArrayList<>();
    ArrayList<Integer> ultiparent =  new ArrayList<>();
    Solution1(int v)
    {
        for(int i=0;i<v;i++)
        {
            size.add(1);
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
        if(size.get(pu) < size.get(pv))
        {
            ultiparent.set(pu, pv);
            size.set(pv,size.get(pv)+size.get(pu));
        }
        else
        {
            ultiparent.set(pv, pu);
            size.set(pu,size.get(pu)+size.get(pv));
        }

    }
}
public class DisjoinUnionBySize
{
    public static void main(String[] args)
    {
        Scanner sc = new  Scanner(System.in);
        int v = sc.nextInt();
        Solution1 s = new Solution1(v);
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
