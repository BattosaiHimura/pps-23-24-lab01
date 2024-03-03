package tdd3;

import java.util.Optional;
import java.util.function.Predicate;

import tdd.CircularList;

public interface FilterableCircularList extends CircularList {
    
    /**
     * Provides the next element of the list that satisfies the given condition.
     * @return the next element of the list that satisfies the condition, or an empty optional if no such element is found
     */
    Optional<Integer> filteredNext(Predicate<?> predicate);
}
