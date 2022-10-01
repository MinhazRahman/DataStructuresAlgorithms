package graph.algos;

import java.util.*;

/**
 * Write a function, hasPath, that takes in an object representing the adjacency list of a directed acyclic graph
 * and two nodes (src, dst). The function should return a boolean indicating whether
 * or not there exists a directed path between the source and destination nodes.
 *
 * const graph = {
 *   f: ['g', 'i'],
 *   g: ['h'],
 *   h: [],
 *   i: ['g', 'k'],
 *   j: ['i'],
 *   k: []
 * };
 *
 * hasPath(graph, 'f', 'k'); // true
 *
 * const graph = {
 *   f: ['g', 'i'],
 *   g: ['h'],
 *   h: [],
 *   i: ['g', 'k'],
 *   j: ['i'],
 *   k: []
 * };
 *
 * hasPath(graph, 'f', 'j'); // false
 *
 * const graph = {
 *   v: ['x', 'w'],
 *   w: [],
 *   x: [],
 *   y: ['z'],
 *   z: [],
 * };
 *
 * hasPath(graph, 'v', 'w'); // true
 *
 * const graph = {
 *   v: ['x', 'w'],
 *   w: [],
 *   x: [],
 *   y: ['z'],
 *   z: [],
 * };
 *
 * hasPath(graph, 'v', 'z'); // false
 * */

public class HasPath {
    // The following method uses iterative dfs to check if there is path between the 'src' and 'dst' nodes
    public static boolean hasPathDFS(Map<Character, List<Character>> graph, Character src, Character dst){
        Stack<Character> stack = new Stack<>();

        if (src != null) stack.push(src);

        while (!stack.isEmpty()){
            Character current = stack.pop();
            if (current == dst) return true;
            List<Character> neighbors = graph.get(current);
            for (Character neighbor: neighbors){
                stack.push(neighbor);
            }
        }

        return false;
    }

    // Recursive Depth first search uses the underlying call stack of the recursive function call
    public static boolean hasPath(Map<Character, List<Character>> graph, Character source, Character destination){
        if (source == destination) return true;
        List<Character> neighbors = graph.get(source);
        for (Character neighbor: neighbors){
            if (hasPath(graph, neighbor, destination)){ // if true then only return true
                return true;
            };
        }
        return false;
    }
    // The following method uses BFS to check if there is path between the 'src' and 'dst' nodes
    public static boolean hasPathBFS(Map<Character, List<Character>> graph, Character src, Character dst){
        Queue<Character> queue = new LinkedList<>();

        if (src != null) queue.add(src);

        while (!queue.isEmpty()){
            Character current = queue.poll();
            if (current == dst) return true;
            List<Character> neighbors = graph.get(current);
            for (Character neighbor: neighbors){
                queue.add(neighbor);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // an unordered map to represent a graph
        Map<Character, List<Character>> graph = new HashMap<>();

        // insert value to the map
        graph.put('a', Arrays.asList('b', 'c'));
        graph.put('b', Collections.singletonList('d'));
        graph.put('c', Collections.singletonList('e'));
        graph.put('d', Collections.singletonList('f'));
        graph.put('e', Collections.emptyList());
        graph.put('f', Collections.emptyList());

        System.out.println("Iterative hasPathDFS: ");
        System.out.println(hasPathDFS(graph, 'a', 'f'));

        System.out.println(hasPathDFS(graph, 'e', 'f'));

        System.out.println(hasPathDFS(graph, 'f', 'e'));

        System.out.println(hasPathDFS(graph, 'b', 'c'));

        System.out.println("Recursive hasPath DFS: ");
        System.out.println(hasPath(graph, 'a', 'f'));

        System.out.println(hasPath(graph, 'e', 'f'));

        System.out.println(hasPath(graph, 'f', 'e'));

        System.out.println(hasPath(graph, 'b', 'c'));

        System.out.println("Iterative hasPathBFS: ");
        System.out.println(hasPathBFS(graph, 'a', 'f'));

        System.out.println(hasPathBFS(graph, 'e', 'f'));

        System.out.println(hasPathBFS(graph, 'f', 'e'));

        System.out.println(hasPathBFS(graph, 'b', 'c'));
    }
}
