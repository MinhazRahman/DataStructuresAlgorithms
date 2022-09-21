package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Write a function, depthFirstValues, that takes in the root of a binary tree.
 * The function should return an array containing all values of the tree in depth-first order.
 *
 *
 * */

public class DepthFirstOrder extends BinaryTree{
    List<Integer> values = new ArrayList<>();

    public List<Integer> depthFirstValues(Node root){

        dfs(root);
        return values;
    }

    public void dfs(Node root){
        if (root == null) return;
        values.add(root.data);
        dfs(root.left);
        dfs(root.right);
    }

    public List<Integer> depthFirstValuesIteratively(Node root){
        List<Integer> dfsValues = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if (root != null){
            stack.push(root);
        }

        while (!stack.isEmpty()){
            Node current = stack.pop();
            // add the value of current node to the list
            dfsValues.add(current.data);
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return dfsValues;
    }
}
