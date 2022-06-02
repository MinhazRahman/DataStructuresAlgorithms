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

        singlyLinkedList.insertInSortedList(25);
        singlyLinkedList.insertInSortedList(5);
        singlyLinkedList.insertInSortedList(35);

        singlyLinkedList.display();

    }
}
