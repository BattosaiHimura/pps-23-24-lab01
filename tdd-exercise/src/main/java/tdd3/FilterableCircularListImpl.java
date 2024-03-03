package tdd3;

import java.util.Optional;
import java.util.function.Predicate;

import tdd.CircularList;
import tdd.CircularListImpl;

public class FilterableCircularListImpl implements FilterableCircularList {

    CircularList circularList;

    public FilterableCircularListImpl() {
        this.circularList = new CircularListImpl();
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return this.circularList.next();
    }

    @Override
    public Optional<Integer> previous() {
        return this.circularList.previous();
    }

    @Override
    public void reset() {
        this.circularList.reset();
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {

        if(this.circularList.isEmpty()) {
            return Optional.empty();
        }

        for (int i = 0; i <= this.circularList.size(); i++) {
            Optional<Integer> value = this.circularList.next();

            if (value.isPresent() && predicate.test(value.get())) {
                return value;
            }
        }

        return Optional.empty();
    }
    
}
