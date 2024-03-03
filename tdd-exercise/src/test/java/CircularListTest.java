import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import tdd.CircularList;

/**
 * The test suite for testing the CircularList implementation
 */
class CircularListTest {

    public CircularList list;

    @BeforeEach
    void BeforeEach() {
        this.list = new CircularList();
    }

    @Test
    void testAdd() {
        this.list.add(1);
        assertEquals(Optional.of(1), this.list.next());
    }

    @Test
    void testSize() {
        this.list.add(1);
        assertEquals(1, this.list.size());
    }

    @Test
    void testSizeWhenEmpty() {
        assertEquals(0, this.list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(this.list.isEmpty());
        this.list.add(1);
        assertFalse(this.list.isEmpty());
    }

    @Test
    void testNext() {
        this.list.add(1);
        assertEquals(Optional.of(1), this.list.next());
    }

    @Test
    void testNextWhenEmpty() {
        Optional<Integer> empty = Optional.empty();
        assertEquals(empty, this.list.next());
        assertNull(this.list.next().get());
    }

    @Test
    void textCircularNext() {
        this.list.add(1);
        this.list.add(2);
        this.list.next();
        this.list.next();
        assertEquals(Optional.of(1), this.list.next());
    }

    @Test
    void testPrevious() {
        this.list.add(1);
        this.list.add(2);
        this.list.next();
        assertEquals(Optional.of(1), this.list.previous());
    }

    @Test
    void testPreviousWhenEmpty() {
        Optional<Integer> empty = Optional.empty();
        assertEquals(empty, this.list.next());
        assertNull(this.list.next().get());
    }

    @Test
    void textCircularPrevious() {
        this.list.add(1);
        this.list.add(2);
        assertEquals(Optional.of(2), this.list.previous());
    }

    @Test
    void testReset() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        this.list.next();
        this.list.reset();
        assertEquals(Optional.of(1), this.list.next());
    }

}
