package org.btmn;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BooleanArray {

    private int size;
    private int set;

    public BooleanArray(int size) {
        this.size = size;
    }

    public boolean get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return (set & (1 << index)) != 0;
    }

    public void set(int index, boolean value) {
        if (index >= size) throw new IndexOutOfBoundsException();
        if (value) set |= (1 << index);
        else set &= ~(1 << index);
    }

    @Override
    public String toString() {
        return IntStream.range(0, size).mapToObj(this::get).map(String::valueOf).collect(Collectors.joining(","));
    }
}
