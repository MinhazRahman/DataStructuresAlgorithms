package linkedLists;

public class App {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        // create lists
        singlyLinkedList.insertFirst(30);
        singlyLinkedList.insertFirst(20);
        singlyLinkedList.insertFirst(10);

        // print the list
        singlyLinkedList.display();

        singlyLinkedList.insert(25, 2);
        singlyLinkedList.insert(35, 4);
        singlyLinkedList.insert(15, 1);
        singlyLinkedList.display();

    }
}
