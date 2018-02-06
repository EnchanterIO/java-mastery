package Ch03_Stacks_Queues;

public class CustomStackNode<T> {
    private T data;
    protected CustomStackNode<T> next;

    public CustomStackNode(T data) {
        this.data = data;
    }

    public T data() {
        return this.data;
    }
}
