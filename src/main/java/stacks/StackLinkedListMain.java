package stacks;

public class StackLinkedListMain {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        System.out.println("Is empty? " + stack.isEmpty());

        // insert element onto the stack
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.push(25);

        // print the stack
        stack.printStack();

        int pos = 3;
        System.out.println("Value at position " + pos + " is " + stack.peek(pos));
        pos = 4;
        System.out.println("Value at position " + pos + " is " + stack.peek(pos));
        pos = 5;
        System.out.println("Value at position " + pos + " is " + stack.peek(pos));
        pos = 0;
        System.out.println("Value at position " + pos + " is " + stack.peek(pos));

        System.out.println();
        // pop an element from the stack
        stack.pop();

        // print the stack
        stack.printStack();

        System.out.println("Is empty? " + stack.isEmpty());
    }
}
