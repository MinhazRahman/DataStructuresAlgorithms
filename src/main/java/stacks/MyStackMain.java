package stacks;

public class MyStackMain {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(4);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        myStack.printStack();
        System.out.println("Popped value: " + myStack.pop());
        myStack.printStack();
        System.out.println("Get the top value: " + myStack.peek());
        myStack.printStack();
    }
}
