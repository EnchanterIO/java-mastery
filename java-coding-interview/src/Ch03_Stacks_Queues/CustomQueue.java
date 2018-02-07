package Ch03_Stacks_Queues;

public class CustomQueue<T> {
    private CustomQueueNode<T> first;
    private CustomQueueNode<T> last;

    public void add(T item) {
        CustomQueueNode<T> newItemNode = new CustomQueueNode<>(item);

        if (this.first == null) {
            this.first = newItemNode;
            this.last = newItemNode;

            return;
        }

        this.last.next = newItemNode;
        this.last = newItemNode;
    }

    public T remove() {
        if (this.first == null) {
            throw new NullPointerException("Can't remove an element from an empty Queue!");
        }

        CustomQueueNode<T> nodeToRemove = this.first;

        this.first = this.first.next;

        if (this.first == null) {
            this.last = null;
        }

        return nodeToRemove.data();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T peek() {
        if (this.first == null) {
            throw new NullPointerException("Can't peek an element from an empty Queue!");
        }

        return this.first.data();
    }

    public static void main(String[] args) {
        CustomQueue<Integer> customQueue = new CustomQueue<>();
        customQueue.add(10);
        customQueue.add(20);
        customQueue.add(30);
        customQueue.add(40);
        customQueue.add(50);

        while (!customQueue.isEmpty()) {
            // Should print FIFO elements as: 10, 20, 30, 40, 50
            System.out.println(customQueue.remove());
        }

        System.out.println("Done");
    }
}
