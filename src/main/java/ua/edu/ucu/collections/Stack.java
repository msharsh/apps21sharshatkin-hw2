package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    ImmutableLinkedList stack;

    public Stack() {
        stack = new ImmutableLinkedList();
    }

    public void push(Object e) {
        stack = stack.addLast(e);
    }

    public Object pop()
    {
        Object last = this.peek();
        stack = stack.removeLast();
        return last;
    }

    public Object peek() {
        return stack.getLast();
    }
}
