package graphs;

import java.util.*;

/**
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
 * Node and it's neighbors:
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

    public static Set<Character> iterativeDFS(Map<Character, List<Character>> graph, Character source){
        Stack<Character> stack = new Stack<>();
        Set<Character> visitedNodes = new LinkedHashSet<>();

        // add the source onto the stack
        stack.push(source);

        while (!stack.isEmpty()){
            // take out the node from the stack and explore it
            Character current = stack.pop();
            // add the current to the set
            visitedNodes.add(current);

            // get the neighbors of the current and put them onto the stack
            List<Character> neighborNodes = graph.get(current);
            for (Character node: neighborNodes){
                if (!visitedNodes.contains(node)){
                    stack.push(node);
                }
            }
        }
        return visitedNodes;
    }

    public static void recursiveDFS(Map<Character, List<Character>> graph, Character source, Set<Character> visited){
        if (!visited.contains(source)){
            // add the source to the visited set of nodes
            visited.add(source);

            // Get the neighbors fo the source node
            List<Character> neighborNodes = graph.get(source);
            for (Character node: neighborNodes){
                recursiveDFS(graph, node, visited);
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
        System.out.println(iterativeDFS(graph, 'a'));

        // call the recursive dfs
        Set<Character> visited = new LinkedHashSet<>();
        recursiveDFS(graph, 'a', visited);
        System.out.println(visited);

    }
}
