package graphs;

import java.util.*;

/**
 *  1 --------- 2
 *  .  \        .
 *  .       \   .
 *  4 --------- 3
 *     \      /
 *      5
 *     /  \
 *  6       7
 *
 *  Understand:
 *  - print all the visited vertices
 *  - pre-condition:
 *  - input: 2d array that represents the graph, int input
 *  Match:
 *  - DEPTH first search
 *  Plan:
 *  - start from a vertex, we will call it visited
 *  - then explore the vertex
 *  -
 * */

public class GraphDFS {

    public static void graphDFS(int[][] edges, int node){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visitedSet = new LinkedHashSet<>();

        // push the first node onto the stack
        stack.push(node);
        // add the node to the visited set of nodes
        visitedSet.add(node);

        while (!stack.isEmpty()){
            // pop the element from the stack
            int current = stack.pop();
            // System.out.println(current);

            // push the neighbors of current node onto the stack
            int n = edges[current].length;
            for (int v = 1; v<n; v++){
                if (edges[current][v] == 1 && !visitedSet.contains(v)){
                    stack.push(v);
                    visitedSet.add(v);
                }
            }
        }

        System.out.println(visitedSet);
    }

    public static void graphStackDFS(int[][] edges, int node){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visitedSet = new LinkedHashSet<>();

        // push the first node onto the stack
        stack.push(node);

        while (!stack.isEmpty()){
            // pop the element from the stack
            int current = stack.pop();
            visitedSet.add(current);

            // push the neighbors of current node onto the stack
            int n = edges[current].length;
            for (int v = 1; v<n; v++){
                if (edges[current][v] == 1 && !visitedSet.contains(v)){
                    stack.push(v);
                }
            }
        }

        System.out.println(visitedSet);
    }

    public static void dfs(int[][] edges, int n, int u, int[] visited){
        if (visited[u] == 0){
            System.out.print(u + " ");
            visited[u] = 1;
            // explore vertex u
            for (int v = 1; v<n; v++){
                // if there is an edge and the vertex at the other end of the edge is not
                // visited yet, then visit the vertex recursively
                if (edges[u][v] == 1 && visited[v] == 0){
                    dfs(edges, n, v, visited);
                }
            }
        }
    }

    public static void dfs(int[][] edges, int n, int current, Set<Integer> set){
        if (!set.contains(current)){
            // add the node to the visited set of nodes
            set.add(current);
            // explore vertex u
            for (int v = 1; v<n; v++){
                // if there is an edge and the vertex at the other end of the edge is not
                // visited yet, then visit the vertex recursively
                if (edges[current][v] == 1 && !set.contains(v)){
                    dfs(edges, n, v, set);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 8x8 graph, we will leave the 0th row and the 0th column empty
        //               0  1  2  3  4  5  6  7
        int[][] edges ={{0, 0, 0, 0, 0, 0, 0, 0}, // 0
                        {0, 0, 1, 1, 1, 0, 0, 0}, // 1
                        {0, 1, 0, 1, 0, 0, 0, 0}, // 2
                        {0, 1, 1, 0, 1, 1, 0, 0}, // 3
                        {0, 1, 0, 1, 0, 1, 0, 0}, // 4
                        {0, 0, 0, 1, 1, 0, 1, 1}, // 5
                        {0, 0, 0, 0, 0, 1, 0, 0}, // 6
                        {0, 0, 0, 0, 0, 1, 0, 0}}; // 7

        // number of columns of the 2D array/adjacency matrix
        int n = edges[0].length;
        // We need an array to keep track of visited vertices
        int[] visited = new int[edges.length];
        Arrays.fill(visited, 0);

        // Define set to store visited vertices
        Set<Integer> set = new LinkedHashSet<>();

        dfs(edges, n, 4, visited);

        System.out.println();
        graphDFS(edges, 4);

        dfs(edges, n, 4, set);
        System.out.println(set);

        System.out.println();
        graphStackDFS(edges, 1);

    }
}
