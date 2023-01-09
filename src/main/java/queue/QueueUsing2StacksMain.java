package queue;

public class QueueUsing2StacksMain {
    public static void main(String[] args) {
        QueueUsing2Stacks queue = new QueueUsing2Stacks();

        // insert values
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        // delete values from the queue
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
