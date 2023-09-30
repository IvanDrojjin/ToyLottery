package src.model;

import java.util.Comparator;

public class ToyComparatorByName <E extends Toy> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        int result = o1.getName().compareTo(o2.getName());
        return result;
    }
}