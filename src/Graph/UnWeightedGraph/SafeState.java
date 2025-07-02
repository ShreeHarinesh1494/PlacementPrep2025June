package Graph.UnWeightedGraph;
import java.util.*;

public class SafeState
{
    public static List<Integer> safeNode(int graph[][],int n)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            for(int num:graph[i])
            {
                adj.get(num).add(i);
            }
        }

        int indeg[] = new int[n];
        for(int i=0;i<n;i++)
        {
            for(int num:adj.get(i))
            {
                indeg[num]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indeg[i]==0)
            {
                q.add(i);
            }
        }

        int ans[] = new int[n];
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
        Arrays.sort(ans,0,i);
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < i; j++)
        {
            list.add(ans[j]);
        }
        return list;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        int[][] graph = new int[n][];

        System.out.println("Enter adjacency list:");
        for (int i = 0; i < n; i++)
        {
            int k = sc.nextInt();
            graph[i] = new int[k];
            for (int j = 0; j < k; j++)
            {
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println(safeNode(graph,n));
    }


}
