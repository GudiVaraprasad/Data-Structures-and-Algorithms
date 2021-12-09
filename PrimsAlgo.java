import java.util.*;
import java.io.*;
import java.lang.*;

public class PrimsAlgo
{
  public void Prims(int G[][], int V)
  {
    int infnity = 9999999;
    int noEdge;
    boolean[] completed = new boolean[V];
    Arrays.fill(completed, false);
    noEdge = 0;
    completed[0] = true;
    System.out.println("Edge : Weight");

    while (noEdge < V - 1)
    {
      int min = infnity;
      int x = 0;
      int y = 0;

      for (int i = 0; i < V; i++) 
      {
        if (completed[i] == true) 
        {
          for (int j = 0; j < V; j++) 
          {
            if (!completed[j] && G[i][j] != 0) 
            {
              if (min > G[i][j]) 
              {
                min = G[i][j];
                x = i;
                y = j;
              }
            }
          }
        }
      }
      System.out.println(x + " - " + y + " :  " + G[x][y]);
      completed[y] = true;
      noEdge++;
    }
  }

  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    PrimsAlgo obj = new PrimsAlgo();

    System.out.print("Enter no. of vertices : ");
    int V = in.nextInt();

    int[][] G = new int[V][V];

    System.out.println("\nEnter the Graph : ");
    /* { { 0, 4, 52, 0, 0 }, { 4, 0, 75, 33, 27 }, 
    { 52, 75, 0, 11, 86 }, { 0, 33, 91, 0, 62 }, { 0, 27, 69, 62, 0 } } */

    for (int i = 0; i < G.length; i++)
    {
        for (int j = 0; j < G.length; j++)
        {
            G[i][j] = in.nextInt();
        }
    }
    System.out.println();
    obj.Prims(G, V);
  }
}