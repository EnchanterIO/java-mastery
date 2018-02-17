package Ch03_Stacks_Queues;

public class CustomQueueNode<T> {
    private T data;
    protected CustomQueueNode<T> next;

    public CustomQueueNode(T data) {
        this.data = data;
    }

    public T data() {
        return this.data;
    }
}
