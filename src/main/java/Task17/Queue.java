package Task17;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Represents an unlimited queue of string elements.
 * Elements are added to the tail of the queue and removed from the head.
 */
public class Queue implements Iterable<String> {

    private Node head;
    private Node tail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue strings = (Queue) o;
        return Objects.equals(head, strings.head) && Objects.equals(tail, strings.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }

    // Nested class Node for representing elements of the queue
    private static final class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Adds a new element to the tail of the queue.
     *
     * @param data the string element to add
     */
    public void add(String data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    /**
     * Removes and returns the element at the head of the queue.
     *
     * @return the string element removed from the head of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public String remove() {
        if (head == null) {
            throw new IllegalStateException("Task17.Queue is empty");
        }
        String removedData = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return removedData;
    }

    /**
     * Returns an iterator over the elements in this queue.
     *
     * @return an iterator over the elements in this queue
     */
    @Override
    public Iterator<String> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<String> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String data = current.data;
            current = current.next;
            return data;
        }
    }
}
