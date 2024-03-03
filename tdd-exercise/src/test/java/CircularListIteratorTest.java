import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import tdditerator.CircularListIterator;

class CircularListIteratorTest {
    
    private CircularListIterator list;

    @BeforeEach
    void BeforeEach() {
        this.list = null;
    }

    @Test
    void testAdd() {
        this.list.add(1);
        assertEquals(1, this.list.size());
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
    void forwardIterator() {
        this.list.add(1);
        assertEquals(1, this.list.forwardIterator().next());
    }

    @Test
    void emptyForwardIterator() {
        assertFalse(this.list.forwardIterator().hasNext());
    }

    @Test 
    void circularForwardIterator() {
        this.list.add(1);
        this.list.add(2);
        
        Iterator<Integer> forwardIterator = this.list.forwardIterator();
        forwardIterator.next();
        forwardIterator.next();

        assertEquals(1, forwardIterator.next());
    }

    @Test
    void backwardIterator() {
        this.list.add(1);
        assertEquals(1, this.list.backwardIterator().next());
    }

    @Test
    void emptyBackwardIterator() {
        this.list.add(1);
        assertFalse(this.list.forwardIterator().hasNext());
    }

    @Test 
    void circularBackwardIterator() {
        this.list.add(1);
        this.list.add(2);
        
        Iterator<Integer> backwardIterator = this.list.backwardIterator();
        backwardIterator.next();

        assertEquals(2, backwardIterator.next());
    }
    
}
