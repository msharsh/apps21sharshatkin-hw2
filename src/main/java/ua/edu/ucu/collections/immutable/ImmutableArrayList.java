package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] elements;

    public ImmutableArrayList(Object[] elements) {
        this.elements = elements;
    }

    public ImmutableArrayList() {
        elements = new Object[]{};
    }

    @Override
    public ImmutableList add(Object e)
    {
        return this.addAll(elements.length, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return this.addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c)
    {
        return this.addAll(elements.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newLst = new Object[c.length + elements.length];
        System.arraycopy(elements, 0, newLst, 0, index);
        for (int i = index; i < index + c.length; ++i) {
            newLst[i] = c[i - index];
        }
        for (int i = index + c.length; i < c.length + elements.length; ++i) {
            newLst[i] = elements[i - c.length];
        }
        return new ImmutableArrayList(newLst);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newLst = new Object[elements.length - 1];
        for (int i = 0; i < index; ++i) {
            newLst[i] = elements[i];
        }
        for (int i = index + 1; i < elements.length; ++i) {
            newLst[i-1] = elements[i];
        }
        return new ImmutableArrayList(newLst);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList newLst = this.remove(index);
        return newLst.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < elements.length; ++i) {
            if (elements[i] == e) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public Object[] toArray() {
        return elements;
    }
}
