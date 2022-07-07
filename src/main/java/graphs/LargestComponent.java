package graphs;

import java.util.*;

public class LargestComponent {

    static Set<Integer> visited = new LinkedHashSet<>();

    public static int largestComponent(Map<Integer, List<Integer>> graph){

        int largest = 0;

        // iterate over each node
        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()){
            largest = Math.max(DFS(graph, entry.getKey()), largest);
        }

        return largest;
    }

    private static int bfs(Map<Integer, List<Integer>> graph, int src) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        queue.add(src);

        while (!queue.isEmpty()){
            int current = queue.poll();

            if (!visited.contains(current)){
                visited.add(current);
                count++;
            }

            List<Integer> neighbors = graph.get(current);
            for (int node: neighbors){
                if (!visited.contains(node)){
                    queue.add(node);
                }
            }
        }
        return count;
    }

    private static int iterativeDFS(Map<Integer, List<Integer>> graph, int src) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        stack.push(src);

        while (!stack.isEmpty()){
            int current = stack.pop();

            if (!visited.contains(current)){
                visited.add(current);
                count++;
            }

            List<Integer> neighbors = graph.get(current);
            for (int node: neighbors){
                if (!visited.contains(node)){
                    stack.push(node);
                }
            }
        }
        return count;
    }

    private static int DFS(Map<Integer, List<Integer>> graph, int current){

        // base case
        if (visited.contains(current)){
            return 0;
        }

        // add the current node to the set of visited nodes
        visited.add(current);

        // count new added node
        int count = 1;

        // explore the neighbors of current node
        List<Integer> neighbors = graph.get(current);
        for (int node: neighbors){
            count += DFS(graph, node);
        }

        return count;
    }

    public static int GCD(int num1, int num2){
        while (num1 != num2) {
            if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        return num2;
    }

    public static int gcd(int num1, int num2){
        int gcd = 1;
        for(int i = 1; i <= num1 && i <= num2; i++)
        {
            if(num1%i==0 && num2%i==0)
                gcd = i;
        }

        return gcd;
    }

    public static boolean isCommonFactorGreaterThanOne(int num1, int num2){

        while (num1 != num2) {
            if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }

        return num2 > 1;
    }

    public static Map<Integer, Set<Integer>> buildGraph(int[] nums){
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){

                Integer nodeA = nums[i];
                Integer nodeB = nums[j];

                if (!graph.containsKey(nodeA)){
                    graph.put(nodeA, Collections.emptySet());
                }

                if(!graph.containsKey(nodeB)){
                    graph.put(nodeB, Collections.emptySet());
                }

                if (isCommonFactorGreaterThanOne(nums[i], nums[j])){

                    Set<Integer> setA = new HashSet<>(graph.get(nodeA));
                    setA.add(nodeB);
                    graph.put(nodeA, setA);

                    Set<Integer> setB = new HashSet<>(graph.get(nodeB));
                    setB.add(nodeA);
                    graph.put(nodeB,setB);
                }
            }
        }
        return graph;
    }

    public static void  printGraph(Map<Integer, Set<Integer>> graph){
        for (Map.Entry<Integer, Set<Integer>> entry: graph.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static void main(String[] args) {
        // an unordered undirected map that represents a graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // insert values to the map
        // undirected cyclic and disjoint graph
        graph.put(0, Arrays.asList(8, 1, 5));
        graph.put(1, Collections.singletonList(0));
        graph.put(5, Arrays.asList(0, 8));
        graph.put(8, Arrays.asList(0, 5));
        graph.put(2, Arrays.asList(3, 4));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, Arrays.asList(3, 2));

        // call the largest component
        System.out.println(largestComponent(graph));

        // call GCD
        System.out.println(GCD(21, 12));
        System.out.println(gcd(21, 12));
        System.out.println(isCommonFactorGreaterThanOne(50, 9));
        System.out.println(isCommonFactorGreaterThanOne(9, 20));
        System.out.println(isCommonFactorGreaterThanOne(20, 63));

        // build graph
        int[] nums = {2,3,6,7,4,12,21,39};
        Map<Integer, Set<Integer>> G = buildGraph(nums);
        printGraph(G);


    }
}
