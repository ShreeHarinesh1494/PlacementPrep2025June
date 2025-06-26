package Graph.UnWeightedGraph;
import java.util.*;

public class DirectedCyclicGraphDetectionUsingKahnsAlgo
{
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

        int indeg[] = new int[v];
        for(int i=0;i<v;i++)
        {
            for(int num:adj.get(i))
            {
                indeg[num]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            if(indeg[i]==0)
            {
                q.add(i);
            }
        }

        int ans[] = new int[v];
        int i = 0;
        while(!q.isEmpty())
        {
            int poll = q.poll();
            ans[i++] = poll;

            for(int num:adj.get(poll))
            {
                indeg[num]--;

                if(indeg[num]==0)
                {
                    q.add(num);
                }
            }
        }

        if(i==v)
        {
            System.out.println("Not Cyclic Graph");
        }
        else
            System.out.println("Cyclic Graph");
    }
}

