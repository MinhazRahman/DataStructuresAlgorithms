package trees;

public class Node {
    Node left;
    int data;
    Node right;

    public Node(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

