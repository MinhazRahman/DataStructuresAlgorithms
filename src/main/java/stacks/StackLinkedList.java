package stacks;

/** Stack using linked list
 *
 * */
public class StackLinkedList {
    Node top;

    // empty constructor
    public StackLinkedList(){

    }

    // add an element to the stack
    public void push(int val){
        Node node = new Node(val);
        if (node == null){ // when the heap memory is full we will not be able to create a Node object
            System.out.println("Stack overflow");
        }else {
            node.next = top;
            top = node;
        }
    }

    // remove the top element from the stack
    public int pop(){
        int val = -1;

        if(isEmpty()){
           return val;
        }

        Node prev = top;
        top = top.next;

        val = prev.data;
        prev.next = null;

        return val;
    }

    public int peek(int pos){
        if(pos < 1){
           return -1;
        }

        Node current = top;
        for (int i = 0; current != null && i < pos -1; i++){
            current = current.next;
        }

        if (current != null) return current.data;
        return -1;
    }

    public int stackTop(){
        if (top != null){
            return top.data;
        }
        return -1;
    }

    public boolean isFull(){
        Node node = new Node();
        return node == null;
    }

    public boolean isEmpty(){
        return top == null;
    }
    public void printStack(){
        Node current = top;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
