package graphs;

import java.util.*;

/**
 *  1 ......... 3
 *  .           .
 *  .           .
 *  2           4
 *  .
 *  .
 *  5 ......... 6
 *
 *
 *  Understand:
 *  - print all the visited vertices
 *  - pre-condition:
 *  - input: 2d array that represents the graph, int input
 *  Match:
 *  - breadth first search
 *  Plan:
 *  - start from a vertex, we will call it visited
 *  - then explore the vertex
 *  -
 * */

public class BFSGraph {

    public static void graphBFS(int[][] edges, int startingVertex){
        // We need a queue to store visited vertices, that we will explore later
        Queue<Integer> queue = new LinkedList<>();
        // We need an array to keep track of visited vertices
        int[] visited = new int[edges.length];
        Arrays.fill(visited, 0);

        // mark the vertex as visited
        visited[startingVertex] = 1;
        // add the starting vertex to the queue
        queue.add(startingVertex);

        // as long as the queue is not empty, pop one vertex from the queue and explore it
        while (!queue.isEmpty()){
            // number of columns of the 2D array/adjacency matrix
            int n = edges[0].length;
            // pop the head element/vertex from the queue for exploration
            int u = queue.poll();
            System.out.print(u + " ");

            // explore the vertex u
            for (int v = 1; v<n; v++){
                // if there is an edge and the vertex at the other end of the edge is not
                // visited yet, then visit the vertex and add the visited vertex to the
                // queue, so that we can explore it later
                if (edges[u][v] == 1 && visited[v] == 0){
                    // mark the vertex as visited
                    visited[v] = 1;
                    // add the vertex to the queue
                    queue.add(v);
                }
            }
        }
    }

    public static void bsf(int[][] edges, int startingVertex){
        // We need a queue to store visited vertices, that we will explore later
        Queue<Integer> queue = new LinkedList<>();
        // define a set to keep track of visited nodes
        Set<Integer> visitedSet = new LinkedHashSet<>();

        // add the starting vertex to the queue
        queue.add(startingVertex);

        // as long as the queue is not empty, pop one vertex from the queue and explore it
        while (!queue.isEmpty()){

            // take out the head node/vertex from the queue for exploration
            int current = queue.poll();
            // add the current to the set of visited vertices
            visitedSet.add(current);

            // number of columns of the 2D array/adjacency matrix
            int n = edges[current].length;

            // explore the current node
            // iterate over the row of adjacency matrix
            for (int vertex = 1; vertex<n; vertex++){
                // if there is an edge and the vertex at the other end of the edge is not
                // visited yet, then visit the vertex and add the visited vertex to the
                // queue, so that we can explore it later
                if (edges[current][vertex] == 1 && !visitedSet.contains(vertex)){
                    // add the vertex to the queue
                    queue.add(vertex);
                }
            }
        }

        System.out.println(visitedSet);
    }

    public static void main(String[] args) {
        // 8x8 graph, we will leave the 0th row and the 0th column empty
        //               0  1  2  3  4  5  6
        int[][] edges ={{0, 0, 0, 0, 0, 0, 0},  // 0
                        {0, 0, 1, 1, 0, 0, 0},  // 1
                        {0, 1, 0, 0, 0, 1, 0},  // 2
                        {0, 1, 0, 0, 1, 0, 0},  // 3
                        {0, 0, 0, 1, 0, 0, 0},  // 4
                        {0, 0, 1, 0, 0, 0, 1},  // 5
                        {0, 0, 0, 0, 0, 1, 0},}; // 6

        graphBFS(edges, 1);

        System.out.println();
        bsf(edges, 1);

    }
}
