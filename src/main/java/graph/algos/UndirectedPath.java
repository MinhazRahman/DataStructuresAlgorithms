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
    public static boolean undirectedPathBFS(char[][] edges, Character src, Character dst){
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

    // The following method uses DFS to check if there is path between the 'src' and 'dst' nodes
    public static boolean undirectedPathDFS(char[][] edges, Character src, Character dst){
        Map<Character, List<Character>> graph = buildGraph(edges);
        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new LinkedHashSet<>();

        if (src != null) stack.push(src);

        while (!stack.isEmpty()){
            Character current = stack.pop();
            visited.add(current);
            if (current == dst) return true;
            List<Character> neighbors = graph.get(current);
            for (Character neighbor: neighbors){
                if (!visited.contains(neighbor)) stack.push(neighbor);
            }
        }
        return false;
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

        System.out.println("Undirected path BFS: ");
        System.out.println(undirectedPathBFS(edges, 'j', 'm'));

        System.out.println(undirectedPathBFS(edges, 'm', 'j'));

        System.out.println(undirectedPathBFS(edges, 'l', 'j'));

        System.out.println(undirectedPathBFS(edges, 'k', 'o'));

        System.out.println(undirectedPathBFS(edges, 'i', 'o'));

        System.out.println(undirectedPathBFS(edges, 'o', 'n'));

        System.out.println("Undirected path DFS: ");
        System.out.println(undirectedPathDFS(edges, 'j', 'm'));

        System.out.println(undirectedPathDFS(edges, 'm', 'j'));

        System.out.println(undirectedPathDFS(edges, 'l', 'j'));

        System.out.println(undirectedPathDFS(edges, 'k', 'o'));

        System.out.println(undirectedPathDFS(edges, 'i', 'o'));

        System.out.println(undirectedPathDFS(edges, 'o', 'n'));

    }
}
