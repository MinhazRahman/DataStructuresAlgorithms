package queue;

/** Implement Queue data structure using array
 * FIFO : First In First Out
 *
 * */

public class MyQueue {
    int front;
    int rear;
    int size;
    int[] queue;

    // constructor
    public MyQueue(int size){
        front = -1;
        rear = -1;
        this.size = size;
        queue = new int[size];
    }

    public boolean enqueue(int val){
        if (isFull()){
            return false;
        }else {
            rear++;
            queue[rear] = val;
        }
        return true;
    }

    public int dequeue(){
        int x = -1;
        if (isEmpty()){
            return x;
        }else {
            front++;
            x = queue[front];
        }
        return x;
    }

    public boolean isFull(){
        return rear == size - 1;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public void printQueue(){
        for (int i = front + 1; i <= rear; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}
