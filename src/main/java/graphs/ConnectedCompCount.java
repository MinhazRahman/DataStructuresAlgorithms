package graphs;

import java.util.*;

/**
 * Match:
 * - Graph, BFS, DFS
 * Plan:
 * - convert the list of edges to adjacency list
 * - we use BFS
 * - maintain a counter
 * - iterate over each node
 * - and add the visited nodes to a set
 * - on each iteration if the number of nodes in the set
 * - increases then we increment the counter
 * - after each iteration if the number of nodes in a set remains same,
 * - then the counter doesn't change
 * */

public class ConnectedCompCount {
    static Set<Integer> visited = new LinkedHashSet<>();

    public static int countComponents(Map<Integer, List<Integer>> graph){
        int count = 0;

        // iterate over each node
        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
            count += bfs(graph, entry.getKey(), visited.size());
        }
        return count;
    }

    public static int bfs(Map<Integer, List<Integer>> graph, int src, int size){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);

        while (!queue.isEmpty()){
            int current = queue.poll();
            visited.add(current);

            List<Integer> neighbors = graph.get(current);
            for (int node: neighbors){
                if (!visited.contains(node)){
                    queue.add(node);
                }
            }
        }

        return visited.size() > size? 1: 0;
    }

    public static Map<Integer, List<Integer>> buildGraph(int[][] edges){
        // an unordered undirected map that represents a graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge: edges){ // [a, b]
            Integer nodeA = edge[0];
            Integer nodeB = edge[1];

            if (!graph.containsKey(nodeA)){
                graph.put(nodeA, Collections.emptyList());
            }

            if(!graph.containsKey(nodeB)){
                graph.put(nodeB, Collections.emptyList());
            }

            List<Integer> listA = new ArrayList<>(graph.get(nodeA));
            listA.add(nodeB);
            graph.put(nodeA, listA);

            List<Integer> listB = new ArrayList<>(graph.get(nodeB));
            listB.add(nodeA);
            graph.put(nodeB,listB);
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

        // call the countComponents method
        System.out.println(countComponents(graph));
    }
}
