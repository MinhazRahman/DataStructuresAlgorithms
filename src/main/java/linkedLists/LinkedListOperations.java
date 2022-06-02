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

    // Search node in a linked list
    public static Node search(Node head, int key){
        Node node = head;

        while (node != null){
            if (node.data == key){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // Search node in a linked list recursively
    public static Node searchRecur(Node node, int key){

        // base cases
        if (node == null){
            return null;
        }
        if (node.data == key){
            return node;
        }

        // recursive step
        return searchRecur(node.next, key);
    }

    // Improve linear search through 1) Move Node to Head: two pointer method

    // Return the next node of the matching node
    public static Node nextNode(Node head, int key){
        Node node = head;

        while (node != null){
            if (node.data == key){
                return node.next;
            }
            node = node.next;
        }
        return null;
    }

    // Return the previous node of the matching node
    public static Node previousNode(Node node, int key){
        Node previous = new Node();

        while (node != null){
            if (node.data == key){
                return previous;
            }
            previous = node;
            node = node.next;
        }
        return null;
    }

    // Delete the matching node from the list
    public static Node deleteNode(Node head, int key){
        Node previous = new Node();
        Node node = head;

        while (node != null){
            if (node.data == key){ // delete the matching node

                // previous node of the matching node points to the next node of the matching node
                previous.next = node.next;
                // After this line, there is no pointer to the matching node

                return node;
            }
            previous = node;
            node = node.next;
        }
        return null;
    }

    // Move the matching node to the first position in the list
    public static Node moveToFront(Node head, int key){
        Node previous = new Node();
        Node node = head;

        while (node != null){
            if (node.data == key){

                // previous node of the matching node points to the next node of the matching node
                previous.next = node.next;
                // After this line, there is no pointer to the matching node

                node.next = head; // the next pointer of matching node points to the old first node
                head = node; // head points to the matching node/new first node

                return head;
            }
            previous = node;
            node = node.next;
        }
        return null;
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
        Node E = new Node(50);
        Node F = new Node(60);

        // Form the linked list as: head -> A -> B -> C -> D -> E -> F -> null
        head = A;
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;

        // operations
        display(head);
        System.out.println();

        Node newHead =  moveToFront(head, 30);
        display(newHead);
    }
}
