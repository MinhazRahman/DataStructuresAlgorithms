package trees;

public class BinaryTree {
    Node root;

    public BinaryTree(){

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
}
