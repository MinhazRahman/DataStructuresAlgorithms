package trees;

public class Main {

    public static void main(String[] args) {
        // create an object
        BreathFirstOrder tree = new BreathFirstOrder();

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

        // print the depth first tree values
        System.out.println(tree.breathFirstValues(a));

    }
}
