package queue;

public class QueueLinkedList {
    Node front;
    Node rear;

    public QueueLinkedList(){

    }

    public void enqueue(int val){
        Node node = new Node(val);

        if (isEmpty()){
            front = node;
            rear = node;
        }else {
            node.next = front;
            front = node;
        }
    }

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
