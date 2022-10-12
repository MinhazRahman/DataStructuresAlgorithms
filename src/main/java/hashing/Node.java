package hashing;

public class Node {
    int data;
    Node next;

    public Node(){}

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
