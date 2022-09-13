package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Test class for LinkedList.
 * 
 * @author Ben Rosenbloom
 * @version 2021.11.18
 * @author Raena Rahimi Bafrani (raenar@vt.edu)
 * @version 2021.11.18
 * @author Tejas Choudhary
 * @version 2021.11.18
 */
public class LinkedListTest extends TestCase {
    private LinkedList<String> emptyList;
    private LinkedList<String> smallList;
    private LinkedList<String> bigList;
    private Iterator<String> iter;

    /**
     * Initializes empty list, lists with a small number of items, and
     * list with a large number of items
     */
    public void setUp() {
        emptyList = new LinkedList<String>();
        smallList = new LinkedList<String>();

        smallList.add("A");
        smallList.add("B");
        smallList.add("C");

        bigList = new LinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigList.add("D" + i);
        }

    }


    /**
     * Tests clear method
     */
    public void testClear() {
        smallList.clear();
        assertEquals(smallList.size(), 0);
    }


    /**
     * Tests isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(emptyList.isEmpty());

        assertFalse(smallList.isEmpty());
        smallList.clear();
        assertTrue(smallList.isEmpty());
    }


    /**
     * Tests size method
     */
    public void testSize() {
        assertEquals(emptyList.size(), 0);
        assertEquals(smallList.size(), 3);
        assertEquals(bigList.size(), 100);
    }


    /**
     * Tests get method at index
     */
    public void testGet() {
        Exception thrown = null;
        try {
            emptyList.get(1);
        }
        catch (Exception exception) {

            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        Exception thrown1 = null;
        try {
            smallList.get(-1);
        }
        catch (Exception e) {

            thrown1 = e;
        }
        assertNotNull(thrown1);
        assertTrue(thrown1 instanceof IndexOutOfBoundsException);

        assertEquals(smallList.get(0), "A");
        assertEquals(smallList.get(1), "B");

        assertEquals(bigList.get(10), "D10");
    }


    /**
     * Tests add method
     */
    public void testAdd() {
        String nullObject = null;
        Exception thrown = null;
        try {
            emptyList.add(nullObject);
        }
        catch (Exception exception) {

            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        smallList.add("E");
        assertEquals(smallList.get(3), "E");
        assertEquals(smallList.size(), 4);

        emptyList.add("A");
        assertEquals(emptyList.size(), 1);
    }


    /**
     * Tests toString method
     */
    public void testToString() {
        assertEquals(emptyList.toString(), "{}");
        assertEquals(smallList.toString(), "{A, B, C}");

        smallList.add("E");
        assertEquals(smallList.toString(), "{A, B, C, E}");
    }


    /**
     * Tests equals method
     */
    public void testEquals() {
        assertTrue(emptyList.equals(emptyList));

        LinkedList<String> emptyListA = new LinkedList<String>();
        assertTrue(emptyList.equals(emptyListA));

        LinkedList<String> nullList = null;
        assertFalse(emptyList.equals(nullList));

        Object obj = new Object();
        assertFalse(emptyList.equals(obj));

        assertFalse(emptyList.equals(smallList));

        for (int i = 0; i < 100; i++) {
            emptyList.add("A");
        }
        assertFalse(emptyList.equals(bigList));

        emptyList.clear();
        emptyList.add("A");
        emptyList.add("B");
        emptyList.add("C");
        assertTrue(emptyList.equals(smallList));
    }


    /**
     * Tests hasNext method from iterator
     */
    public void testHasNext() {
        iter = emptyList.iterator();
        assertFalse(iter.hasNext());
        emptyList.add("A");
        emptyList.add("B");
        assertTrue(iter.hasNext());
        iter.next();
        iter.next();
        assertFalse(iter.hasNext());

    }


    /**
     * Tests next method from iterator
     */
    public void testNext() {
        iter = emptyList.iterator();
        Exception thrown = null;
        try {
            iter.next();
        }
        catch (NoSuchElementException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof NoSuchElementException);

        emptyList.add("A");
        emptyList.add("B");
        assertEquals(iter.next(), "A");
        assertEquals(iter.next(), "B");

        Exception thrown1 = null;
        try {
            iter.next();
        }
        catch (NoSuchElementException exception) {
            thrown1 = exception;
        }
        assertNotNull(thrown1);
        assertTrue(thrown1 instanceof NoSuchElementException);

    }
}
