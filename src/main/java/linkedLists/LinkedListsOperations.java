package linkedLists;

public class LinkedListsOperations {

    // display the list using iterative method
    public static void display(Node head){
        // create a new node that points to the same node
        // that the head node points to
        Node node = head;
        while (node != null){
            System.out.println(node);
            node = node.next;
        }
    }

    // display the node using recursive method
    public static void displayRecursively(Node node){
        // base case
        if (node == null){
            return;
        }
        // recursive step
        System.out.println(node);
        displayRecursively(node.next);
    }

    // display the nodes in reverse order using recursive method
    // This will change the head: head will no longer point to the first node
    public static void displayInReverseOrder(Node node){
        // base case
        if (node == null){
            return;
        }
        // recursive step
        displayInReverseOrder(node.next);
        System.out.println(node);
    }

    // Counting Nodes in a list iteratively
    public static int countNodes(Node head){
        int count = 0;
        // create a new node that points to the same node that
        // the head points to
        Node node = head;
        while (node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    // Counting Nodes in a list recursively
    // This will change the head: head will no longer point to the first node
    public static int getCount(Node node){
        // base case
        if (node == null){
            return 0;
        }
        // recursive step
        return 1 + getCount(node.next);
    }

    // Sum of all the nodes in the list
    public static int sumOfNodValues(Node head){
        int sum = 0;
        Node node = head;
        while (node != null){
            sum += node.data;
            node = node.next;
        }
        return sum;
    }

    // Sum of all the nodes in the list
    public static int sum(Node node){
        // base case
        if (node == null){
            return 0;
        }
        // recursive step
        return node.data + sum(node.next);
    }

    // Find the maximum value in the list
    public static int maximum(Node head){
        int max = Integer.MIN_VALUE;
        while (head != null){
           if (head.data > max){
               max = head.data;
           }
           head = head.next;
        }
        return max;
    }

    // Find the maximum value in the list using recursion
    public static int maximumRecursive(Node head){
        int x = 0;
        if (head == null){
            return Integer.MIN_VALUE;
        }
        x = maximumRecursive(head.next);
        return x > head.data? x:head.data; // Math.max(x, head.data);
    }


    public static void main(String[] args) {
        // Form a Linked lists
        // Define the head node
        Node head = new Node();

        // Define the intermediate nodes
        Node A = new Node(10);
        Node B = new Node(20);
        Node C = new Node(30);
        Node D = new Node(40);

        // Form the linked list as: head -> A -> B -> C -> D
        head = A;
        A.next = B;
        B.next = C;
        C.next = D;

        // operations
        display(head);
        System.out.println();

        display(B);
        System.out.println();

        displayRecursively(head);
        System.out.println();

        displayInReverseOrder(head);

        // count the number of nodes in a list
        System.out.println(countNodes(head));
        System.out.println(getCount(head));
        System.out.println(sumOfNodValues(head));
        System.out.println(sum(head));

        System.out.println(maximum(head));

        System.out.println(maximumRecursive(head));

    }
}
