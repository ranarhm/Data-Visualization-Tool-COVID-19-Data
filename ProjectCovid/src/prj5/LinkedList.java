package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedList Class
 *
 * @author Benjamin Rosenbloom (bprosenbloom@vt.edu)
 * @version 2021.11.18
 * @author Raena Rahimi Bafrani
 * @version 2021.11.18
 * @author Tejas Choudhary
 * @version 2021.11.18
 * 
 *          // Virginia Tech Honor Code Pledge:
 *          //
 *          // As a Hokie, I will conduct myself with honor and integrity at all
 *          times.
 *          // I will not lie, cheat, or steal, nor will I accept the actions
 *          // of those who do.
 *          // Your name: Group 51
 */

/**
 * This class inherits a lot of thought process from Labs 9 & 10.
 * Various methods seen inside this class we have created before and or we have
 * been tasked at making them previously within the year.
 * 
 * @author Benjamin Rosenbloom (bprosenbloom@vt.edu)
 * @version 2021.11.18
 * @author Raena Rahimi Bafrani (raenar@vt.edu)
 * @version 2021.11.18
 * @author Tejas Choudhary
 * @version 2021.11.18
 *
 * @param <T>
 * @version 2021.11.18
 *          Type the Linkedlist Will end up storing within it.
 */
public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;

    // Head of the Node
    private Node<T> tail;
    // Tail of the Node
    private int size;
    // Size field

    /**
     * Creates an empty linked list Constructor.
     */
    public LinkedList() {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        size = 0;
    }


    /**
     * Clears the list:
     * Head and tail reference null
     * size to 0.
     * 
     */
    public void clear() {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        size = 0;
    }


    /**
     * Method to check if list is empty
     * 
     * @return T/F based upon if size = 0.
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }


    /**
     * Returns the size field in the LinkedList
     * 
     * @return Number of elements within the LinkedList, aka Size.
     */
    public int size() {
        return this.size;
    }


    /**
     * Method to get object at any given position.
     *
     * @param index
     *            index in where the object is located at.
     * 
     * @return The Node/Object at the given position
     * 
     * @throws IndexOutOfBoundsException
     *             if no node exists at such index.
     */
    public T get(int index) {

        return getNodeAtIndex(index).getData();
    }


    /**
     * Private Helper Method
     * Gets the node at the specified Index
     * Similar Method to that of Lab 10 & 9.
     * 
     * @param index
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @return node at index
     */
    private Node<T> getNodeAtIndex(int index) {
        if (index < 0 || this.size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<T> current = head.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }


    /**
     * Adds a node to the end of the List.
     * 
     * @param obj
     *            data passed by user to be added.
     * 
     */
    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object Passed Was Null");
        }

        Node<T> enteredNode = new Node<T>(obj);
        Node<T> tempTail = head;
        // Temp Node which is before the tail, used to traverse.
        while (tempTail.getNext() != tail) {
            tempTail = tempTail.getNext();
        }
        tempTail.setNext(enteredNode);
        enteredNode.setNext(tail);
        size++;
    }


    /**
     * String Form of a LinkedList
     * Example Calling .toString:
     * {Ben, Test, cool, wow}
     * 
     * @return A String in the form of {} returned.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        Node<T> current = head.getNext();
        while (current != tail) {
            string.append(current.getData());
            current = current.getNext();
            if (current != tail) {
                string.append(", ");
            }
        }
        string.append("}");
        return string.toString();
    }


    /**
     * Returns True if both LinkedLists Contain the same elements.
     * 
     * @return T/F based upon if they're equal or not.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            LinkedList<T> other = (LinkedList<T>)obj;
            if (other.size() == this.size()) {
                Node<T> current = head.getNext();
                Node<T> otherCurrent = other.head.getNext();
                while (current != tail) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.getNext();
                    otherCurrent = otherCurrent.getNext();
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Sorts LinkedList Of Races Using Comparators
     * RE-CHECK COMPARATOR API
     * Breaks down sorting using two different Nodes and starts comparing using
     * the comparator functions.
     * 
     * @precondition size is greater than 1
     * 
     * @param comparator
     *            Comparator Used To Compare Items and Sort Algorithm
     */
    public void sortMethod(Comparator<T> comparator) {
        Node<T> unstoredNode = head.getNext().getNext();
        Node<T> sortedNode = head.getNext();
        sortedNode.setNext(null);

        while (unstoredNode != tail && unstoredNode != null) {
            Node<T> newNode = unstoredNode;

            unstoredNode = unstoredNode.getNext();

            T data = newNode.getData();

            Node<T> current = head.getNext();

            Node<T> previous = head;

            while ((current != null) && (comparator.compare(data, current
                .getData()) > 0)) {
                previous = current;
                current = current.getNext();
            }
            if (previous != head) {

                previous.setNext(newNode);

                newNode.setNext(current);
            }
            else {
                newNode.setNext(head.getNext());

                head.setNext(newNode);
            }

        }

    }


    /**
     * Creates an Iterator object.
     *
     * @return new Iterator Object below.
     */
    public Iterator<T> iterator() {
        return new ListIterator<T>();
    }

    /**
     * Node Class for LinkedList Implementation.
     * 
     * @author Benjamin Rosenbloom
     * @version 2021.11.18
     *
     * @param <T>
     *            Type the Node class will store.
     */
    public static class Node<T> {

        private T data;
        private Node<T> next;

        /**
         * Constructor Node with No next param.
         * 
         * @param data
         *            values of Nodes data passed.
         */
        public Node(T data) {
            this(data, null);
        }


        /**
         * Constructor with nextNode Param.
         * 
         * @param data
         *            values of Nodes passed.
         * @param nextNode
         *            NexNode of the New Node Passed.
         */
        public Node(T data, Node<T> nextNode) {
            this.data = data;
            this.next = nextNode;
        }


        /**
         * Return data field.
         * 
         * @return Nodes Data / Contents.
         */
        public T getData() {
            return this.data;
        }


        /**
         * Returns the next node in the sequence.
         * 
         * @return Next Node in sequence.
         */
        public Node<T> getNext() {
            return next;
        }


        /**
         * Sets the next Node to what the user wants.
         * 
         * @param nextNode
         *            The nextNode passed to be set.
         */
        public void setNext(Node<T> nextNode) {
            this.next = nextNode;
        }


        /**
         * Sets the Data at a specific location desired by user.
         * 
         * @param obj
         *            New Data being passed in to be set.
         */
        public void setData(T obj) {
            data = obj;
        }

    }


    /**
     * Iterator Implementation of LinkedList.
     * 
     * @author Benjamin Rosenbloom
     * @version 2021.11.18
     *
     * @param <T>
     *            The data Type to be stored in Iterator.
     */
    private class ListIterator<E> implements Iterator<T> {
        private Node<T> iterator;

        /**
         * Creates a ListIterator
         */
        public ListIterator() {
            iterator = head;

        }


        /**
         * Boolean Method to check if there are more elements left In List.
         *
         * @return T/F based upon if elements are left in List.
         */
        @Override
        public boolean hasNext() {
            // Checks if the iterators next value is not null, and checks
            // iterator is not at the tail value.
            return (iterator.getNext() != null && iterator.getNext() != tail);

        }


        /**
         * Next Value in the List.
         *
         * @return The Next Value in the list.
         * @throws NoSuchElementException
         *             If No Nodes are left.
         */
        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            else {
                iterator = iterator.getNext();
                return iterator.getData();
            }

        }

    }
}
