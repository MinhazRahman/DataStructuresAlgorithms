package queue;

public class CircularQueueMain {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(7);

        // insert elements to the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        // print the queue
        queue.printQueue();

        // dequeue element
        queue.dequeue();

        // get the front element
        System.out.println(queue.getFront());

        // print the queue
        queue.printQueue();
    }
}
