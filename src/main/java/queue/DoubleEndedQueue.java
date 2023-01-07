package queue;

/**
 * Queue:
 * enqueue(), front: insert? No, delete? Yes
 * dequeue(), rear: insert? Yes, delete? No
 *
 * Double Ended Queue:
 * enqueue(), front: insert? Yes, delete? Yes
 * dequeue(), rear: insert? Yes, delete? Yes
 *
 * */

public class DoubleEndedQueue {
    Node front;
    Node rear;

    public DoubleEndedQueue(){

    }

    public void insertAtFront(int val){
        Node node = new Node(val);

        // heap memory if full, we can't create any object in the heap
        if (isFull()) return;

        if (isEmpty()){
            front = node;
            rear = node;
        }else {
            node.next = front;
            front = node;
        }
    }

    public void insertAtRear(int val){
        Node node = new Node(val);

        if (isFull()) return;

        if (isEmpty()){
            front = node;
        }else {
            rear.next = node;
        }
        rear = node;
    }

    public int deleteFromFront(){
        int x = -1;
        if (isEmpty()) return x;

        x = front.data;
        front = front.next;
        return x;
    }

    public int deleteFromRear(){
        int x = -1;
        if (isEmpty()) return x;

        // find the node before the last node
        Node current = front;
        while (current.next.next != null){
            current = current.next;
        }

        x = rear.data;
        // rewire the rear pointer
        rear = current;
        current.next = null;
        return x;
    }

    public boolean isFull(){
        Node node = new Node();
        return node == null;
    }

    public boolean isEmpty(){
        return rear == null;
    }

    public void printQueue(){
        Node current = front;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
