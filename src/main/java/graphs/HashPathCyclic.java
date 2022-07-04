package graphs;

import java.util.*;

/**
 * List of edges for undirected graph.
 * edges = [
 *          [i, j],
 *          [k, i],
 *          [m, k],
 *          [k, l],
 *          [o, n]];
 *
 * Convert the list of edges to adjacency list where a Map represents a graph.
 * graph = [
 *          i: [j, k],
 *          j: [i],
 *          k: [i, m, l],
 *          m: [k],
 *          l: [k],
 *          o: [n],
 *          n: [o]]
 *
 * */

public class HashPathCyclic {

    public static boolean hasPathDFS(Map<Character, List<Character>> graph, Character source, Character destination){
        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new LinkedHashSet<>();

        // add the source to the stack
        stack.push(source);

        while (!stack.isEmpty()){
            // take out the head element from the stack
            Character current = stack.pop();

            // add the current node to the set of visited nodes
            visited.add(current);

            if (current == destination) return  true;

            List<Character> neighbors = graph.get(current);

            for (Character node: neighbors){
                if (!visited.contains(node)){
                    stack.push(node);
                }
            }
        }

        return false;
    }

    public static boolean recursiveHasPathDFS(Map<Character, List<Character>> graph, Character src, Character dest,
                                              Set<Character> visited){
        if (!visited.contains(src)){
            // add the src to the set to of visited nodes
            visited.add(src);

            if (src == dest) return true;

            List<Character> neighbors = graph.get(src);
            for (Character node: neighbors){
                if (recursiveHasPathDFS(graph, node, dest, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathBFS(Map<Character, List<Character>> graph, Character src, Character dest){
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new LinkedHashSet<>();

        // add the src to the queue
        queue.add(src);

        while (!queue.isEmpty()){
            Character current = queue.poll();
            visited.add(current);

            if (current == dest) return true;

            List<Character> neighbors = graph.get(current);
            for (Character node: neighbors){
                if (!visited.contains(node)){
                    queue.add(node);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // an unordered undirected map that represents a graph
        Map<Character, List<Character>> graph = new HashMap<>();

        // insert values to the map
        // undirected cyclic and disjoint graph
        graph.put('i', Arrays.asList('j', 'k'));
        graph.put('j', Collections.singletonList('i'));
        graph.put('k', Arrays.asList('i', 'm', 'l'));
        graph.put('m', Collections.singletonList('k'));
        graph.put('l', Collections.singletonList('k'));
        graph.put('o', Collections.singletonList('n'));
        graph.put('n', Collections.singletonList('o'));

        System.out.println("Iterative hasPath DFS: ");
        System.out.println(hasPathDFS(graph, 'i', 'o'));
        System.out.println(hasPathDFS(graph, 'j', 'n'));

        System.out.println(hasPathDFS(graph, 'i', 'l'));
        System.out.println(hasPathDFS(graph, 'j', 'm'));

        System.out.println("\nRecursive hasPath DFS: ");
        System.out.println(recursiveHasPathDFS(graph, 'i', 'l',  new LinkedHashSet<>()));
        System.out.println(recursiveHasPathDFS(graph, 'i', 'o',  new LinkedHashSet<>()));

        System.out.println("\nhasPath Breath first search: ");
        System.out.println(hasPathBFS(graph, 'i', 'l'));
        System.out.println(hasPathBFS(graph, 'i', 'o'));
    }

}
