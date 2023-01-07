package queue;

public class QueueLinkedListDemo {
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        // insert nodes into the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // print queue
        queue.printQueue();

        // dequeue
        queue.dequeue();

        // print queue
        queue.printQueue();
    }
}
