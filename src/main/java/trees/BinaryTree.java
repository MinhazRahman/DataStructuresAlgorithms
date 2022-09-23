package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
}
