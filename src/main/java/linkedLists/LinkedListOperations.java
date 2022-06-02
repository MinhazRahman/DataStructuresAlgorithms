package linkedLists;

public class LinkedListOperations {

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

    // Insert into the front of the list
    public static Node insertFirst(Node head, int data){
        // create the new node
        Node node = new Node(data);

        if (head == null){
            head = node;
            return head;
        }
        // next pointer of the new node will point to the old first node
        node.next = head;
        // head of the list points to the new node
        head = node;
        return head;
    }

    // Insert a node at a particular position
    public static Node insertAt(Node head, int data, int pos){
        if (pos > countNodes(head)){
            return head;
        }

        // create a new node
        Node node = new Node(data);
        Node current = head;
        int count = 1; // keep record of the number of traversed nodes

        if (pos == 0){ // insert node at the front
            // next pointer of the new node will point to the old first node
            node.next = head;
            // head of the list points to the new node
            head = node;
            return head;
        }

        // traverse the list till node count == pos
        while (count < pos){
            current = current.next;
            count++;
        }

        // insert the new node
        node.next = current.next;
        current.next = node;

        return head;
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

        Node newHead =  insertAt(head, 55, 5);
        display(newHead);
    }
}
