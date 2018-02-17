package Ch02_LinkedList;

import java.util.LinkedList;

/**
 * Custom implementation of a singly linked list.
 *
 * A double linked list would also contain a "prev" node.
 */
public class CustomLinkedList {
    private CustomNode head;

    public void add(int value) {
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

    public void remove(int index) throws IllegalArgumentException {
        if (this.head == null) {
            return;
        }

        if (index == 0) {
            this.head = head.next;

            return;
        }

        CustomNode current = head;
        int currentIndex = 0;

        while (current.next != null) {
            if (index == currentIndex+1) {
                current.next = current.next.next;

                return;
            }

            current = current.next;
            currentIndex++;
        }

        throw new IllegalArgumentException("No such a index has been found.");
    }

    public static void main(String[] args) {
        CustomLinkedList myList = new CustomLinkedList();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);
        myList.add(50);
        myList.add(60);
        myList.remove(4);

        LinkedList<Integer> officialList = new LinkedList<>();
        officialList.add(10);
        officialList.add(20);
        officialList.add(30);
        officialList.add(40);
        officialList.add(50);
        officialList.add(60);
        officialList.remove(4);

        System.out.println("Done.");
    }
}
