package tdd2;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class IterableCircularListImpl implements  IterableCircularList {

    ArrayList<Integer> list;

    public IterableCircularListImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new CircularIterator<>(this.list);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new CircularIterator<>(new ArrayList<>(this.list.reversed()));
    }
 
    private class CircularIterator<T> implements Iterator<T> {

        final List<T> elements;
        int index = 0;

        public CircularIterator(List<T> elements) {
            this.elements = elements;
        }


        @Override
        public boolean hasNext() {
            return !elements.isEmpty();
        }

        @Override
        public T next() {
           T elem = elements.get(index);
           index = (index++) % elements.size();
           return elem;
        }
    }
}