package linkedLists;

public class App {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        // create lists
        singlyLinkedList.insertLast(10);
        singlyLinkedList.insertLast(20);
        singlyLinkedList.insertLast(30);

        // print the list
        singlyLinkedList.display();

        singlyLinkedList.insert(25, 2);
        singlyLinkedList.insert(35, 4);
        singlyLinkedList.insert(15, 1);
        singlyLinkedList.insertFirst(5);
        singlyLinkedList.insertLast(40);
        singlyLinkedList.insertFirst(4);

        singlyLinkedList.display();

    }
}
