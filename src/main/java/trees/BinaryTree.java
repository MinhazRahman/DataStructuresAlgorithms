package trees;

import java.util.*;

public class BinaryTree {
    Node root;

    public BinaryTree(){

    }

    // count the number of nodes in a binary tree
    public int count(Node node){
        int x, y;

        // recursive steps
        if (node != null){
            x = count(node.left);
            y = count(node.right);

            return  x + y + 1;
        }
        // base case
        return 0;
    }

    // count the number of nodes
    public int countNode(Node node){
        int x, y;

        if (node == null){
            return 0;
        }

        x = countNode(node.left);
        y = countNode(node.right);

        return x + y + 1;

    }

    // pre order traversal: visit(node), preOrder(left), preOrder(right)
    public void preOrder(Node node){
        // base case
        if (node == null){
            return;
        }

        // recursive steps
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    // inorder traversal: inOrder(left), visit(node), inOrder(right)
    public void inOrder(Node node){
        // base case
        if (node == null){
            return;
        }

        // recursive steps
        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    // postorder traversal: postOrder(left), postOrder(right), visit(node)
    public void postOrder(Node node){
        // base case
        if (node == null){
            return;
        }

        // recursive steps
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }

    // level order traversal
    public void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();

        if (root != null){
            queue.add(root);
        }else {
            return;
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    public int countNodes(Node node){
        if (node == null){
            return 0;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // In a tree, a node is a leaf if it doesn't have any left child or any right child;
    public int countLeaves(Node node){
        // base case
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return 1;
        }

        // recursive step
        return countLeaves(node.left) +  countLeaves(node.right);
    }

    // In a tree, a node is a leaf if it doesn't have any left child or any right child;
    public int sumOfLeaves(Node node){
        // base case
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return node.data;
        }

        // recursive step
        return sumOfLeaves(node.left) +  sumOfLeaves(node.right);
    }

    // In a tree, a node is a leaf if it doesn't have any left child or any right child;
    public int sumOfLeftLeaves(Node node){
        // base case
        if (node == null){
            return 0;
        }
        if (node.left != null && node.left.left == null && node.left.right == null){
            return node.left.data;
        }

        // recursive step
        return sumOfLeftLeaves(node.left) +  sumOfLeftLeaves(node.right);
    }

    // In a tree, a node is a leaf if it doesn't have any left child or any right child;
    public int sumOfRightLeaves(Node node){
        // base case
        if (node == null){
            return 0;
        }
        if (node.right != null && node.right.left == null && node.right.right == null){
            return node.right.data;
        }

        // recursive step
        return sumOfRightLeaves(node.left) +  sumOfRightLeaves(node.right);
    }

    // A binary tree is strict is every node has o or 2 child nodes.
    public boolean isStrict(Node root) {
        if(root == null){
            return true;
        }
        else if(root.left == null && root.right == null){
            return true;
        }else if(root.left != null && root.right == null){
            return false;
        }else if(root.left == null){
            return false;
        }

        return isStrict(root.left) && isStrict(root.right);
    }

    public int minDepth(Node root) {

        int x=0, y=0;

        if(root == null){
            return 0;
        }

        x = minDepth(root.left);
        y = minDepth(root.right);

        if(root.left == null){
            return y + 1;
        }

        if (root.right == null){
            return x + 1;
        }

        return Math.min(x,y) + 1;

    }

    // find the minimum tree value recursively
    public int minTreeValue(Node root){
        if(root == null) return Integer.MAX_VALUE;

        int leftMin = minTreeValue(root.left);
        int rightMin = minTreeValue(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    // calculate the sum of all the tree values recursively
    public int treeSum(Node root){
       if (root == null) return 0;

       return root.data + treeSum(root.left) + treeSum(root.right);
    }

    // find a value in a binary tree recursively
    public boolean isInclude(Node root, int target){
        if(root == null) return false;
        if (root.data == target) return true;

        return isInclude(root.left, target) || isInclude(root.right, target);
    }

    // count the number of target value recursively
    public int countTreeValue(Node root, int target){
        if (root == null) return 0;
        if (root.data == target){
            return 1 + countTreeValue(root.left, target) + countTreeValue(root.right, target);
        }else {
            return countTreeValue(root.left, target) + countTreeValue(root.right, target);
        }
    }

    /**
     * Write a function, maxPathSum, that takes in the root of a binary tree that contains number values.
     * The function should return the maximum sum of any root to leaf path within the tree.
     *
     * You may assume that the input tree is non-empty.
     * First version:
     * const maxPathSum = (root) => {
     *   if(root == null) return -Infinity;
     *   if(root.left == null && root.right == null) return root.val;
     *
     *   let maxChild = Math.max(maxPathSum(root.left), maxPathSum(root.right));
     *   return root.val + maxChild;
     * };
     *
     * Second version:
     * const maxPathSum = (root) => {
     *   if(root == null) return -Infinity;
     *   if(root.left == null && root.right == null) return root.val;
     *
     *   let maxLeftPathSum = maxPathSum(root.left);
     *   let maxRightPathSum = maxPathSum(root.right);
     *
     *   return root.val + Math.max(maxLeftPathSum, maxRightPathSum);
     * };
     * */

    /**
     *                  2
     *                /   \
     *               3     4
     *              / \     \
     *             2   6     8
     *
     * */
    public int maxPathSum(Node root){
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) return root.data;

        return root.data + Math.max(maxPathSum(root.left), maxPathSum(root.right));
    }

    /** Write a function, pathFinder, that takes in the root of a binary tree and a target value.
     * The function should return an array representing a path to the target value.
     * If the target value is not found in the tree, then return null.
     * You may assume that the tree contains unique values.
     *
     * const pathFinder = (root, target) => {
     *   let result = pathFinderHelper(root, target);
     *
     *   if(result == null){
     *     return result;
     *   }else{
     *     return result.reverse();
     *   }
     * }
     * const pathFinderHelper = (root, target) => {
     *   if(root == null) return null;
     *   if(root.val == target) return [root.val];
     *
     *   let leftPath = pathFinderHelper(root.left, target);
     *   let rightPath = pathFinderHelper(root.right, target);
     *
     *   if(leftPath != null) {
     *     leftPath.push(root.val);
     *     return leftPath;
     *   }
     *   if(rightPath != null){
     *     rightPath.push(root.val);
     *     return rightPath;
     *   }
     *   return null;
     * };
     * */
    public List<Integer> pathFinder(Node root, int target){
        List<Integer> result = pathFinderHelper(root, target);

        if (result == null){
            return null;
        }else {
            Collections.reverse(result);
            return result;
        }
    }

    public List<Integer> pathFinderHelper(Node root, int target){
        if (root == null) return null;
        if (root.data == target){
            List<Integer> path = new ArrayList<>();
            path.add(root.data);
            return path;
        }

        List<Integer> leftPath = pathFinderHelper(root.left, target);
        List<Integer> rightPath = pathFinderHelper(root.right, target);

        if (leftPath != null){
            leftPath.add(root.data);
            return leftPath;
        }

        if (rightPath != null){
            rightPath.add(root.data);
            return rightPath;
        }

        return null;
    }
    

    /** Write a function, treeLevels, that takes in the root of a binary tree.
     * The function should return a 2-Dimensional array where each subarray represents a level of the tree.
     *
     * */
    public List<List<Integer>> treeLevels(Node root){
        List<List<Integer>> levels = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node current = queue.poll();
                level.add(current.data);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            levels.add(level);
        }
        return levels;
    }

    /**Write a function, levelAverages, that takes in the root of a binary tree that contains number values.
     * The function should return an array containing the average value of each level.
     * */
    public List<Double> treeLevelAverages(Node root){
        List<Double> levelAverages = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()){
            double levelSum = 0.0;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Node current = queue.poll();
                levelSum += current.data;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            levelAverages.add(levelSum/size);
        }
        return levelAverages;
    }

    /** Write a function, allTreePaths, that takes in the root of a binary tree.
     * The function should return a 2-Dimensional array where each subarray represents a root-to-leaf path in the tree.
     * The order within an individual path must start at the root and end at the leaf,
     * but the relative order among paths in the outer array does not matter.
     * You may assume that the input tree is non-empty.
     * Javascript solution:
     * const allTreePaths = (root) => {
     *   if(root == null) return [];
     *   if(root.left == null && root.right == null) return [[root.val]];
     *
     *   let paths = [];
     *
     *   let leftSubPaths = allTreePaths(root.left);
     *   for(let leftSubPath of leftSubPaths){
     *     paths.push([root.val, ...leftSubPath]);
     *   }
     *
     *   let rightSubPaths = allTreePaths(root.right);
     *   for(let rightSubPath of rightSubPaths){
     *     paths.push([root.val, ...rightSubPath]);
     *   }
     *
     *   return paths;
     * };
     * */
    public List<List<Integer>> allTreePaths(Node root){
        if(root == null) return Collections.emptyList();
        if(root.left == null && root.right == null) {
            List<List<Integer>> listPath = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            path.add(root.data);
            listPath.add(path);
            return listPath;
        }

        List<List<Integer>> treePaths = new ArrayList<>();

        List<List<Integer>> leftSubPaths = allTreePaths(root.left);
        for (List<Integer> leftSubPath: leftSubPaths){
            leftSubPath.add(0,root.data);
            treePaths.add(leftSubPath);
        }

        List<List<Integer>> rightSubPaths = allTreePaths(root.right);
        for (List<Integer> rightSubPath: rightSubPaths){
            rightSubPath.add(0,root.data);
            treePaths.add(rightSubPath);
        }

        return treePaths;
    }
}
