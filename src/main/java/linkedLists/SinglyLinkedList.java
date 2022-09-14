package linkedLists;

public class SinglyLinkedList {
    // A pointer of type Node, that points to the first node
    Node head;
    Node tail;

    // constructor
    public SinglyLinkedList(){}

    public boolean isEmpty(){
        return head == null;
    }

    // display the list using iterative method
    public void display(){
        System.out.println("First-->Last");
        // create a new node that points to the same node
        // that the head node points to
        Node current = head;
        while (current != null){
            System.out.println(current);
            current = current.next;
        }
    }

    // display the list using iterative method
    public void display(Node node){
        System.out.println("First-->Last");
        // create a new node that points to the same node
        // that the head node points to
        Node current = node;
        while (current != null){
            System.out.println(current);
            current = current.next;
        }
    }

    // Counting Nodes in a list iteratively
    public int countNodes(){
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
    public Node deleteNode(int key){
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

    // delete the first node from the list
    public void deleteFirst(){
        Node oldFirst = head;

        head = head.next;  // old second node is now the new first node
        oldFirst.next = null; // old first node now points to null
    }

    // Move the matching node to the first position in the list
    public Node moveToFront(int key){
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
    public Node insertFirst(int data){
        // create the new node
        Node node = new Node(data);

        if (head == null){ // when the list is empty
            tail = node;
        }else {
            // next pointer of the new node will point to the old first node
            node.next = head;
        }
        // head of the list points to the new node/first node
        head = node;

        return head;
    }

    // Insert a node after a given position
    public Node insert(int data, int pos){

        // create a new node
        Node node = new Node(data);
        Node current = head; // at this point, current and head both points to the first node

        if (pos == 0){ // insert node at the front
            // next pointer of the new node will point to the old first node
            node.next = head;
            // head of the list points to the new node
            head = node;
            return head;
        }

        // keep record of the number of times we have to loop through
        // since we are already at first node, so initialize the count to 1
        int count = 1;

        // keep moving the pointer current
        while (count < pos && current.next != null){
            current = current.next;
            count++;
        }

        // insert the new node
        assert current != null;
        node.next = current.next;
        current.next = node;

        return head;
    }

    // Insert a node at the end of a linked list
    public void insertLast(int data){
        // create a new node
        Node node = new Node(data);

        if (head == null){ // when the list is empty,
            head = node;
        }
        else {
            tail.next = node;
        }
        tail = node;
    }

    // Insert in a sorted list
    public Node insertInSortedList(int data){
        // create the new node
        Node node = new Node(data);

        // if the list is empty
        if (head == null){
            head = node;
            return head;
        }

        // if data is smaller than the data of the first node
        // then, insert before the first node
        if (node.data < head.data){
            node.next = head;
            head = node;
            return head;
        }

        Node previous = null;
        Node current = head;
        while (current != null && current.data < data){
            previous = current;
            current = current.next;
        }

        // insert the node
        node.next = current;
        assert previous != null;
        previous.next = node;

        return head;
    }

    // print the odd nodes
    // The first node is considered odd, and the second node is even, and so on.
    public Node listOfOddNodes(){
        Node oddHead = head;
        Node odd = head;

        while (odd != null && odd.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
        }

        return oddHead;
    }

    // print the even nodes
    // The first node is considered odd, and the second node is even, and so on.
    public Node listOfEvenNodes(){
        Node evenHead = head.next;
        Node even = head.next;

        while (even != null && even.next != null){
            even.next = even.next.next;
            even = even.next;
        }
        return evenHead;
    }

    // interleave odds and evens
    public Node oddsEvens(){
        if (head == null || head.next == null){
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node headEven = even;

        while (odd != null && odd.next != null && even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        if (even != null){
            even.next = null;
        }
        if (odd != null){
            odd.next = headEven;
        }

        return head;
    }

    // reverse a linked list
    //  null        a -----> b -----> c -----> d -----> e -----> f (0) before entering the loop
    //  prev       curr
    // null <----- a     b -----> c -----> d -----> e -----> f (1) when enters the loop
    //            prev  curr    next
    // null <----- a <----- b       c -----> d -----> e -----> f (2)
    //                     prev     curr    next
    public Node reverse(Node head){
        Node previous = null;
        Node current = head;

        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

}
