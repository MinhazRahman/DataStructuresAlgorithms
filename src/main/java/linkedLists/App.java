package linkedLists;

public class App {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        // create lists
        singlyLinkedList.insertLast(1);
        singlyLinkedList.insertLast(2);
        singlyLinkedList.insertLast(3);
        singlyLinkedList.insertLast(4);
        singlyLinkedList.insertLast(5);
        singlyLinkedList.insertLast(6);
        singlyLinkedList.insertLast(7);

        singlyLinkedList.display();
        singlyLinkedList.printOddNodes();
        singlyLinkedList.printEvenNodes();

    }
}
