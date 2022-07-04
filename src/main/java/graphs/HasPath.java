package graphs;

import java.util.*;

public class HasPath {

    // Depth first search
    public static boolean iterativeHasPath(Map<Character, List<Character>> graph, Character source, Character destination){
        Stack<Character> stack = new Stack<>();

        stack.push(source);

        while (!stack.isEmpty()){
            Character current = stack.pop();

            if (current == destination) return true;

            List<Character> neighbors = graph.get(current);
            for (Character node: neighbors){
                stack.push(node);
            }
        }

        return false;
    }

    // Depth first search
    public static boolean recursiveHasPath(Map<Character, List<Character>> graph, Character source, Character destination){
        if (source == destination) return true;
        List<Character> neighbors = graph.get(source);
        for (Character node: neighbors){
           if (recursiveHasPath(graph, node, destination)){ // if true
               return true;
           };
        }
        return false;
    }

    // Breath first search
    public static boolean hasPathBFS(Map<Character, List<Character>> graph, Character source, Character destination){
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new LinkedHashSet<>();

        queue.add(source);

        while (!queue.isEmpty()){
            Character current = queue.poll();
            visited.add(current);

            if (current == destination) return  true;

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
        // an unordered map to represent a graph
        Map<Character, List<Character>> graph = new HashMap<>();

        // insert values to the map
        // acyclic graph, so there is no cycles in the graph
        graph.put('f', Arrays.asList('g', 'i'));
        graph.put('g', Collections.singletonList('h'));
        graph.put('h', Collections.emptyList());
        graph.put('i', Arrays.asList('g', 'k'));
        graph.put('j', Collections.singletonList('i'));
        graph.put('k', Collections.emptyList());

        // call the iterative hasPath
        System.out.println(iterativeHasPath(graph, 'f', 'o'));
        System.out.println(iterativeHasPath(graph, 'f', 'k'));

        // call the recursive hasPath
        System.out.println();
        System.out.println(recursiveHasPath(graph, 'f', 'o'));
        System.out.println(recursiveHasPath(graph, 'f', 'i'));

        // call the breath first search hasPath
        System.out.println();
        System.out.println(hasPathBFS(graph, 'f', 'i'));
        System.out.println(hasPathBFS(graph, 'f', 'j'));
    }
}
