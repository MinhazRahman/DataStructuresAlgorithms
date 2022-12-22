package stacks;

public class MyStack {
    int size;
    int top;
    int[] stack;

    // constructor
    public MyStack(int size){
        this.size = size;
        top = -1;
        stack = new int[size];
    }

    // insert the value onto the stack
    public int push(int val){
        if(isFull()){
            return -1;
        }else {
            top++;
            stack[top] = val;
        }
        return val;
    }

    // remove the top element from the stack
    public int pop(){
        int topVal = -1;
        if (isEmpty()){
            return topVal;
        }else {
            topVal = stack[top];
            top--;
        }
        return topVal;
    }

    public int peek(){
        int val = -1;
        if (isEmpty()){
            return val;
        }else {
            val = stack[top];
        }
        return val;
    }


    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size - 1;
    }

    public void printStack(){
        for (int i = top; i >= 0; i--){
            System.out.println(stack[i]);
        }
    }
}
