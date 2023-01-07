package queue;

public class QueueLinkedList {
    Node front;
    Node rear;

    public QueueLinkedList(){

    }

    // insert at the back of the queue
    // use rear to insert values
    public void enqueue(int val){
        Node node = new Node(val);

        // heap memory if full, we can't create any object in the heap
        if (isFull()) return;

        if (isEmpty()){
            front = node;
        }else {
            rear.next = node;
        }
        rear = node;
    }

    // use front to delete values
    public int dequeue(){
        int val = -1;
        if (!isEmpty()){
           val = front.data;
           front = front.next;
        }
        return val;
    }

    public boolean isFull(){
        Node node = new Node(0);
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
