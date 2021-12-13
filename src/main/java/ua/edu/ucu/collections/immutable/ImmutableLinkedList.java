package ua.edu.ucu.collections.immutable;

import java.util.Objects;

public final class ImmutableLinkedList implements ImmutableList {
    private Node first;
    private Node last;
    private final int size;

    public ImmutableLinkedList(Object[] elements) {
        size = elements.length;
        if (size != 0) {
            first = new Node();
        }
        Node curr = first;
        for (int i = 0; i < size - 1; ++i) {
            curr.setValue(elements[i]);
            Node next = new Node();
            curr.setNext(next);
            next.setPrevious(curr);
            curr = next;
        }
        last = curr;
        if (size != 0) {
            last.setValue(elements[size - 1]);
            last.setNext(null);
        }
    }

    public ImmutableLinkedList() {
        size = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return this.addAll(size, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return this.addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 0) {
            return new ImmutableLinkedList(c);
        }
        Object[] newLst = new Object[size + c.length];
        Node element = first;
        for (int i = 0; i < index; ++i) {
            newLst[i] = element.getValue();
            element = element.getNext();
        }
        for (int i = index; i < index + c.length; ++i) {
            newLst[i] = c[i - index];
        }
        for (int i = index + c.length; i < size + c.length; ++i) {
            newLst[i] = element.getValue();
            element = element.getNext();
        }
        return new ImmutableLinkedList(newLst);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node element = first;
        int counter = 0;
        while (counter != index) {
            element = element.getNext();
            ++counter;
        }
        return element.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newLst = new Object[size-1];
        Node element = first;
        for (int i = 0; i < index; ++i) {
            newLst[i] = element.getValue();
            element = element.getNext();
        }
        element = element.getNext();
        for (int i = index; i < size - 1; ++i) {
            newLst[i] = element.getValue();
            element = element.getNext();
        }
        return new ImmutableLinkedList(newLst);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList newLst = this.remove(index);
        return newLst.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node element = first;
        int counter = 0;
        while (element.getNext() != null && !Objects.equals(e, element.getValue())) {
            element = element.getNext();
            ++counter;
        }
        if (counter == size - 1) {
            throw new IllegalArgumentException();
        }
        return counter;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node element = first;
        int counter = 0;
        while (element != null) {
            arr[counter] = element.getValue();
            element = element.getNext();
            ++counter;
        }
        return arr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) this.add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) this.add(size, e);
    }

    public Node getHead() {
        return first;
    }

    public Node getTail() {
        return last;
    }

    public Object getFirst() {
        return first.getValue();
    }

    public Object getLast() {
        return last.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) this.remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) this.remove(size - 1);
    }
}
