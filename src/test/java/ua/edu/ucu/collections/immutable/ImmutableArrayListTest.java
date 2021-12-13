package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import java.util.Arrays;

public class ImmutableArrayListTest extends TestCase {
    ImmutableArrayList list = new ImmutableArrayList(new Object[]{1, 2, 3});

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
}