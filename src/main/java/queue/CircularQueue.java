package queue;

/**
 * Circular indices: Circular indices can be obtained using modular arithmetic
 * i = (i + 1) % size (Here % is the modulus operator)
 * i = (i + 1) % array_length
 *
 * */

public class CircularQueue {
    int front;
    int rear;
    int size;
    int[] queue;

    public CircularQueue(int size){
        front = 0;
        rear = 0;
        this.size = size;
        queue = new int[size];
    }

    public boolean enqueue(int val){
        if (isFull()){
            return false;
        }else {
            rear = (rear + 1) % size;
            queue[rear] = val;
        }
        return true;
    }

    public int dequeue(){
        int val = -1;
        if(isEmpty()){
            return  val;
        }else {
            front = (front + 1) % size;
            val = queue[front];
        }
        return val;
    }

    public int getFront(){
        return queue[(front + 1) % size];
    }

    public int getRear(){
        return queue[(rear%size)];
    }

    public boolean isFull(){
        return (rear + 1) % size == front;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public void printQueue(){
        int i = front + 1;
        do {
            System.out.print(queue[i] + " ");
            i = (i + 1) % size;
        }while (i != (rear + 1) % size);
        System.out.println();
    }
}
