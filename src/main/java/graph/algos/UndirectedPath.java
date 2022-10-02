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
    }
}
