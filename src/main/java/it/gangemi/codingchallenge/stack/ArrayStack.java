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
    synchronized
    public void push(T item) throws FullStackException {
        if (index >= items.length) throw new FullStackException();
        System.out.println(">>" + item);
        items[index++] = item;
    }

    @Override
    synchronized
    public T pull() throws EmptyStackException {
        if (index <= 0) throw new EmptyStackException();
        final T item = items[--index];
        System.out.println("<<" + item);
        return item;
    }

    @Override
    synchronized
    public T peek() throws EmptyStackException {
        if (index <= 0) throw new EmptyStackException();
        final T item = items[index - 1];
        System.out.println("==" + item);
        return item;
    }
}
