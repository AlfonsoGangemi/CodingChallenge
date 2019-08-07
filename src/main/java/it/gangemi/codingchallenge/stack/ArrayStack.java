package it.gangemi.codingchallenge.stack;

import java.lang.reflect.Array;

public class ArrayStack<T> implements Stack<T> {

    int index;
    private T[] items;

    public ArrayStack(int capacity, Class<T> type) {
        items = (T[]) Array.newInstance(type, capacity);
        index = 0;
    }

    @Override
    public void push(T item) throws FullStackException {
        if (index >= items.length) throw new FullStackException();
        items[index++] = item;
    }

    @Override
    public T pull() throws EmptyStackException {
        if (index <= 0) throw new EmptyStackException();
        return items[--index];
    }

    @Override
    public T peek() throws EmptyStackException {
        if (index <= 0) throw new EmptyStackException();
        return items[index - 1];
    }
}
