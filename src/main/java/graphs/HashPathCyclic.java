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

    public static boolean hasPathDFS(char[][] edges, Character source, Character destination){
        // build the graph from the list of edges
        Map<Character, List<Character>> graph = buildGraph(edges);
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

    public static boolean hasPath(char[][] edges, Character src, Character dest){
        Map<Character, List<Character>> graph = buildGraph(edges);
        Set<Character> visited = new LinkedHashSet<>();

        return recursiveDFS(graph, src, dest, visited);
    }

    public static boolean recursiveDFS(Map<Character, List<Character>> graph, Character src, Character dest,
                              Set<Character> visited){
        if (!visited.contains(src)){
            // add the src to the set to of visited nodes
            visited.add(src);

            if (src == dest) return true;

            List<Character> neighbors = graph.get(src);
            for (Character node: neighbors){
                if (recursiveDFS(graph, node, dest, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathBFS(char[][] edges, Character src, Character dest){
        // construct the graph from the list of edges
        Map<Character, List<Character>> graph = buildGraph(edges);

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

    public static  Map<Character, List<Character>> buildGraph(char[][] edges){
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

    public static void  printGraph(Map<Character, List<Character>> graph){
       for (Map.Entry<Character, List<Character>> entry: graph.entrySet()){
           System.out.println(entry.getKey() + ": " + entry.getValue());
       }
    }

    public static void main(String[] args) {

        // list of edges
        char[][] edges = {
                  {'i', 'j'},
                  {'k', 'i'},
                  {'m', 'k'},
                  {'k', 'l'},
                  {'o', 'n'}};

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
        System.out.println(hasPathDFS(edges, 'i', 'o'));
        System.out.println(hasPathDFS(edges, 'j', 'n'));

        System.out.println(hasPathDFS(edges, 'i', 'l'));
        System.out.println(hasPathDFS(edges, 'j', 'm'));

        System.out.println("\nRecursive hasPath DFS: ");
        System.out.println(hasPath(edges, 'i', 'l'));
        System.out.println(hasPath(edges, 'i', 'o'));

        System.out.println("\nhasPath Breath first search: ");
        System.out.println(hasPathBFS(edges, 'i', 'l'));
        System.out.println(hasPathBFS(edges, 'i', 'o'));

        // convert a list of edges to a graph
        System.out.println("\nGraph: ");
        Map<Character, List<Character>> map = buildGraph(edges);
        printGraph(map);
    }

}
