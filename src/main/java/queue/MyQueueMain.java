package queue;

public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);

        // append elements into the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); // will not be appended
        queue.enqueue(7); // will not be appended

        // print the queue
        queue.printQueue();

        // dequeue elements
        System.out.println(queue.dequeue());

        // print the queue
        queue.printQueue();
    }
}
