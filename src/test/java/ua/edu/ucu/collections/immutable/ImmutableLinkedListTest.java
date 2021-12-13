package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import java.util.Arrays;

public class ImmutableLinkedListTest extends TestCase {
    ImmutableLinkedList list = new ImmutableLinkedList(new Object[]{1, 2, 3});

    public void testAdd() {
        Object[] arr = new Object[] {1, 2, 3 ,4};
        String expected = Arrays.toString(arr);
        ImmutableList newLst = list.add(4);
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }

    public void testTestAdd() {
        Object[] arr = new Object[] {1, 2, 4, 3};
        String expected = Arrays.toString(arr);
        ImmutableList newLst = list.add(2, 4);
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }

    public void testAddAll() {
        Object[] arr = new Object[] {1, 2, 3, 4, 5};
        String expected = Arrays.toString(arr);
        ImmutableList newLst = list.addAll(new Object[]{4, 5});
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }

    public void testTestAddAll() {
        Object[] arr = new Object[] {1, 4, 5, 2, 3};
        String expected = Arrays.toString(arr);
        ImmutableList newLst = list.addAll(1, new Object[]{4, 5});
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }

    public void testGet() {
        Object expected = 1;
        assertEquals(expected, list.get(0));
    }

    public void testRemove() {
        Object[] arr = new Object[] {1, 2};
        String expected = Arrays.toString(arr);
        ImmutableList newLst = list.remove(2);
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }

    public void testSet() {
        Object[] arr = new Object[] {1, 2, 4};
        String expected = Arrays.toString(arr);
        ImmutableList newLst = list.set(2, 4);
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }

    public void testIndexOf() {
        Object expected = 1;
        assertEquals(expected, list.indexOf(2));
    }

    public void testSize() {
        Object expected = 3;
        assertEquals(expected, list.size());
    }

    public void testClear() {
        Object[] arr = new Object[]{};
        String expected = Arrays.toString(arr);
        ImmutableList newLst = list.clear();
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }

    public void testIsEmpty() {
        boolean expected = false;
        assertEquals(expected, list.isEmpty());
    }

    public void testToArray() {
        Object[] arr = new Object[] {1, 2, 3};
        String expected = Arrays.toString(arr);
        assertEquals(expected, Arrays.toString(list.toArray()));
    }

    public void testAddFirst() {
        Object[] arr = new Object[] {4, 1, 2, 3};
        String expected = Arrays.toString(arr);
        ImmutableLinkedList newLst = list.addFirst(4);
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }

    public void testAddLast() {
        Object[] arr = new Object[] {4, 1, 2, 3};
        String expected = Arrays.toString(arr);
        ImmutableLinkedList newLst = list.addFirst(4);
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }

    public void testGetHead() {
        Node node = new Node();
        node.setValue(1);
        Object expected = "1";
        assertEquals(expected, list.getHead().toString());
    }

    public void testGetTail() {
        Node node = new Node();
        node.setValue(3);
        Object expected = "3";
        assertEquals(expected, list.getTail().toString());
    }

    public void testGetFirst() {
        Object expected = 1;
        assertEquals(expected, list.getFirst());
    }

    public void testGetLast() {
        Object expected = 3;
        assertEquals(expected, list.getLast());
    }

    public void testRemoveFirst() {
        Object[] arr = new Object[] {2, 3};
        String expected = Arrays.toString(arr);
        ImmutableLinkedList newLst = list.removeFirst();
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }

    public void testRemoveLast() {
        Object[] arr = new Object[] {1, 2};
        String expected = Arrays.toString(arr);
        ImmutableLinkedList newLst = list.removeLast();
        assertEquals(expected, Arrays.toString(newLst.toArray()));
    }
}