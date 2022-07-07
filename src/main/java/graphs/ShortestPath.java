package graphs;

import javafx.util.Pair;

import java.util.*;

public class ShortestPath {

    public static int countShortestPath(char[][] edges, char src, char dest ){
        Map<Character, List<Character>> graph = buildGraph(edges);
        // queue for breath first order
        Queue<Pair<Character, Integer>> queue = new LinkedList<>();
        // set to store the list of already visited nodes
        Set<Character> visited = new LinkedHashSet<>();

        // we will create a pair of node and its distance from the source
        // pair = (src, distance-from-the-source), pair = (w,0)
        // add the source to the queue
        queue.add(new Pair<>(src, 0)); // source node src is 0 edges away from itself

        while (!queue.isEmpty()){
            // pop the head from the queue
            Pair<Character, Integer> currentPair = queue.poll();

            char currentNode = currentPair.getKey();
            int distance = currentPair.getValue();
            // add the current to visited set of nodes
            visited.add(currentNode);

            if (currentNode == dest){
                return distance;
            }

            List<Character> neighbors = graph.get(currentNode);
            for (char node: neighbors){
                if (!visited.contains(node)){
                    queue.add(new Pair<>(node, distance+1));
                }
            }
        }

        return -1;
    }

    public static int countShortestPathSize(char[][] edges, char src, char dest ){
        Map<Character, List<Character>> graph = buildGraph(edges);
        // queue for breath first order
        Queue<Pair<Character, Integer>> queue = new LinkedList<>();
        // set to store the list of already visited nodes
        Set<Character> visited = new LinkedHashSet<>();

        // we will create a pair of node and its distance from the source
        // pair = (src, distance-from-the-source), pair = (w,0)
        // add the source to the queue
        queue.add(new Pair<>(src, 0)); // source node src is 0 edges away from itself

        // add the source node to the set of visited nodes
        visited.add(src);

        while (!queue.isEmpty()){
            // pop the head from the queue
            Pair<Character, Integer> currentPair = queue.poll();

            char currentNode = currentPair.getKey();
            int distance = currentPair.getValue();

            if (currentNode == dest){
                return distance;
            }

            List<Character> neighbors = graph.get(currentNode);
            for (char node: neighbors){
                if (!visited.contains(node)){
                    queue.add(new Pair<>(node, distance+1));
                    visited.add(node);
                }
            }
        }

        return -1;
    }

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
                {'w', 'x'},
                {'x', 'y'},
                {'z', 'y'},
                {'z', 'v'},
                {'w', 'v'}};

        // call the shortest path
        System.out.println(countShortestPath(edges, 'w', 'z'));
        System.out.println(countShortestPath(edges, 'w', 'y'));

        System.out.println();
        System.out.println(countShortestPathSize(edges, 'w', 'z'));
        System.out.println(countShortestPathSize(edges, 'w', 'y'));
    }
}
