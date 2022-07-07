package strings;

import javafx.util.Pair;

import java.util.*;

/**
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 * */

public class WordLadder2 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = buildGraph(wordList);
        if (!wordList.contains(beginWord)) {
            graph.put(beginWord, Collections.singletonList(wordList.get(0)));
        }

        // queue for breath first order
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        // set to store the list of already visited nodes
        Set<String> visited = new LinkedHashSet<>();

        // we will create a pair of node and its distance from the source
        // pair = (src, distance-from-the-source), pair = (w,0)
        // add the source to the queue
        queue.add(new Pair<>(beginWord, 0)); // source node src is 0 edges away from itself
        visited.add(beginWord);

        while (!queue.isEmpty()){
            // pop the head from the queue
            Pair<String, Integer> currentPair = queue.poll();

            String currentNode = currentPair.getKey();
            int distance = currentPair.getValue();

            if (currentNode.equals(endWord)){
                return distance+1;
            }

            List<String> neighbors = graph.get(currentNode);
            for (String node: neighbors){
                if (!visited.contains(node)){
                    queue.add(new Pair<>(node, distance+1));
                    // add the current to visited set of nodes
                    visited.add(node);
                }
            }
        }

        return -1;
    }

    public static Map<String, List<String>> buildGraph(List<String> wordList){
        Map<String, List<String>> graph = new HashMap<>();

        for (String word: wordList){
            for (String word1: wordList){

                String nodeA = word;
                String nodeB = word1;

                if (!graph.containsKey(nodeA)){
                    graph.put(nodeA, Collections.emptyList());
                }

                if(!graph.containsKey(nodeB)){
                    graph.put(nodeB, Collections.emptyList());
                }

                if (isDifferBySingleCharacter(word,word1)){

                    List<String> setA = new ArrayList<>(graph.get(nodeA));
                    setA.add(nodeB);
                    graph.put(nodeA, setA);

                    List<String> setB = new ArrayList<>(graph.get(nodeB));
                    setB.add(nodeA);
                    graph.put(nodeB,setB);
                }
            }
        }
        return graph;
    }

    public static boolean isDifferBySingleCharacter(String word1, String word2){
        if (word1.length() != word2.length()){
            return false;
        }

        int diffs = 0;

        for (int i=0; i<word1.length(); i++){
            char ch = word1.charAt(i);
            if (word2.indexOf(ch) == -1){ // if ch is not in word2 then it returns -1
                diffs++;
            }
        }
        return diffs == 1;
    }

    public static void  printGraph(Map<String, List<String>> graph){
        for (Map.Entry<String, List<String>> entry: graph.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static void main(String[] args) {

        // Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        List<String> wordList = new ArrayList<>(Arrays.asList("most","mist","miss","lost","fist","fish"));

        String beginWord = "lost";
        String endWord =  "miss";

        Map<String, List<String>> graph = buildGraph(wordList);
        if(!wordList.contains(beginWord)) {
            graph.put(beginWord, Collections.singletonList(wordList.get(0)));
        }

        printGraph(graph);

        // call the ladder length
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
