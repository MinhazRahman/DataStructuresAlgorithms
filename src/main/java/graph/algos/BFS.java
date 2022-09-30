package graph.algos;

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
 *  - start from a source node
 *  - add the source node to the queue
 *  - 1. take out the first node from the queue and make it as current
 *  - 2. print the current node
 *  - 3. insert current node's neighbor to the queue
 *  - 4. repeat the steps from 1 to 3 until the queue is empty
 *  -
 * */

public class BFS {

    public static Set<Character> breadthFirstSearch(Map<Character, List<Character>> graph, Character source){
        Set<Character> visited = new LinkedHashSet<>();
        Queue<Character> queue = new LinkedList<>();

        if (source != null){
            queue.add(source);
        }

        while (!queue.isEmpty()){
            // remove the head node from the queue and make it the current node
            Character current = queue.poll();
            // add the current node to the set of visited nodes
            visited.add(current);
            // get the neighbors of the current node
            List<Character> neighbors = graph.get(current);
            // add the neighbors of the current node to the queue
            for (Character neighbor: neighbors){
                queue.add(neighbor);
            }
        }
        return visited;
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

        // call the breadthFirstSearch method
        System.out.println(breadthFirstSearch(graph, 'a'));
    }
}
