package graph.algos;

import java.util.*;

/**
 * Write a function, undirectedPath, that takes in an array of edges for an undirected graph and two nodes (nodeA, nodeB).
 * The function should return a boolean indicating whether or not there exists a path between nodeA and nodeB.
 *const edges = [
 *   ['i', 'j'],
 *   ['k', 'i'],
 *   ['m', 'k'],
 *   ['k', 'l'],
 *   ['o', 'n']
 * ];
 *
 * undirectedPath(edges, 'j', 'm'); // -> true
 *
 * const edges = [
 *   ['i', 'j'],
 *   ['k', 'i'],
 *   ['m', 'k'],
 *   ['k', 'l'],
 *   ['o', 'n']
 * ];
 *
 * undirectedPath(edges, 'm', 'j'); // -> true
 *
 * const edges = [
 *   ['i', 'j'],
 *   ['k', 'i'],
 *   ['m', 'k'],
 *   ['k', 'l'],
 *   ['o', 'n']
 * ];
 *
 * undirectedPath(edges, 'l', 'j'); // -> true
 *
 * const edges = [
 *   ['i', 'j'],
 *   ['k', 'i'],
 *   ['m', 'k'],
 *   ['k', 'l'],
 *   ['o', 'n']
 * ];
 *
 * undirectedPath(edges, 'k', 'o'); // -> false
 *
 * const edges = [
 *   ['i', 'j'],
 *   ['k', 'i'],
 *   ['m', 'k'],
 *   ['k', 'l'],
 *   ['o', 'n']
 * ];
 *
 * undirectedPath(edges, 'i', 'o'); // -> false
 *
 *
 * */

public class UndirectedPath {

    // The following method uses BFS to check if there is path between the 'src' and 'dst' nodes
    public static boolean undirectedPath(char[][] edges, Character src, Character dst){
        Map<Character, List<Character>> graph = buildGraph(edges);
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new LinkedHashSet<>();

        if (src != null) queue.add(src);

        while (!queue.isEmpty()){
            Character current = queue.poll();
            visited.add(current);
            if (current == dst) return true;
            List<Character> neighbors = graph.get(current);
            for (Character neighbor: neighbors){
                if (!visited.contains(neighbor)) queue.add(neighbor);
            }
        }

        return false;
    }
    /** complexity analysis:
     * n = # of nodes
     * e = # of edges
     * Time complexity: O(e)
     * Space complexity: O(n)
     * */

    public static Map<Character, List<Character>> buildGraph(char[][] edges){
        // an unordered undirected map that represents a graph
        Map<Character, List<Character>> graph = new HashMap<>();

        for (char[] edge: edges){ // [a, b]
            Character nodeA = edge[0];
            Character nodeB = edge[1];

            if (!graph.containsKey(nodeA)){
                graph.put(nodeA, Collections.emptyList());
            }

            if(!graph.containsKey(nodeB)){
                graph.put(nodeB, Collections.emptyList());
            }

            List<Character> listA = new ArrayList<>(graph.get(nodeA));
            listA.add(nodeB);
            graph.put(nodeA, listA);

            List<Character> listB = new ArrayList<>(graph.get(nodeB));
            listB.add(nodeA);
            graph.put(nodeB,listB);
        }

        return graph;
    }
    public static void main(String[] args) {
        // list of edges
        char[][] edges = {
                {'i', 'j'},
                {'k', 'i'},
                {'m', 'k'},
                {'k', 'l'},
                {'o', 'n'}};

        Map<Character, List<Character>> graph = buildGraph(edges);
        for (Map.Entry<Character, List<Character>> entry: graph.entrySet()){
            System.out.println(entry.getKey() +": " + entry.getValue());
        }

        System.out.println(undirectedPath(edges, 'j', 'm'));

        System.out.println(undirectedPath(edges, 'm', 'j'));

        System.out.println(undirectedPath(edges, 'l', 'j'));

        System.out.println(undirectedPath(edges, 'k', 'o'));

        System.out.println(undirectedPath(edges, 'i', 'o'));

        System.out.println(undirectedPath(edges, 'o', 'n'));

    }
}
