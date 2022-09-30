package graph.algos;

import java.util.*;

/** A directed graph:
 *  a ---------> c
 *  .           .
 *  .           .
 *  v           v
 *  b           e
 *  .
 *  .
 *  v
 *  d ---------> f
 *
 * Nodes and it's neighbors:
 *  a: [b, c]
 *  b: [d]
 *  c: [e]
 *  d: [f]
 *  e: []
 *  f: []
 *
 *  Understand:
 *  - print all the visited vertices
 *  - pre-condition:
 *  - input: a map that represents the graph and a source node
 *  Match:
 *  - depth first search
 *  Plan:
 *  - For depth first search we need a stack
 *  - we can use stack differently:
 *  - 1. explicit use of stack data structure and 2. recursion to use underlying call stack
 *  - start from a source node
 *  - and then explore the node
 *  -
 * */

public class DFS {
    // DFS using the stack data structure
    public static Set<Character> dfs(Map<Character, List<Character>> graph, Character source){
        Set<Character> visited = new LinkedHashSet<>();
        Stack<Character> stack = new Stack<>();

        if (source != null){
            stack.push(source);
        }

        while (!stack.isEmpty()){
            // pop the element from the top of the stack
            Character current = stack.pop();
            // add the current to the visited set of nodes
            visited.add(current);
            // add the neighbors of the current to the stack
            for (Character neighbor: graph.get(current)){
                stack.push(neighbor);
            }
        }

        return visited;
    }

    // recursive dfs uses the underlying call stack of the recursive program
    public static void depthFirstSearch(Map<Character, List<Character>> graph, Character source, Set<Character> visited){
        if (!visited.contains(source)){
            // add the source to the visited set of nodes
            visited.add(source);
            // get the neighbors of the source node
            List<Character> neighbors = graph.get(source);
            // visit the neighbors of the source
            for (Character neighbor: neighbors){
                depthFirstSearch(graph,neighbor, visited);
            }
        }
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

        // call the iterative dfs
        System.out.println(dfs(graph, 'a')); // acebdf

        // call the recursive depth first search
        Set<Character> visited = new LinkedHashSet<>();
        depthFirstSearch(graph, 'a', visited);
        System.out.println(visited); // abdfce
    }
}
