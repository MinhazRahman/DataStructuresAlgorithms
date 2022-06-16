package trees;

public class App {
    public static void main(String[] args) {
        // create an object
        BinaryTree tree = new BinaryTree();

        // create nodes
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        Node g = new Node(8);

        // create the binary tree manually
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        // count the nodes in a tree
        System.out.println(tree.countNodes(a));

        System.out.println("Pre order traversal(node, left, right): ");
        tree.preOrder(a);

        System.out.println("In order traversal(left, node, right): ");
        tree.inOrder(a);

        System.out.println("Post order traversal(left, right, node): ");
        tree.postOrder(a);

        System.out.println("Level order traversal: ");
        tree.levelOrder(a);

        // count the number of leaves in a tree
        System.out.println("Number of leaves: " + tree.countLeaves(a));

        // check if a binary tree is balanced or not
        System.out.println("Is balanced?" + tree.isStrict(a));

    }
}
