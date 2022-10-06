package graph.algos;

import java.util.*;

/**
 * Write a function, connectedComponentsCount, that takes in the adjacency list of an undirected graph.
 * The function should return the number of connected components within the graph.
 *
 * connectedComponentsCount({
 *   0: [8, 1, 5],
 *   1: [0],
 *   5: [0, 8],
 *   8: [0, 5],
 *   2: [3, 4],
 *   3: [2, 4],
 *   4: [3, 2]
 * }); // -> 2
 *
 * connectedComponentsCount({
 *   1: [2],
 *   2: [1,8],
 *   6: [7],
 *   9: [8],
 *   7: [6, 8],
 *   8: [9, 7, 2]
 * }); // -> 1
 *
 * connectedComponentsCount({
 *   3: [],
 *   4: [6],
 *   6: [4, 5, 7, 8],
 *   8: [6],
 *   7: [6],
 *   5: [6],
 *   1: [2],
 *   2: [1]
 * }); // -> 3
 *
 * connectedComponentsCount({}); // -> 0
 *
 * connectedComponentsCount({
 *   0: [4,7],
 *   1: [],
 *   2: [],
 *   3: [6],
 *   4: [0],
 *   6: [3],
 *   7: [0],
 *   8: []
 * }); // -> 5
 *
 *
 *
 * */

public class ConnectedComponents {
    static Set<Integer> visited = new LinkedHashSet<>();

    public static int countConnectedComponents(Map<Integer, List<Integer>> graph){
        int count = 0;

        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
            count += bfs(graph, entry.getKey(), visited.size());
        }
        return count;
    }

    private static int bfs(Map<Integer, List<Integer>> graph, Integer src, int size) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
       while (!queue.isEmpty()){
           Integer current = queue.poll();
           visited.add(current);
           for (Integer neighbor: graph.get(current)){
               if (!visited.contains(neighbor)) queue.add(neighbor);
           }
       }

       // compare the updated size of the visited set of nodes and
        // the previous size of the visited set of nodes
       return visited.size() > size? 1: 0;
    }

    public static Map<Character, List<Character>> buildGraph(char[][] edges){
        // an unordered undirected map that represents a graph
        Map<Character, List<Character>> graph = new HashMap<>();

        for (char[] edge: edges){ // [a, b]
            Character nodeA = edge[0];
            Character nodeB = edge[1];

            // if the graph doesn't contain node A then, initialize the neighbors of node A as an empty list
            if (!graph.containsKey(nodeA)){
                graph.put(nodeA, Collections.emptyList());
            }

            // if the graph doesn't contain node B then, initialize the neighbors of node B as an empty list
            if(!graph.containsKey(nodeB)){
                graph.put(nodeB, Collections.emptyList());
            }

            List<Character> neighborsOfA = new ArrayList<>(graph.get(nodeA)); // retrieve the neighbors of node A
            neighborsOfA.add(nodeB); // add node B as the neighbor of node A
            graph.put(nodeA, neighborsOfA); // update the graph

            List<Character> neighborsOfB = new ArrayList<>(graph.get(nodeB)); // retrieve the neighbors of node B
            neighborsOfB.add(nodeA); // add node A as the neighbor of node B
            graph.put(nodeB,neighborsOfB); // update the graph
        }

        return graph;
    }

    public static void main(String[] args) {
        // an unordered undirected map that represents a graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // insert values to the map
        // undirected cyclic and disjoint graph
        graph.put(3, Collections.emptyList());
        graph.put(4, Collections.singletonList(6));
        graph.put(6, Arrays.asList(4, 5, 7, 8));
        graph.put(8, Collections.singletonList(6));
        graph.put(7, Collections.singletonList(6));
        graph.put(5, Collections.singletonList(6));
        graph.put(1, Collections.singletonList(2));
        graph.put(2, Collections.singletonList(1));

        System.out.println(countConnectedComponents(graph));
    }
}
