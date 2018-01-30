package Ch02_LinkedList;

/**
 * Custom implementation of a singly linked list.
 *
 * A double linked list would also contain a "prev" node.
 */
public class CustomLinkedList {
    private CustomNode head;

    public void append(int value) {
        if (this.head == null) {
            this.head = new CustomNode(value);

            return;
        }

        CustomNode current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new CustomNode(value);
    }

    public void prepend(int value) {
        CustomNode newHead = new CustomNode(value);
        newHead.next = this.head;
        this.head = newHead;
    }

    public static void main(String[] args) {
        CustomLinkedList myList = new CustomLinkedList();
        myList.append(10);
        myList.append(20);
    }
}
