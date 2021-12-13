package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

public class NodeTest extends TestCase {
    Node node = new Node();
    Node prev = new Node();
    Node next = new Node();

    public void setUp() throws Exception {
        super.setUp();
        node.setValue(2);
        prev.setValue(1);
        next.setValue(3);
    }

    public void testTestToString() throws Exception {
        Object expected = "2";
        assertEquals(expected, node.toString());
    }

    public void testGetPrevious() {
        Object expected = "1";
        node.setPrevious(prev);
        assertEquals(expected, node.getPrevious().toString());
    }

    public void testSetPrevious() {
        Object expected = "1";
        node.setPrevious(prev);
        assertEquals(expected, node.getPrevious().toString());
    }

    public void testGetValue() {
        Object expected = 2;
        assertEquals(expected, node.getValue());
    }

    public void testSetValue() {
        Object expected = 1;
        node.setValue(1);
        assertEquals(expected, node.getValue());
    }

    public void testGetNext() {
        Object expected = "3";
        node.setPrevious(next);
        assertEquals(expected, node.getPrevious().toString());
    }

    public void testSetNext() {
        Object expected = "3";
        node.setPrevious(next);
        assertEquals(expected, node.getPrevious().toString());
    }
}