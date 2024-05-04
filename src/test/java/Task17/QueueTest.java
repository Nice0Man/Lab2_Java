package Task17;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void add_test() {
        Queue queue = new Queue();

        // Add elements to the queue
        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        // Check if elements are added correctly
        assertEquals("First", queue.remove());
        assertEquals("Second", queue.remove());
        assertEquals("Third", queue.remove());
    }

    @Test
    void remove_assert_throws_test() {
        Queue queue = new Queue();
        // Remove from an empty queue
        assertThrows(IllegalStateException.class, queue::remove);
    }

    @Test
    void remove_test() {
        Queue queue = new Queue();

        queue.add("One");
        queue.add("Two");
        queue.add("Three");

        assertEquals("One", queue.remove());
        assertEquals("Two", queue.remove());
        assertEquals("Three", queue.remove());
    }

    @Test
    void iterator_test() {
        Queue queue = new Queue();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        Iterator<String> iterator = queue.iterator();
        assertNotNull(iterator);

        assertTrue(iterator.hasNext());
        assertEquals("First", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Second", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Third", iterator.next());

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void iterator_in_for_loop_test() {
        Queue queue = new Queue();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");

        int count = 0;
        for (String element : queue) {
            switch (count) {
                case 0:
                    assertEquals("First", element);
                    break;
                case 1:
                    assertEquals("Second", element);
                    break;
                case 2:
                    assertEquals("Third", element);
                    break;
                default:
                    fail(STR."Unexpected element: \{element}");
            }
            count++;
        }
        assertEquals(3, count);
    }
}
