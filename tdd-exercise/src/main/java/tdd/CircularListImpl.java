package tdd;

import java.util.ArrayList;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private int index;
    private ArrayList<Integer> list;

    public CircularListImpl() {
        this.index = 0;
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
    public Optional<Integer> next() {
        if (this.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(this.list.get(this.index++ % this.size()));
    }

    @Override
    public Optional<Integer> previous() {
        if (this.isEmpty()) {
            return Optional.empty();
        }

        this.index = (this.index == 0) ? this.list.size() - 1 : this.index - 1;
        return Optional.of(this.list.get(this.index % this.size()));
    }

    @Override
    public void reset() {
        this.index = 0;
    }
    
}
