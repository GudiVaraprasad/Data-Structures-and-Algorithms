import java.util.*;

class AllPairShortestPath
{
    final static int INF = 99999, V = 4;
 
    void floydWarshall(int graph[][])
    {
        int dist[][] = new int[V][V];
        int i, j, k;
 
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
 
       
        for (k = 0; k < V; k++)
        {
           
            for (i = 0; i < V; i++)
            {
              
                for (j = 0; j < V; j++)
                {
                   
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist);
    }
 
    void printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                         "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
 
   
    public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int i,j;
        System.out.println("Considering Adjacency Matrix");
        System.out.println("---------------------------------");

        System.out.print("Enter the number of rows : ");
         int R = sc.nextInt();
        System.out.print("Enter the number of columns : ");
        int C = sc.nextInt();
        int graph[][] = new int[R][C];
        System.out.println("Enter the Adjacency Matrix :");
        for (i = 0; i < R; i++){
        for (j = 0; j < C; j++){
            graph[i][j] = sc.nextInt();
                }
            }
        AllPairShortestPath a = new AllPairShortestPath();
 
        a.floydWarshall(graph);
    }
}