package Graph.UnWeightedGraph;

import java.util.*;

public class CourseScheduler1
{
    public static boolean canFinish(int numCourses, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites)
        {
            int a = pre[0];
            int b = pre[1];
            adj.get(b).add(a); // b -> a
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
        {
            for (int neighbor : adj.get(i))
            {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
        {
            if (indegree[i] == 0)
            {
                q.add(i);
            }
        }

        int i = 0;
        int ans[] = new int[numCourses];
        while (!q.isEmpty())
        {
            int course = q.poll();
            ans[i++] = course;
            for (int neighbor : adj.get(course))
            {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                {
                    q.add(neighbor);
                }
            }
        }

        return i == numCourses;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of courses: ");
        int numCourses = sc.nextInt();

        System.out.print("Enter number of prerequisites: ");
        int p = sc.nextInt();

        int[][] prerequisites = new int[p][2];
        System.out.println("Enter prerequisites (pair of courses): ");
        for (int i = 0; i < p; i++)
        {
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }

        System.out.println(canFinish(numCourses, prerequisites));
    }
}
