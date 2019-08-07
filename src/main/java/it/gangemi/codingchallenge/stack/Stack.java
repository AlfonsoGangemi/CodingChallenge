package it.gangemi.codingchallenge.stack;

public interface Stack<T> {

    void push(T item) throws FullStackException;

    T pull() throws EmptyStackException;

    T peek() throws EmptyStackException;

}
