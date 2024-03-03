import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Predicate;
import java.util.Optional;

import tdd3.FilterableCircularList;
import tdd3.FilterableCircularListImpl;

class FilterableCircularListTest {
    
    FilterableCircularList list;

    @BeforeEach
    void BeforeEach() {
        this.list = new FilterableCircularListImpl();
    }

    @Test
    void filterPositive() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        Predicate<Integer> greaterThanTwo = i -> (i > 2);

        assertEquals(Optional.of(3), this.list.filteredNext(greaterThanTwo));
    }

    @Test
    void filterNegative() {
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        Predicate<Integer> negative = i -> (i < 0);

        assertEquals(Optional.empty(), this.list.filteredNext(negative));
    }

    @Test
    void filterEmptyList() {
        Predicate<Integer> value = i -> (i == i);
        assertEquals(Optional.empty(), this.list.filteredNext(value));
    }
}
