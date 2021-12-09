import java.util.*;
import java.io.*;
import java.lang.*;

class Graph
{
  class Edge implements Comparable<Edge>
  {
    int source, destination, weight;
    public int compareTo(Edge compareEdge)
    {
      return this.weight - compareEdge.weight;
    }
};

  class subset {
    int parent, rank;
  };

  int vertices, edges;
  Edge edge[];

  Graph(int v, int e)
  {
    vertices = v;
    edges = e;
    edge = new Edge[edges];
    for (int i = 0; i < e; ++i)
      edge[i] = new Edge();
  }

  int find(subset subs[], int i)
  {
    if (subs[i].parent != i)
      subs[i].parent = find(subs, subs[i].parent);
    return subs[i].parent;
  }

  void Merges(subset subs[], int x, int y)
  {
    int xroot = find(subs, x);
    int yroot = find(subs, y);

    if (subs[xroot].rank < subs[yroot].rank)
      subs[xroot].parent = yroot;
    else if (subs[xroot].rank > subs[yroot].rank)
      subs[yroot].parent = xroot;
    else {
      subs[yroot].parent = xroot;
      subs[xroot].rank++;
    }
  }

  void Krushkals()
  {
    Edge result[] = new Edge[vertices];
    int e = 0;
    int i = 0;
    for (i = 0; i < vertices; ++i)
      result[i] = new Edge();

    Arrays.sort(edge);
    subset subs[] = new subset[vertices];
    for (i = 0; i < vertices; ++i)
      subs[i] = new subset();

    for (int v = 0; v < vertices; ++v) {
      subs[v].parent = v;
      subs[v].rank = 0;
    }
    i = 0;
    while (e < vertices - 1) {
      Edge nextEdge = new Edge();
      nextEdge = edge[i++];
      int x = find(subs, nextEdge.source);
      int y = find(subs, nextEdge.destination);
      if (x != y) {
        result[e++] = nextEdge;
        Merges(subs, x, y);
      }
    }
    for (i = 0; i < e; ++i)
      System.out.println(result[i].source + " - " + result[i].destination + ": " + result[i].weight);
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter no. of vertices : ");
    int vertices = in.nextInt();

    System.out.print("Enter no. of edges : ");
    int edges = in.nextInt();

    Graph myGraphObj = new Graph(vertices, edges);

    System.out.println();
    for (int q = 0; q < edges; q++)
    {
        System.out.println("-------------------------------------");
        System.out.print("\nEnter source of edge " + (q+1) + " : ");
        myGraphObj.edge[q].source = in.nextInt();

        System.out.print("\nEnter destination of edge " + (q+1) + " : ");
        myGraphObj.edge[q].destination = in.nextInt();

        System.out.print("\nEnter weight of edge " + (q+1) + " : ");
        myGraphObj.edge[q].weight = in.nextInt();

    }
    System.out.println();
    myGraphObj.Krushkals();
  }
}