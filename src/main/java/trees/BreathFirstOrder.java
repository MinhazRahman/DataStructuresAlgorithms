package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Write a function, breadthFirstValues, that takes in the root of a binary tree.
 * The function should return an array containing all values of the tree in breadth-first order.
 *
 * */

public class BreathFirstOrder extends BinaryTree{

    public List<Integer> breathFirstValues(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<Integer> bfValues = new ArrayList<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            bfValues.add(current.data);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return bfValues;
    }
}
