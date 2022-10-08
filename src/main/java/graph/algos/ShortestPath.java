package graph.algos;

import javafx.util.Pair;

import java.util.*;

/**
 * shortest path
 * Write a function, shortestPath, that takes in an array of edges for an undirected graph and two nodes (nodeA, nodeB).
 * The function should return the length of the shortest path between A and B.
 * Consider the length as the number of edges in the path, not the number of nodes.
 * If there is no path between A and B, then return -1.
 *
 * test_00:
 * const edges = [
 *   ['w', 'x'],
 *   ['x', 'y'],
 *   ['z', 'y'],
 *   ['z', 'v'],
 *   ['w', 'v']
 * ];
 *
 * shortestPath(edges, 'w', 'z'); // -> 2
 * test_01:
 * const edges = [
 *   ['w', 'x'],
 *   ['x', 'y'],
 *   ['z', 'y'],
 *   ['z', 'v'],
 *   ['w', 'v']
 * ];
 *
 * shortestPath(edges, 'y', 'x'); // -> 1
 * test_02:
 * const edges = [
 *   ['a', 'c'],
 *   ['a', 'b'],
 *   ['c', 'b'],
 *   ['c', 'd'],
 *   ['b', 'd'],
 *   ['e', 'd'],
 *   ['g', 'f']
 * ];
 *
 * shortestPath(edges, 'a', 'e'); // -> 3
 * test_03:
 * const edges = [
 *   ['a', 'c'],
 *   ['a', 'b'],
 *   ['c', 'b'],
 *   ['c', 'd'],
 *   ['b', 'd'],
 *   ['e', 'd'],
 *   ['g', 'f']
 * ];
 *
 * shortestPath(edges, 'e', 'c'); // -> 2
 * test_04:
 * const edges = [
 *   ['a', 'c'],
 *   ['a', 'b'],
 *   ['c', 'b'],
 *   ['c', 'd'],
 *   ['b', 'd'],
 *   ['e', 'd'],
 *   ['g', 'f']
 * ];
 *
 * shortestPath(edges, 'b', 'g'); // -> -1
 * test_05:
 * const edges = [
 *   ['c', 'n'],
 *   ['c', 'e'],
 *   ['c', 's'],
 *   ['c', 'w'],
 *   ['w', 'e'],
 * ];
 *
 * shortestPath(edges, 'w', 'e'); // -> 1
 * test_06:
 * const edges = [
 *   ['c', 'n'],
 *   ['c', 'e'],
 *   ['c', 's'],
 *   ['c', 'w'],
 *   ['w', 'e'],
 * ];
 *
 * shortestPath(edges, 'n', 'e'); // -> 2
 * test_07:
 * const edges = [
 *   ['m', 'n'],
 *   ['n', 'o'],
 *   ['o', 'p'],
 *   ['p', 'q'],
 *   ['t', 'o'],
 *   ['r', 'q'],
 *   ['r', 's']
 * ];
 *
 * shortestPath(edges, 'm', 's'); // -> 6
 *
 * Breadth First is the best choice to find the shortest path between two nodes in a graph
 * because all directions are explored evenly. The first path found via breadth first
 * is the shortest path.
 * */

public class ShortestPath {

    public static int shortestPath(char[][] edges, Character src, Character dst){
        Map<Character, List<Character>> graph = buildGraph(edges);
        Queue<Pair<Character, Integer>> queue = new LinkedList<>();
        Set<Character> visited = new LinkedHashSet<>();

        if (src != null) queue.add(new Pair<>(src, 0));

        while (!queue.isEmpty()){
            Pair<Character, Integer> currentPair = queue.poll();

            Character currentNode = currentPair.getKey();
            int currentDistance = currentPair.getValue();

            if (currentNode == dst) return currentDistance;

            visited.add(currentNode);

            for (Character neighbor: graph.get(currentNode)){
                if (!visited.contains(neighbor)) queue.add(new Pair<>(neighbor, currentDistance+1));
            }
        }
        return  -1;
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
                {'w', 'x'},
                {'x', 'y'},
                {'z', 'y'},
                {'z', 'v'},
                {'w', 'v'}};

        System.out.println(shortestPath(edges, 'w', 'z'));
        System.out.println(shortestPath(edges, 'y', 'x'));
    }
}
