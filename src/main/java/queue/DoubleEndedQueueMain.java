package queue;

public class DoubleEndedQueueMain {
    public static void main(String[] args) {
        DoubleEndedQueue queue = new DoubleEndedQueue();

        // insert the elements in the queue
        queue.insertAtFront(1);
        queue.insertAtFront(2);
        queue.insertAtFront(3);
        queue.insertAtFront(4);

        // print the queue
        queue.printQueue();

        // insert at the rear
        queue.insertAtRear(5);
        queue.insertAtRear(6);

        // print the queue
        queue.printQueue();

        // delete from front
        queue.deleteFromFront();

        // print the queue
        queue.printQueue();

        // delete from rear
        queue.deleteFromRear();

        // print the queue
        queue.printQueue();
    }
}
