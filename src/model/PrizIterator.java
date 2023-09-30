package src.model;

import java.util.Iterator;
import java.util.List;

public class PrizIterator <E> implements Iterator<E> {
    private int index;
    private List<E> prizList;

    public PrizIterator(List<E> PrizList) {
        this.prizList = prizList;
    }

    @Override
    public boolean hasNext() {
        return index < prizList.size();
    }
    @Override
    public E next() {
        return prizList.get(index++);
    }
}