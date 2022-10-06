package graph.algos;

import java.util.*;

/**
 * Write a function, largestComponent, that takes in the adjacency list of an undirected graph.
 * The function should return the size of the largest connected component in the graph.
 *
 * largestComponent({
 *   0: ['8', '1', '5'],
 *   1: ['0'],
 *   5: ['0', '8'],
 *   8: ['0', '5'],
 *   2: ['3', '4'],
 *   3: ['2', '4'],
 *   4: ['3', '2']
 * }); // -> 4
 *
 * largestComponent({
 *   1: ['2'],
 *   2: ['1','8'],
 *   6: ['7'],
 *   9: ['8'],
 *   7: ['6', '8'],
 *   8: ['9', '7', '2']
 * }); // -> 6
 *
 * largestComponent({
 *   3: [],
 *   4: ['6'],
 *   6: ['4', '5', '7', '8'],
 *   8: ['6'],
 *   7: ['6'],
 *   5: ['6'],
 *   1: ['2'],
 *   2: ['1']
 * }); // -> 5
 *
 * largestComponent({}); // -> 0
 *
 * largestComponent({
 *   0: ['4','7'],
 *   1: [],
 *   2: [],
 *   3: ['6'],
 *   4: ['0'],
 *   6: ['3'],
 *   7: ['0'],
 *   8: []
 * }); // -> 3
 *
 * */

public class LargestComponent {
    static Set<Integer> visited = new LinkedHashSet<>();

    public static int largestComponent( Map<Integer, List<Integer>> graph){
        int largest = 0;

        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
            largest = Math.max(dfs(graph, entry.getKey()), largest);
        }

        return largest;
    }

    public static int dfs( Map<Integer, List<Integer>> graph, Integer src){
        if (visited.contains(src)) return 0;
        visited.add(src);
        int count = 1;
        for (Integer neighbor: graph.get(src)){
            count += dfs(graph, neighbor);
        }

        return count;
    }

    public static void main(String[] args) {
        // an unordered undirected map that represents a graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // insert values to the map
        // undirected cyclic and disjoint graph
        graph.put(0, Arrays.asList(8, 1, 5));
        graph.put(1, Collections.singletonList(0));
        graph.put(5, Arrays.asList(0, 8));
        graph.put(8, Arrays.asList(0, 5));
        graph.put(2, Arrays.asList(3, 4));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, Arrays.asList(3, 2));

        System.out.println(largestComponent(graph));
    }
}
