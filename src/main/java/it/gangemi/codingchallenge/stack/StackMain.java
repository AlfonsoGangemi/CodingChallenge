package it.gangemi.codingchallenge.stack;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class StackMain {

    public static void main(String[] args) {
        final ArrayStack<Integer> integerArrayStack = new ArrayStack<>(5, Integer.class);
        final CompletableFuture<Void> asyncOut = CompletableFuture.runAsync(() -> IntStream.rangeClosed(1, 6).forEach(x -> out(integerArrayStack)));
        final CompletableFuture<Void> asyncIn = CompletableFuture.runAsync(() -> IntStream.rangeClosed(1, 6).forEach(x -> in(integerArrayStack, x)));
        CompletableFuture.allOf(asyncOut, asyncIn).join();
    }

    private static void in(ArrayStack<Integer> integerArrayStack, int x) {
        try {
            integerArrayStack.push(x);
            integerArrayStack.push(x * 7);
        } catch (FullStackException e) {
            System.err.println(e.getClass());
        }
    }

    private static void out(ArrayStack<Integer> integerArrayStack) {
        try {
            integerArrayStack.pull();
            integerArrayStack.peek();
        } catch (EmptyStackException e) {
            System.err.println(e.getClass());
        }
    }

}
