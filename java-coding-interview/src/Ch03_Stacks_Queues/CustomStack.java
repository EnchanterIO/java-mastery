package Ch03_Stacks_Queues;

import java.util.EmptyStackException;

public class CustomStack<T> {
    private CustomStackNode<T> top;

    public void push(T item) {
        CustomStackNode<T> itemNode = new CustomStackNode<T>(item);
        itemNode.next = top;

        top = itemNode;
    }

    public T pop() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }

        CustomStackNode<T> peekNode = top;
        top = top.next;

        return peekNode.data();
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }

        return top.data();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println("Stack rocks!");
    }
}
